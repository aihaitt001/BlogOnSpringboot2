package cn.djb.springboot2.config;

import cn.djb.springboot2.service.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
/**
 *
 *@decription 自定义的用户身份验证方式 (第三方的验证方式可以放这)  PS:暂不使用
 *@classname MyAuthenticationProvider
 *@author ovo
 *@date 2019/1/9 19:32
 *
 */
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    MyUserDetailsServiceImpl detailsService;
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails user =  detailsService.loadUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }

        //加密过程在这里体现
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("Wrong password.");
//        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        System.out.println("provider:"+user+"__"+password);
        return new UsernamePasswordAuthenticationToken(user, password, authorities);

    }
    @Override
    /**
     *
     *@decription  Returns <code>true</code> if this <Code>AuthenticationProvider</code> supports the
      	 * indicated <Code>Authentication</code> object.
     * 	 * <p>
     * 	 * Returning <code>true</code> does not guarantee an
     * 	 * <code>AuthenticationProvider</code> will be able to authenticate the presented
     * 	 * instance of the <code>Authentication</code> class. It simply indicates it can
     * 	 * support closer evaluation of it. An <code>AuthenticationProvider</code> can still
     * 	 * return <code>null</code> from the {@link #authenticate(Authentication)} method to
     * 	 * indicate another <code>AuthenticationProvider</code> should be tried.
     * 	 * </p>
     * 	 * <p>
     * 	 * Selection of an <code>AuthenticationProvider</code> capable of performing
     * 	 * authentication is conducted at runtime the <code>ProviderManager</code>.
     * 	 * </p>
     * 	 *
     * 	 * @param authentication
     * 	 *
     * 	 * @return <code>true</code> if the implementation can more closely evaluate the
     * 	 * <code>Authentication</code> class presented
     *@methodname supports
     *@param [authentication]
     *@return boolean
     *@author ovo
     *@date 2019/1/9  18:58
     *
     */
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
