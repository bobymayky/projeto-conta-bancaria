package br.com.contabancaria.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.contabancaria"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Conta bancária Rest API",
						   "Esta API é destinada à consulta e gerenciamento de conta bancária.", 
						   "1.0.0", 
						   "Termos de Serviço",
						   new Contact("Boby Mayky", "www.contabancaria.com.br", "contabancaria@gmail.com"),
						   "Licença de uso da API", "API license URL", Collections.emptyList());
	}
}
