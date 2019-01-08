package cn.djb.springboot2.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 *
 *@decription 保存文件的配置
 *@classname StorageProperties
 *@author ovo
 *@date 2018/10/17 13:52
 *
 */
public class StorageProperties {

    /**
     * Folder location for storing files
     */

   // private String uploadfilespath;
    @Value(value = "${upload.files.path}")
    private String location ;
    @Value(value = "${ckeditor.storage.image.path}")
    private String imagesLocation;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getImagesLocation(){return imagesLocation;}
    public void setImagesLocation(String location){this.imagesLocation=location;}

}
