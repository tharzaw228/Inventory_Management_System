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
import spring.dto.ProductDto;
import spring.dto.RoleDto;
import spring.dto.UserDto;
import spring.model.Category;
import spring.model.Product;
import spring.model.User;
import spring.repository.CategoryRepository;
import spring.repository.ProductRepository;
import spring.utils.Status;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/add_product", method = RequestMethod.GET)
	public ModelAndView showRegister(Model model, HttpSession session) {

		UserDto userDto = (UserDto) session.getAttribute("res");
		if (userDto == null) {
			return new ModelAndView("redirect:/");
		} else {
			ModelAndView modelAndView = new ModelAndView("product_add");
			modelAndView.addObject("product", new Product());
			modelAndView.addObject("categories", categoryRepository.showAllCategories());
			return modelAndView;
		}
	}

	@PostMapping(value="/do_product")
	public String registerProduct(@ModelAttribute("product") @Valid ProductDto productDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("products", productRepository.showAllProducts());
			return "product_add";
		}

		if (productDto.getProductName() == null ||
				productDto.getCategoryId() == null) {
			model.addAttribute("error", "Invalid!");
			return "product_add";
		}

		try {
			int result = productRepository.insertProduct(productDto);
			if (result > 0) {
				return "redirect:/product/showproducts";
			} else {
				model.addAttribute("error", "Failed to register product. Please try again.");
				return "product_add";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Error: " + e.getMessage());
			return "product_add";
		}
	}

	@GetMapping(value = "/showproducts")
	public String showAllProducts(Model model) {
		List<ProductDto> productDtos = productRepository.showAllProducts();
		model.addAttribute("productDtoList", productDtos);
		return "product_list";
	}

	@GetMapping(value = "/editproduct/{id}")
	public String showProductById(@PathVariable("id") Long id, Model model) {
		ProductDto productDto = new ProductDto();
		productDto.setId(id);

		ProductDto dto = productRepository.showProduct(productDto);

		Product product = modelMapper.map(dto, Product.class);

		model.addAttribute("product", product);
		return "product_update";
	}


	@PostMapping(value = "/doupdate")
	public String updateProduct(@ModelAttribute("product") Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);

		int i = productRepository.updateProduct(productDto);
		if (i > 0) {
			return "redirect:/product/showproducts";
		} else {
			return "redirect:editproduct/" + productDto.getId();
		}
	}

	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		return null;
	}

	@ModelAttribute("categories")
	public List<CategoryDto> getCategories() {
		List<CategoryDto> categoryDtos = categoryRepository.showAllCategories().stream()
				.map(category -> new CategoryDto(category.getId(), category.getCategoryName(), category.getDescription())).collect(Collectors.toList());
		return categoryDtos;
	}
	
	@ModelAttribute("uom")
	public List<String> getUoms()
	{
		List<String> uoms = new ArrayList<>();
		uoms.add("KG");
		uoms.add("Bag");
		uoms.add("EA");
		uoms.add("Box");
		uoms.add("Bottle");
		return uoms;
	}
}
