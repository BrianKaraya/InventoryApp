package com.inventory;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String dirName = "user-photos";
		Path userPhotosDir = Paths.get(dirName);

		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + userPhotosPath + "/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		Path productUploadDir=Paths.get("product-photos");
		String productUploadPath = productUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/product-photos/**").addResourceLocations("file:/" + productUploadPath + "/");
	}

}
