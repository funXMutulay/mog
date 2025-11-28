package org.nioun.essentials.mog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;





@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        String location = "customer-photos";
        Path customerPhotosDir = Paths.get(location);
        String customerPhotosPath = customerPhotosDir.toFile().getAbsolutePath();

        
        String location1 = "product-photos";
        Path productPhotosDir = Paths.get(location1);
        String productPhotosPath = productPhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/"+location+"/**")
                .addResourceLocations("file:"+customerPhotosPath+"/");

        registry.addResourceHandler("/"+location1+"/**")
                .addResourceLocations("file:"+productPhotosPath+"/");

    }

    @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Apply to all endpoints
                    .allowedOrigins( "https://zesty-reverence-production-f083.up.railway.app") // Specify allowed origins
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                    .allowedHeaders("*") // Allow all headers
                    .allowCredentials(true); // Allow sending cookies/authentication headers
        }


         @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainerCustomizer() {
        return factory -> {
            Connector httpConnector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            httpConnector.setPort(8080); // Or 80 for standard HTTP
            factory.addAdditionalTomcatConnectors(httpConnector);
        };
    }

}
