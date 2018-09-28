package cn.djb.springboot2.service;



import cn.djb.springboot2.domain.BlogUser;

import java.util.List;


public interface BlogUserService {
	/**
	 * 
	 * @param username
	 * @return user:[id,username,email,createtime,lastchange,admin]
	 */
	BlogUser checkUsername(String username);

	/**
	 * 
	 * @param username
	 * @return user:[id,username,password,salt,admin]
	 */
	BlogUser checkLogin(String username);

	String checkEmail(String email);

	List<BlogUser> list();
	List<BlogUser> listAll();

	int add(BlogUser user);

	BlogUser getById(Integer id);

	int deleteById(Integer id);

	int updateById(BlogUser user);

	int flushUsers();

}
