package com.testdebuger.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final
    UserDetailsService userDetailsService;

    public SecurityConfig( UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()


                .mvcMatchers("/").permitAll()
                .mvcMatchers("/login").anonymous()
                .mvcMatchers("/admin").hasAnyRole("ADMIN")
                .mvcMatchers("/user").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/") // Страница куда нужно перекинуть после входа

                .usernameParameter("email") // Имя поля input в котором содержится логин
                .passwordParameter("password")

                .and().csrf().disable()

                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }


}