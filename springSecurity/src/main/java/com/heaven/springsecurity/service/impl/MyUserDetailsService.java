package com.heaven.springsecurity.service.impl;

import com.heaven.springsecurity.domain.User;
import com.heaven.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhanggq
 * @date 2022/8/9 13:42
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException(username);
        }
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                "{noop}" + user.getPassword(), //{noop} 不加密
                true, //用户是否启用
                true, //用户是否过期 true未过期
                true,// 用户凭据是否过期 true未过期
                true,//用户是否锁定 true未锁定
                authorities);//权限集合
        return userDetails;
    }
}
