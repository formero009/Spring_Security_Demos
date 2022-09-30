package cn.codermax.simpleloginauth.service.impl;

import cn.codermax.simpleloginauth.service.RequestWithUrlService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @program: spring-security-demos
 * @description: 根据URL 判断访问权限
 * @author: Mr.Wang
 * @create: 2022-09-30 15:28
 **/
@Component
public class RequestWithUrlServiceImpl implements RequestWithUrlService {
    @Override
    public boolean accessRequstUrl(HttpServletRequest request, Authentication authentication) {
        Object obj = authentication.getPrincipal();
        if (obj instanceof UserDetails){
            UserDetails user = (UserDetails) obj;
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            String uri = request.getRequestURI();
            boolean flag = authorities.contains(new SimpleGrantedAuthority(uri));
            return flag;
        }
        return false;
    }
}
