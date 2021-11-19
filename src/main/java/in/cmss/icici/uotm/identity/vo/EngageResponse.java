package in.cmss.icici.uotm.identity.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Engage Response")
public class EngageResponse {

	@JsonProperty("msg")
	@Schema(description = "message to client if any")
	private String message;

	@Schema(description = "List of errors if any")
	private List<EngageError> error;

}
