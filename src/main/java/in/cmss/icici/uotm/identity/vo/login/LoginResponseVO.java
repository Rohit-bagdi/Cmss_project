package in.cmss.icici.uotm.identity.vo.login;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import in.cmss.icici.uotm.identity.vo.Employee;
import in.cmss.icici.uotm.identity.vo.EmployeeOffice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Schema(description = "Login Response")
public class LoginResponseVO {

	@Schema(description = "last logged in time of the user")
	@JsonProperty("llt")
	private LocalDateTime lastLoginTime;

	@Schema(description = "Menu Authentication Codes for client")
	@JsonProperty("mac")
	private List<String> menuAuthCodes;

	@Schema(description = "Employee's details")
	private Employee employee;

	@Schema(description = "Employee office details")
	private EmployeeOffice office;
}
