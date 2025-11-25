package org.nioun.essentials.mog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
public class ThymeleafConfig {
  
    
    @Bean
public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
SpringTemplateEngine engine = new SpringTemplateEngine();
engine.addDialect(new Java8TimeDialect());
engine.setTemplateResolver(templateResolver);
return engine;

}
 

 
@Bean
public Java8TimeDialect java8TimeDialect(){
	return new Java8TimeDialect();
}


    
}
