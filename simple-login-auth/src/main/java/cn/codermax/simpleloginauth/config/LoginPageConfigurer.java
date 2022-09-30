package cn.codermax.simpleloginauth.config;

import cn.codermax.simpleloginauth.handler.CustomAccessDeniedHandler;
import cn.codermax.simpleloginauth.handler.ForwardAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LoginPageConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/security/login")
                .loginPage("/security/login.html")
                .successForwardUrl("/security/v1/home"); //只能跳转到post对应的请求中
//                .successHandler(new ForwardAuthenticationSuccessHandler("/security/home.html"));

        http.authorizeRequests()
                .mvcMatchers("/home.html").servletPath("/security").hasAuthority("ADMIN")
                .mvcMatchers("/login.html").servletPath("/security").permitAll()
//                .antMatchers("/security/v1/service").hasIpAddress("127.0.0.1") //只允许127.0.0.1 ip的访问
//                .antMatchers("/security/v1/service").hasAuthority("ADMIN")
                .anyRequest().authenticated();
//                .access("@requestWithUrlServiceImpl.accessRequstUrl(request,authentication)");

        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());

        http.csrf().disable();
    }
}
