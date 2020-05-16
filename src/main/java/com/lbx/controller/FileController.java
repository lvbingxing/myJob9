package com.lbx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * USER :lvbingxing
 * TIME :Created in 2020/4/29 10:21
 * NOTE:
 */
@Controller
public class FileController {
    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request, @RequestParam("filename") List<MultipartFile> files) {
        System.out.println("开始上传");

        if (!files.isEmpty()) {
            for (MultipartFile file : files) {
                Random random = new Random();
                int i = random.nextInt(9);
                String path = request.getServletContext().getRealPath("/img/" + i + "/" + i + "/");
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                File file1 = new File(path);
                if (!file1.exists()) {
                    file1.mkdirs();
                }

                String newPath = path + UUID.randomUUID() + "_" + filename;
                try {
                    file.transferTo(new File(newPath));
                    System.out.println("上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return "success";
    }


    @RequestMapping("/toUpload")
    public String toUpload() {
        return "fileUpload";
    }
}
