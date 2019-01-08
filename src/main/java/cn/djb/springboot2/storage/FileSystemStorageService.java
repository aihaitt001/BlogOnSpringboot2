package cn.djb.springboot2.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
/**
 *
 *@decription 保存文件的具体实现类.
 *@classname FileSystemStorageService
 *@author ovo
 *@date 2018/10/17 10:23
 *
 */
public class FileSystemStorageService implements StorageService {
    Logger logger = LogManager.getLogger(this.getClass().getName());
    private final Path rootLocation;
private final Path imagesLocation;

    @Autowired
    /**
     *@decription 初始化服务
     *@name FileSystemStorageService
     *@param [properties] @see cn.djb.springboot2.storage.StorageProperties
     *@return
     *@author ovo
     *@date 2018/10/17  13:51
     *
     */
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.imagesLocation=Paths.get(properties.getImagesLocation());
    }
//    @Autowired //未解决   配置文件
//    public FileSystemStorageService() {
//        this.rootLocation = Paths.get(this.uploadfilePath);//空指针的问题
//    }


    @Override
    /**
     *@decription 保存文件,会覆盖重名文件
     *@name store
     *@param [file]
     *@return void
     *@author ovo
     *@date 2018/10/15  17:33
     *
     */
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }
@Override
    public void storeImage(MultipartFile image) {
        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        try {
            if (image.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }

            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, this.imagesLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
                System.out.println("保存的图片为:"+this.imagesLocation.resolve(filename));
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    /**
     *@decription 加载所有文件,并把所有路径合并为Stream<Path>
     *@name loadAll
     *@param []
     *@return java.util.stream.Stream<java.nio.file.Path>
     *@author ovo
     *@date 2018/10/17  10:20
     *
     */
    public Stream<Path> loadAll() {
        try {

            Stream<Path> pathlist = Files.walk(this.rootLocation, 1);
//count会关闭流
//            if(pathlist.count()==0){
//                logger.info("文件夹为空:stream.count="+pathlist.count());
//            }else{
//                logger.info("文件夹不为空:stream.count="+pathlist.count());
//            }
            return pathlist
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return this.rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
