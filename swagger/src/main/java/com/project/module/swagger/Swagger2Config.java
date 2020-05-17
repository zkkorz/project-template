package com.project.module.swagger;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Autowired
	private Environment env;
	
	/**
	 * Swagger不解析的接口参数类型
	 */
	private static Class<?>[] ignoreClasses = {
			HttpServletRequest.class,
			HttpServletResponse.class,
			HttpSession.class,
			StandardMultipartHttpServletRequest.class
	};

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(ignoreClasses)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }
    
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().validatorUrl("").build();
    }
    private ApiInfo apiInfo() {
		Contact contact = new Contact("ynairways","http://www.ynairways.com","admin@ynairways.com");
    	String path = env.getProperty("server.servlet.context-path");
    	if(StringUtils.isEmpty(path)) {
    		path="/api";
    	}
		String domain=env.getProperty("spring.jmx.default-domain");
    	if(StringUtils.isEmpty(domain)) {
    		path="api";
			domain = "";
    	}
        return new ApiInfoBuilder()
                .title("RESTful APIs for "+"Tims-"+domain.toUpperCase()+" App")
                .description("api根地址：http://dev.ynairways.com"+path)
                .termsOfServiceUrl("https://www.ynairways.com/")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
