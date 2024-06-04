package com.vesalukkarila.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vesalukkarila.ApplicationLauncher;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active{}.properties",
                        ignoreResourceNotFound = true)
@EnableWebMvc //initializes spring webmvc with default configurations, enables use of dependencies in classpath
public class ApplicationConfiguration {

    @Bean(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper objectMapper(){return new ObjectMapper();}

    /*This bean is needed for making validation annotations on controller arguments to work*/
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
