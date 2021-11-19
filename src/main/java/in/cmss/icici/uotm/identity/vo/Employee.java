package in.cmss.icici.uotm.identity.vo;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@RedisHash
@Builder
@Data
@Schema(description = "Employee's details")
public class Employee {

	@Schema(description = "Employee's ID")
	private int id;

	@JsonProperty("user_id")
	@Schema(description = "Employee's User ID")
	private String userID;

	@Schema(description = "Employee's name")
	private String name;

	@Schema(description = "Employee's grade")
	private int grade;

	@Schema(description = "Employee's type")
	private String type;
}
