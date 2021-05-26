package com.example.springsevuritydemo.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.springsevuritydemo.SecurityConfig.ApplicationRole.*;
import static com.example.springsevuritydemo.SecurityConfig.UserPermission.COURSE_WRITE;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
               // .antMatchers("/api/admin/**").hasRole(ADMIN.name())
                .antMatchers("/api/students").hasRole(STUDENT.name())
//                .antMatchers(HttpMethod.DELETE, "/api/admin/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/admin/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/api/admin/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers("/api/admin/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student= User.builder()
                .username("student")
                .password(passwordEncoder.encode("password"))
                //.roles(STUDENT.name())
                .authorities(STUDENT.getAuthority())
                .build();

        UserDetails admin =User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                // .roles(ADMIN.name())
                .authorities(ADMIN.getAuthority())
                .build();
        return new InMemoryUserDetailsManager(
                student,
                admin
        );
    }
}
