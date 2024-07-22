package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.utils.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private Status status;
	private Long roleId;
	private String roleName;
}
