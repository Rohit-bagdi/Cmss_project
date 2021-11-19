package in.cmss.icici.uotm.identity.vo.pin.reset;

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
public class ResetPinResponseVO {

	@Schema(description = "message for successful registration")
	@JsonProperty("msg")
	private String message;

	@Schema(description = "pin for successful creation")
	private String pin;

}
