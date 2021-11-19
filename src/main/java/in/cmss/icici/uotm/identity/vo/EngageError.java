package in.cmss.icici.uotm.identity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import in.cmss.icici.uotm.core.database.ErrorMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Engage Error in UOTM")
public class EngageError {

	@Schema(description = "Error code")
	private Integer code; // internal code (numeric) representation

	@JsonProperty(value = "msg")
	@Schema(description = "Error message")
	private String message; // generally to be shown to the as response message title

	@JsonProperty(value = "desc")
	@Schema(description = "Error description")
	private String description; // generally to be shown to the as response message
								// description

	@JsonProperty(value = "reso")
	@Schema(description = "Error Resolution")
	private String resolution; // suggestion to be shown to User

	public static EngageError toError(ErrorMessage error) {
		return EngageError.builder()
				.code(error.getCode())
				.description(error.getDescription())
				.message(error.getMessage())
				.resolution(error.getResolution())
				.build();
	}

	public static class Codes {
		public static class Device {
			public static final String REQUIRED = "110001";
			public static class Id {
				public static final String REQUIRED = "100102";
			}
			public static class NotificationId {
				public static final String REQUIRED = "100103";
			}
		}

		public static class Login {
			public static class Username {
				public static final String REQUIRED = "100101";
				public static final String PATTERN = "100102";
			}

			public static class Password {
				public static final String REQUIRED = "100201";
				public static final String PATTERN = "100202";
			}
		}
	}

}
