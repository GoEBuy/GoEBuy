package com.goebuy.controller;

import com.goebuy.biz.UploadFileBiz;
import com.goebuy.params.Response;
import com.goebuy.params.UploadData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by luodejin on 2018/8/21.
 */
@RestController
@RequestMapping("/file")
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    UploadFileBiz uploadFileService;

    @PostMapping(value = "/upload")
    public Response uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request)
            throws IllegalStateException, IOException {
        //获取文件名，带扩展名
        String filename = file.getOriginalFilename();
        LOGGER.info("New file save request. filename={}", filename);
        try {
            String fullFilename = uploadFileService.upload(file, request.getSession().getServletContext().getRealPath("/"));
            return new Response(new UploadData(200, "success", fullFilename));
        } catch (IOException e) {
            LOGGER.error("Failed to save file. filename={}", filename, e);
        }
        return new Response<>(new UploadData(1500,"error", filename));
    }

}
