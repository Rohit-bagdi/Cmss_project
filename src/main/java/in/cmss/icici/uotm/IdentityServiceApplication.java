package in.cmss.icici.uotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.cmss.icici.uotm.core.ProjectPom;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class IdentityServiceApplication {

	@Bean
	public Components openApiComponents() {
		SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
				.bearerFormat("JWT");

		return new Components().addSecuritySchemes("Bearer", securityScheme);
	}

	@Bean
	public ExternalDocumentation openApiDocs(ProjectPom pom) {
		return new ExternalDocumentation().description(String.format("%s Wiki Documentation", pom.getName()))
				.url("https://springshop.wiki.github.org/docs");
	}

	@Bean
	public Info openApiInfo(ProjectPom pom) {
		License license = new License().name("Apache 2.0").url("http://springdoc.org");

		Contact contact = new Contact().email("suraj.singh@cmss.in").name("Suraj Singh")
				.url("http://ec2-13-233-197-155.ap-south-1.compute.amazonaws.com/suraj.singh");

		return new Info().contact(contact).description(pom.getDescription()).license(license)
				.title(String.format("%s API", pom.getName())).termsOfService("http://swagger.io/terms/")
				.version(String.format("v%s", pom.getVersion()));
	}

	@Bean
	public OpenAPI openApi(ExternalDocumentation externalDocs, Info info) {
		return new OpenAPI().components(openApiComponents()).externalDocs(externalDocs).info(info);
	}

	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceApplication.class, args);
	}
}
