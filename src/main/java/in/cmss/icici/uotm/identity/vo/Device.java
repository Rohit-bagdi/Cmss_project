package in.cmss.icici.uotm.identity.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(description = "User's Device Information")
public class Device {

	@NotBlank(message = EngageError.Codes.Device.Id.REQUIRED)
	@Schema(description = "Device Identifier")
	private String id;

	@JsonProperty("noti_id")
	@NotBlank(message = EngageError.Codes.Device.NotificationId.REQUIRED)
	@Schema(description = "Device's current 'FCM' token")
	private String nodtificationId;

}
