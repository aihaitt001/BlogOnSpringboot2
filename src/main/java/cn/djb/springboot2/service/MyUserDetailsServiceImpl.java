package cn.djb.springboot2.service;

import cn.djb.springboot2.controller.HomeController;
import cn.djb.springboot2.domain.BlogUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    Logger logger = LogManager.getLogger(MyUserDetailsServiceImpl.class);
    @Autowired
    BlogUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try{
           BlogUser user = new BlogUser();
           user = service.checkLogin(username);
           Collection<GrantedAuthority> authList = getAuthorities(user);
            System.out.println("userdewtail:"+username+"___"+user.getPassword());
           userDetails = new User(username, user.getPassword().toLowerCase(),true,true,true,true,authList) ;

       }catch(Exception e){
            logger.error("----------"+username+"登陆时出现错误:"+e.toString());
           e.printStackTrace();
       }
        return userDetails;
    }


    private Collection<GrantedAuthority> getAuthorities(BlogUser user) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
int isadmin =3;
isadmin = user.getAdmin();
        if(isadmin==1){
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else if (isadmin==2){
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
          else{
              logger.error("用户异常数据:"+user.getUsername()+"权限等级不明:"+user.getAdmin());
        }
        return authList;
    }
}

