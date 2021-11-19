package in.cmss.icici.uotm.identity.vo.device;

import java.util.List;

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
public class DeviceResponseVO {

	@Schema(description = "Employee office details")
	private List<RegisteredDeviceVO> devices;
}
