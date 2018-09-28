package cn.djb.springboot2.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*
*@Decription:为读取数据库中的用户信息准备
*@Classname:UserDetailsService
*@Author: ovo
*@Date:2018/9/26 9:27
*/

public interface UserDetailsService {
    UserDetailsService loadUserByUsername(String username) throws UsernameNotFoundException;
}
