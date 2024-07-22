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
import spring.model.User;
import spring.repository.RoleRepository;
import spring.repository.UserRepository;
import spring.utils.Status;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView showRegister(Model model, HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute("res");
        if (userDto == null) {
            return new ModelAndView("redirect:/");
        } else {
            ModelAndView modelAndView = new ModelAndView("user_add");
            modelAndView.addObject("user", new User());
			model.addAttribute("statuses", Status.values());
            modelAndView.addObject("roles", roleRepository.showAllRoles());
            return modelAndView;
        }
    }

	@PostMapping(value="/do_user")
	public String registerUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("users", userRepository.showAllUsers());
			return "user_add";
		}

		if (userDto.getUsername() == null ||
				userDto.getEmail() == null ||
				userDto.getPassword() == null ||
				userDto.getPhoneNumber() == null ||
				userDto.getRoleId() == 0) {
			model.addAttribute("error", "Invalid!");
			return "user_add";
		}

		try {
			int result = userRepository.insertUser(userDto);
			if (result > 0) {
				return "redirect:/user/showusers";
			} else {
				model.addAttribute("error", "Failed to register user. Please try again.");
				return "user_add";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Error: " + e.getMessage());
			return "user_add";
		}
	}

    @GetMapping(value = "/showusers")
    public String showAllUsers(Model model) {
        List<UserDto> userDtos = userRepository.showAllUsers();
        model.addAttribute("userDtoList", userDtos);
        return "user_list";
    }

    @GetMapping(value = "/edituser/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        UserDto dto = userRepository.showUser(userDto);
        User user = modelMapper.map(dto, User.class);
        model.addAttribute("user", user);
        model.addAttribute("statuses", Status.values());
        return "user_update";
    }


    @PostMapping(value = "/doupdate")
    public String updateUser(@ModelAttribute("user") User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        int i = userRepository.updateUser(userDto);
        if (i > 0) {
            return "redirect:/user/showusers";
        } else {
            return "redirect:edituser/" + userDto.getId();
        }
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        return null;
    }

    @ModelAttribute("roles")
    public List<RoleDto> getUserRoles() {
        List<RoleDto> roleDtos = roleRepository.showAllRoles().stream()
                .map(roles -> new RoleDto(roles.getId(), roles.getRoleName())).collect(Collectors.toList());
        return roleDtos;
    }
}
