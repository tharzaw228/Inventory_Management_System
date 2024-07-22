package spring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.dto.CategoryDto;
import spring.dto.UserDto;
import spring.model.Category;
import spring.model.User;
import spring.repository.CategoryRepository;
import spring.utils.Status;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value="/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/add_category", method = RequestMethod.GET)
	public ModelAndView showRegister(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("res");
		if (userDto == null) {
			return new ModelAndView("redirect:/");
		} else {
			ModelAndView modelAndView = new ModelAndView("category_add");
			modelAndView.addObject("category", new Category());
			return modelAndView;
		}
	}

	@PostMapping(value="/do_category")
	public String registerCategory(@ModelAttribute("category") @Valid CategoryDto categoryDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryRepository.showAllCategories());
			return "category_add";
		}

		if (categoryDto.getCategoryName() == null ||
				categoryDto.getDescription() == null) {
			model.addAttribute("error", "Invalid!");
			return "category_add";
		}

		try {
			int result = categoryRepository.insertCategory(categoryDto);
			if (result > 0) {
				return "redirect:/category/showcategories";
			} else {
				model.addAttribute("error", "Failed to register category. Please try again.");
				return "category_add";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Error: " + e.getMessage());
			return "category_add";
		}
	}

	@GetMapping(value = "/showcategories")
	public String showAllCategories(Model model) {
		List<CategoryDto> categoryDtos = categoryRepository.showAllCategories();
		model.addAttribute("categoryDtoList", categoryDtos);
		return "category_list";
	}

	@GetMapping(value = "/editcategory/{id}")
	public String showCategoryById(@PathVariable("id") Long id, Model model) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(id);

		CategoryDto dto = categoryRepository.showCategory(categoryDto);

		Category category = modelMapper.map(dto, Category.class);

		model.addAttribute("category", category);
		return "category_update";
	}


	@PostMapping(value = "/doupdate")
	public String updateCategory(@ModelAttribute("category") Category category) {
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);

		int i = categoryRepository.updateCategory(categoryDto);
		if (i > 0) {
			return "redirect:/category/showcategories";
		} else {
			return "redirect:editcategory/" + categoryDto.getId();
		}
	}

	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long id, Model model) {
		return null;
	}
}
