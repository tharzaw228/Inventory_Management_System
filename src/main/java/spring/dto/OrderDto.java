package spring.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private Long id;
	private LocalDate orderDate;
	private double totalAmount;
	private String status;
	private String customer;
	private Long userId;
}
