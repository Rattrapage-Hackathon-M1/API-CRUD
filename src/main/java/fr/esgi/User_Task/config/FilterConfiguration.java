package fr.esgi.User_Task.config;

import fr.esgi.User_Task.filter.PermissionsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(FilterConfiguration.class);

    @Bean
    public FilterRegistrationBean<PermissionsFilter> loggingFilter(){
        FilterRegistrationBean<PermissionsFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new PermissionsFilter());
        registrationBean.addUrlPatterns("/api/utilisateur/*", "/api/taches/*");

        logger.info("FilterRegistrationBean for PermissionsFilter created and URL patterns set");

        return registrationBean;
    }
}