package com.savesgoals.config;
import com.savesgoals.security.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/error",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.woff2"
                )
                .permitAll()
                .antMatchers(
                        "/savingplan",
                        "/savingplan/{id}",
                        "/savingplan/user/{id}",
                        "/savingplan/savingsheet/{id}",
                        "/savesgoals",
                        "/savesgoals/savingplan/{id}",
                        "/savesgoals/{id}",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/swagger-resources/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
        ;
    }
}
