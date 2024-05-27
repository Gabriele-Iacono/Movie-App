package com.iacono.app.Movie.App.security;

import com.iacono.app.Movie.App.services.CustomerDetailService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
@Data
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    @Lazy
    private CustomerDetailService customerDetailService;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home" , "register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    //    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails normalUser = User.builder()
//                .username("coc")
//                .password("$2a$12$U7ve5IlWMWDLV92oJSw1R.Xv7V6TbkkLSRBxSscwnxGwS3gkXYQXu")
//                .roles("USER")
//                .build();
//
//            UserDetails adminUser = User.builder()
//                    .username("admin")
//                    .password("$2a$12$U7ve5IlWMWDLV92oJSw1R.Xv7V6TbkkLSRBxSscwnxGwS3gkXYQXu")
//                    .roles("ADMIN", "USER")
//                    .build();
//        return new InMemoryUserDetailsManager(normalUser, adminUser);
//    }


    @Bean
    public CustomerDetailService customerDetailService() {

        return  customerDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
