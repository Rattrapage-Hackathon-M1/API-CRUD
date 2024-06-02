package fr.esgi.User_Task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
//@AllArgsConstructor
public class SecurityConfiguration {

    //private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // On peut se connecter sans utiliser https
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()

                )
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        //.headers(header -> header.frameOptions(frameOptions -> Customizer.withDefaults()));
        return http.build();
    }

}

