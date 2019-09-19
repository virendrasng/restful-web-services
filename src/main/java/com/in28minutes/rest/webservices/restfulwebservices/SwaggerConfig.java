package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * To access swagger page - http://localhost:8080/swagger-ui.html#/
 * 
 * @author viren
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final Contact DEFAULT_CONTACT = new Contact("Virendra Singh", "http://self.com",
			"singh_recrkl@rediffmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("My Api Documentation", "My Api Documentation", "2.0",
			"urn:tos", DEFAULT_CONTACT, "My Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_CONSUMES_PRODUCES = new HashSet<>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).host("gggggghhhhhhh")
				.pathProvider(new RelativePathProvider(null) {
			@Override
			public String getApplicationBasePath() {
				return "/gotIt";
			}
		}).select()
				// apis methos does not consider sub folders/packages - 75%
		          .apis(RequestHandlerSelectors.basePackage("com.in28minutes.rest.webservices.restfulwebservices"))
		          //.apis(RequestHandlerSelectors.basePackage("com.in28minutes.rest.webservices.restfulwebservices.exceptions.handler"))
		        //  .paths(PathSelectors.any())
		          .build().apiInfo(DEFAULT_API_INFO).produces(DEFAULT_CONSUMES_PRODUCES)
					.consumes(DEFAULT_CONSUMES_PRODUCES);
	}

	// @Bean
	// public Docket api() throws IOException, XmlPullParserException {
	// MavenXpp3Reader reader = new MavenXpp3Reader();
	// Model model = reader.read(new FileReader("pom.xml"));
	// return new Docket(DocumentationType.SWAGGER_2)
	// .select()
	// .apis(RequestHandlerSelectors.basePackage("pl.piomin.microservices.advanced.account.api"))
	// .paths(PathSelectors.any())
	// .build().apiInfo(new ApiInfo("Account Service Api Documentation",
	// "Documentation automatically generated", model.getParent().getVersion(),
	// null, new Contact("Piotr Mińkowski", "piotrminkowski.wordpress.com",
	// "piotr.minkowski@gmail.com"), null, null));
	// }
}
