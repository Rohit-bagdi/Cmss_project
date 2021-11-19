package in.cmss.icici.uotm.identity.vo.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import in.cmss.icici.uotm.identity.vo.Device;
import in.cmss.icici.uotm.identity.vo.EngageError;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Login Request")
public class LoginRequestVO {

	@NotBlank(message = EngageError.Codes.Login.Username.REQUIRED)
	@Pattern(regexp = "[a-z-A-Z]{6,12}", message = EngageError.Codes.Login.Username.PATTERN)
	@Schema(description = "User's Login username")
	private String username;

	@NotBlank(message = EngageError.Codes.Login.Password.REQUIRED)
	@Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = EngageError.Codes.Login.Password.PATTERN)
	@Schema(description = "User's Login password")
	private String password;

	@NotNull(message = EngageError.Codes.Device.REQUIRED)
	@Schema(description = "User's device information")
	private Device device;
}
