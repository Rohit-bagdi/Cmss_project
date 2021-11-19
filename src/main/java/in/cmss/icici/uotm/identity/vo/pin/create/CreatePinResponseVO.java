package in.cmss.icici.uotm.identity.vo.pin.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import in.cmss.icici.uotm.identity.vo.Employee;
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
public class CreatePinResponseVO {

	@Schema(description = "message for successful PIN creation")
	@JsonProperty("msg")
	private String message;

	@Schema(description = "pin for successful creation")
	private String pin;

	@Schema(description = "Employee's details")
	private Employee employee;

}
