package in.cmss.icici.uotm.identity.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Employee's Office related details")
public class EmployeeOffice {

	@JsonProperty("lat")
	@Schema(description = "Employee's Office location latitude")
	private float latitude;

	@JsonProperty("lng")
	@Schema(description = "Employee's Office location longitude")
	private float longitude;

	@JsonProperty("out_time_from")
	@Schema(description = "Employee's Office in time")
	private LocalTime from;

	@JsonProperty("out_time_to")
	@Schema(description = "Employee's Office out time")
	private LocalTime to;
	
	@Schema(description = "Region/state of employee location")
	private String state;
}
