package com.vesalukkarila.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vesalukkarila.ApplicationLauncher;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)//by default scans from this package
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active{}.properties",
                        ignoreResourceNotFound = true)
//above: bottom PropertySource has precedence over the one at the top
public class ApplicationConfiguration {

    //singleton already by default, for demonstration purposes
    @Bean(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper objectMapper(){return new ObjectMapper();}

    /*note to self: if using 3rd party libraries that don't offer explicit Spring support
    * you'll need to fall back to @Bean methods*/
}
