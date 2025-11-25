package org.nioun.essentials.mog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MogApplication.class, args);
	}

	    // Example for a traditional Spring MVC setup
   /*  @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // Set max file size (e.g., 10MB)
        return multipartResolver;
    } */

}
