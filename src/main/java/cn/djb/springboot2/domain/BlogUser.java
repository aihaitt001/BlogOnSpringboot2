package cn.djb.springboot2.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BlogUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Timestamp createtime;
    private Timestamp lastchange;
    private Integer admin;
    private Integer deleted;//0:没有被删除,1:已删除


    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setSalt(String salt) {

        this.salt = salt;

    }

    public String getSalt() {
        return salt;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setLastchange(Timestamp lastchange) {
        this.lastchange = lastchange;
    }

    public Timestamp getLastchange() {
        return lastchange;
    }

    @Override
    public String toString() {
        return "{user: {id:" + id + ",username:" + username + ",password:" + password + ",email:" + email + ",admin:"
                + admin + ",createtime:" + createtime + ",lastchange:" + lastchange + ",deleted:" + deleted + "}}";
    }
}
