package fr.esgi.User_Task.config;

import fr.esgi.User_Task.filter.PermissionsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<PermissionsFilter> loggingFilter(){
        FilterRegistrationBean<PermissionsFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new PermissionsFilter());
        registrationBean.addUrlPatterns("/api/utilisateur/*", "/api/taches/*");

        return registrationBean;
    }
}
