package com.windvalley.music.common.base.config;

import com.windvalley.music.filter.JWTAuthenticationFilter;
import com.windvalley.music.filter.JWTAuthorizationFilter;
import com.windvalley.music.security.JWTUserDetailService;
import com.windvalley.music.security.MD5PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String SECRET = "windvalley"; //生成JWT的秘钥
    public static final long EXPIRATION_TIME = 3600 * 24;//JWT令牌过期时间
    public static final String TOKEN_PREFIX = "icewind ";
    public static final String HEADER_STRING = "Authorization";//JWT鉴权后放到header里面的变量名称
    public static final String SIGN_UP_URL = "/api/users";

    @Autowired
    JWTUserDetailService jwtUserDetailService;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/swagger-ui.html")
//                .antMatchers("/webjars/**")
//                .antMatchers("/v2/**")
//                .antMatchers("/swagger-resources/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //1. 用自己的JWTUserDetailService替换默认的userService, 实现loadUserByUsername，完成用户自定义登录
    //2. 使用自己定义的MD5PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new MD5PasswordEncoder();
    }
}
