package spring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.repository.OrderDetailRepository;
import spring.repository.OrderRepository;
import spring.repository.ProductRepository;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value="/orderdetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;


}
