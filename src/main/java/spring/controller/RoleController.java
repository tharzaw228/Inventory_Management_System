package spring.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.dto.RoleDto;
import spring.dto.UserDto;
import spring.model.Role;
import spring.model.User;
import spring.repository.RoleRepository;
import spring.utils.Status;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value="/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/add_role", method = RequestMethod.GET)
    public ModelAndView showRegister(Model model, HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("res");
        if (userDto == null) {
            return new ModelAndView("redirect:/");
        } else {
            ModelAndView modelAndView = new ModelAndView("role_add");
            modelAndView.addObject("role", new Role());
            return modelAndView;
        }
    }

    @PostMapping(value="/do_role")
    public String registerRole(@ModelAttribute("role") @Valid RoleDto roleDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.showAllRoles());
            return "role_add";
        }

        if (roleDto.getRoleName() == null) {
            model.addAttribute("error", "Invalid!");
            return "role_add";
        }

        try {
            int result = roleRepository.insertRole(roleDto);
            if (result > 0) {
                return "redirect:/role/showroles";
            } else {
                model.addAttribute("error", "Failed to register role. Please try again.");
                return "role_add";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
            return "role_add";
        }
    }

    @GetMapping(value = "/showroles")
    public String showAllRoles(Model model) {
        List<RoleDto> roleDtos = roleRepository.showAllRoles();
        model.addAttribute("roleDtoList", roleDtos);
        return "role_list";
    }

    @GetMapping(value = "/editrole/{id}")
    public String showRoleById(@PathVariable("id") Long id, Model model) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(id);

        RoleDto dto = roleRepository.showRole(roleDto);

        Role role = modelMapper.map(dto, Role.class);

        model.addAttribute("role", role);
        return "role_update";
    }


    @PostMapping(value = "/doupdate")
    public String updateRole(@ModelAttribute("role") Role role) {
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);

        int i = roleRepository.updateRole(roleDto);
        if (i > 0) {
            return "redirect:/role/showroles";
        } else {
            return "redirect:editrole/" + roleDto.getId();
        }
    }

    @RequestMapping(value = "/deleterole/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable("id") Long id, Model model) {
        return null;
    }
}
