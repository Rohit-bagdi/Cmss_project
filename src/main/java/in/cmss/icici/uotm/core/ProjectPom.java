package in.cmss.icici.uotm.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("app")
@Data
public class ProjectPom {
	private String name;
	private String description;
	private String version;
}
