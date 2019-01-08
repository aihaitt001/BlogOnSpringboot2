package cn.djb.springboot2.controller;

import java.io.*;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import cn.djb.springboot2.domain.CkeditorUploadResponse;
import cn.djb.springboot2.storage.StorageFileNotFoundException;
import cn.djb.springboot2.storage.StorageService;
import cn.djb.springboot2.util.JsonUtil;
import cn.djb.springboot2.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/files")
public class FileController {

    Logger logger = LogManager.getLogger(this.getClass().getName());
    private final StorageService storageService;

    @Value(value = "${ckeditor.storage.image.path}")
    private String ckeditorStorageImagePath;
    @Value(value = "${ckeditor.access.image.url}")
    private String ckeditorAccessImageUrl;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam String filename) throws IOException{
//要转码以  支持中文文件名
        Resource  file  = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" +  new String(file.getFilename().getBytes("UTF-8"), "iso-8859-1") + "\"").body(file);
    }

    //th:action 会自动添加token,防止CSRF
    @PostMapping("/upload/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        logger.info("uploading file :" + file.getName());

        storageService.init();
        storageService.store(file);


        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/upload/image")
    public void uploadImage(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;

        String imageUrl = "";
        String msg = "";
        String fileName = file.getOriginalFilename();
        CkeditorUploadResponse result = new CkeditorUploadResponse();
        try {
            //文件名中文乱码问题
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            logger.info("uploading image :" + fileName);
            storageService.init();
            storageService.store(file);
            imageUrl = ckeditorAccessImageUrl + fileName;
//            String imagesViewUrlPrefix = CommonResource.get("imagesViewUrlPrefix");
//            String fileType = FileUtil.getFileSuffixFromContentType(file.getContentType());
//            fileName = UUIDFactory.getUUID() + "." + fileType;
//            BaseResult uploadResult = FileUtil.uploadFile(fileName, file.getInputStream());
//            if(uploadResult.getCode() == ResultType.CODE_NORMAL) {
//                String imagePath = (String) uploadResult.getData();
//                imageUrl = imagesViewUrlPrefix + imagePath;
//            }else {
//                msg = "文件上传失败";
//            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("富文本编辑器上传图片时发生异常", e);
            msg = "服务器异常";
        } finally {
            if (!StringUtil.isEmpty(msg)) {
                //上传失败
                result.setUploaded(0);
                HashMap errorObj = new HashMap<>();
                errorObj.put("message", msg);
                result.setError(errorObj);
            } else {
                //上传成功
                result.setUploaded(1);
                result.setFileName(fileName);
                result.setUrl(imageUrl);
            }
            logger.info("JsonUtil处理中文字符" + JsonUtil.toString(result));

            out.println(JsonUtil.toString(result));
            out.close();
        }

    }


}