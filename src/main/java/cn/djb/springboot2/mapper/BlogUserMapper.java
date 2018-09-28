package cn.djb.springboot2.mapper;

import cn.djb.springboot2.domain.BlogUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogUserMapper {
 public BlogUser checkLogin(String username);

 public BlogUser checkUsername(String username);

 public String checkEmail(String email);

 public int add(BlogUser BlogUser);

 public int deleteById(Integer id);

 public List<BlogUser> list();

 public List<BlogUser> listAll();

 public BlogUser getById(Integer id);

 public int updateById(BlogUser BlogUser);

 public int flushUsers();
}
