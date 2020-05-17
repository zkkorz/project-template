package com.project.module.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;

@Component
@Primary
public class SwaggerDubboPlugin extends InMemorySwaggerResourcesProvider {

	@Value("${ark.swagger.dubbo.doc:swagger-dubbo}")
	private String path;
	public SwaggerDubboPlugin(Environment environment, DocumentationCache documentationCache) {
		super(environment, documentationCache);
	}

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> list = super.get();
		SwaggerResource res = new SwaggerResource();
		res.setLocation("/"+path+"/api-docs");
		res.setName("dubbo");
		res.setSwaggerVersion("2.0");
		list.add(res);
		return list;
	}
}
