package cn.codermax.simpleloginauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 对用户的业务逻辑处理
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username) || !"admin".equals(username)){
            throw new UsernameNotFoundException("User Not Exists!");
        }

        //查询数据库，将查询到的权限信息放入user中然后返回
        String password = passwordEncoder.encode("123");
        return new User("admin",password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN,NORMAL,/security/v1/service"));
    }
}