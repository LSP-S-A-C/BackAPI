package com.financeservice.apiadminfinance.config;
import com.financeservice.apiadminfinance.security.RestAuthenticationEntryPoint;
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
                        "/savingSheets",
                        "/savingSheets/{id}",
                        "/category",
                        "/category/{id}",
                        "/savingSheets/savingplan/{id}",
                        "/cashFlow",
                        "/cashFlow/{id}",
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
