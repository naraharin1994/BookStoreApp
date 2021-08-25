package com.Book.BookStore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.
				basePackage("com.Book.BookStore"))
				.paths(PathSelectors.any()).build().pathMapping("/");
	}
	
	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Narahari", "http://blueYonder.com", "narahari.n@blueYonder.com");
		return new ApiInfoBuilder().title("BookStore API")
				.description("Swagger API for BookStore").version("1.0.0-SNAPSHOT")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
				.build();
	}
}
