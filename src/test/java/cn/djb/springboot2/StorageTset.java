package cn.djb.springboot2;

import cn.djb.springboot2.storage.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTset {
    @Autowired
    StorageService service;
    @Test
    public void testLoadAll(){
        service.loadAll().map(
                       path -> path.getFileName().toString()
                ).forEach(path -> System.out.println("wenjian:"+path));
    }
}
