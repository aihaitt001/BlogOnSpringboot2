Title         : Springboot2 (Blog)
Author        : ovo
Logo          : false

[TITLE]

#这是原项目[SSM_BLOG]( https://github.com/aihaitt001/SSM_BLOG ) 的升级版本,去掉了好多用不到功能,加了一些功能

* 从SpringMVC4.9.10+maven3到SpringBoot2.0.5+gradle3
* 从shiro到Spring Security 
* 完善了CkEditor4.10的上传图片功能.

 Enjoy it!
***
# 日志

1. 完成mybatis,druid配置,开启thymeleaf
2. 配置Spring security代替shiro   9.28
3. 配置邮件发送,封装成EmailService
4. 配置文件上传和下载
5. 配置ckeditor4.10,使图片能够上传到本地服务器. 10.12
6. 解决下载文件中文名无法识别的问题 11.6
*在返回的responseEntity中的header中把返回的文件名编码
    new String(file.getFilename().getBytes("UTF-8"), "iso-8859-1")
       