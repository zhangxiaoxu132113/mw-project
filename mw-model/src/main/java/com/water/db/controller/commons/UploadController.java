package com.water.db.controller.commons;

import com.water.tools.lang.FileTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mrwater on 16/7/7.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    /**
     * @description 多图片文件上传
     * @time    2016-07-07
     */
    @RequestMapping(value = "/imageList", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> uploadMultiImages(@RequestParam(value = "file", required = false)
                                      MultipartFile file, HttpServletRequest request) {
        //定义返回的json格式
        Map<String,Object> jsonMap = new HashMap<>();

        //文件上传路径
        String path = request.getSession().getServletContext().getRealPath("upload");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String uploadDate = dateFormat.format(new Date());
        path = path + File.separator + uploadDate;

        //上传文件名字
        String extendsFileName = FileTools.getFileExtendsName(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + extendsFileName;
        File targetFile = new File(path,fileName);

        //创建文件
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存文件
        try {
            file.transferTo(targetFile);
            jsonMap.put("imgSrc","upload"+File.separator+uploadDate+File.separator+fileName);
            return jsonMap;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
