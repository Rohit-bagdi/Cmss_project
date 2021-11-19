package in.cmss.icici.uotm.identity.vo.device;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class RegisteredDeviceVO {

	@JsonProperty("emp_id")
	@Schema(description = "Employee office details")
	private String employeeId;

	@Schema(description = "Employee office details")
	private String id;

	@Schema(description = "Employee office details")
	private String type;

	@Schema(description = "Employee office details")
	private String model;

	@JsonProperty("noti_id")
	@Schema(description = "Employee office details")
	private String notificationId;
}
