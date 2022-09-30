package cn.codermax.simpleloginauth.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface RequestWithUrlService {

    /**
     * 判断是否存在权限访问某URL
     * @param request
     * @param authentication
     * @return
     */
    boolean accessRequstUrl(HttpServletRequest request, Authentication authentication);
}
