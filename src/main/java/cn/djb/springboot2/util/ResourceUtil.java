package cn.djb.springboot2.util;

/**
 *
 *@decription TODO 获取项目绝对路径
 *@classname ResourceUtil
 *@author ovo 
 *@date 2019/1/7 10:47
 *
 */
public class ResourceUtil {
   /**
    *
    *@decription TODO 获得classpath下文件的绝对路径
    *@methodname  getClasspathResource
    *@param
    *@return
    *@author ovo
    *@date 2019/1/7  11:22
    *
    */
    public String getClasspathFilePath(String filename){
        return this.getClass().getResource(filename).getPath();
    }
}
