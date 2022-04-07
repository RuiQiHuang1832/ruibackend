package com.ruibackend.ruiwebappbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user/home")
                .authenticated()
                .antMatchers(HttpMethod.GET,"/user/stuff").hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/user/admin").hasAuthority("ADMIN")
                .antMatchers("/**")  //prevents default login security from spring
                .permitAll()//afterwards allow access

                .and()
                .httpBasic();


    }
    /*
    * VERY IMPORTANT PIECE OF CODE!
    * */
    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/user/add");
        web.ignoring().antMatchers("/user/updateBio");   //needed to prevent cors error
        web.ignoring().antMatchers("/user/image");
        //also needed cuz if you dont have this, my fetch will send a request to this and for some reason will ask for authentication,
        //if i include this, it will ignore this path and the POST method from the fetch API will go through.
        //Even though when you go to localhost:8080/user/add (after deleting this method), it will not ask for authentication,
        //but I guess when fetching from it, it still blocks access, so when you have this method, it will allow
        //everything to have access without blocking anything
    }



    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        //forced to use bcrypt when using spring secuirty!!!!!!!!!!!!!!
        return provider;
    }
}
