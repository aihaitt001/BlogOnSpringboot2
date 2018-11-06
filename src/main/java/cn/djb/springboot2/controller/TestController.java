package cn.djb.springboot2.controller;

import cn.djb.springboot2.storage.StorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class TestController {
    Logger logger = LogManager.getLogger(this.getClass().getName());
    @Autowired
    private StorageService storageService;

    @GetMapping("/test")
    public ModelAndView test( ModelAndView mav){
        logger.info("FilesUploadControllertest");
        mav.addObject("files",
                storageService.loadAll().map(
//                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                                "download", path.getFileName().toString())
//                                .build().toString())
//                        .collect(Collectors.toList()));
        path->("/files/download?filename="+path.getFileName().toString())).collect(Collectors.toList()));
        boolean containFiles = mav.isEmpty();
        System.out.println("containFiles::"+containFiles);
        logger.info("完成");
        mav.setViewName("test");
        return mav;
    }

//    @RequestMapping("/uploadImage")
//    public String handleFileUpload(@RequestParam("upload") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//        logger.info("uploading file :" + file.getName());
//        storageService.store(file);
//        Path path =  storageService.load(file.getOriginalFilename());
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "{'uploaded':'1','url':'"+path+"'}";
//    }
}
