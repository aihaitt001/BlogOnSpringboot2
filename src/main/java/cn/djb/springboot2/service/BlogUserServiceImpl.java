package cn.djb.springboot2.service;


import cn.djb.springboot2.domain.BlogUser;
import cn.djb.springboot2.mapper.BlogUserMapper;
import cn.djb.springboot2.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    BlogUserMapper usersmapper;

    @Override

    public List<BlogUser> listAll() {
        return usersmapper.listAll();
    }

    @Override
    public int add(BlogUser user) {
        // TODO Auto-generated method stub

        // Date date = new Date();
        //Timestamp createtime = TimeUtil.now();
        //user.setCreatetime(createtime);
        //user.setLastchange(createtime);
        // md5编码，并添加随机盐
        //MD5Util.EncryptUser(user);
        return usersmapper.add(user);

    }

    @Override
    public int flushUsers() {
        return usersmapper.flushUsers();
    }

    @Override
    public List<BlogUser> list() {
        // TODO Auto-generated method stub
        return usersmapper.list();
    }

    @Override
    public BlogUser getById(Integer id) {
        // TODO Auto-generated method stub
        return usersmapper.getById(id);
    }

    @Override
    public int deleteById(Integer id) {
        // TODO Auto-generated method stub
        return usersmapper.deleteById(id);
    }

    @Override
    public int updateById(BlogUser user) {
        // TODO Auto-generated method stub
        Date date = new Date();
        Timestamp lastchange = new Timestamp(date.getTime());
        //user.setLastchange(lastchange);
        //MD5Util.EncryptUser(user);
        return usersmapper.updateById(user);
    }

    @Override
    public BlogUser checkUsername(String username) {
        // TODO Auto-generated method stub
        return usersmapper.checkUsername(username);
    }

    @Override
    public String checkEmail(String email) {
        // TODO Auto-generated method stub
        return usersmapper.checkEmail(email);

    }

    @Override
    public BlogUser checkLogin(String username) {
        // TODO Auto-generated method stub
        return usersmapper.checkLogin(username);
    }

}
