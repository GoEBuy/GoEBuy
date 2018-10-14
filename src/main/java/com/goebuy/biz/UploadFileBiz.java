package com.goebuy.biz;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luodejin on 2018/8/21.
 */
@Service
public class UploadFileBiz {

    // 限制最大上传 100M
    private static final long ALLOW_SIZE = 100 * 1024 * 1024L;

    private static String uploadDir;

    static {
        updateDirectory();
    }

    public static void updateDirectory() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        String dirPrefix = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        uploadDir = dirPrefix + "upload" +  File.separator + fmt.format(new Date()) + File.separator;
    }

    private String getFileNameNew(String originFileName) {
        SimpleDateFormat fmt = new SimpleDateFormat("HHmmssSSS");

        String fileName = originFileName.split("\\.")[0];         //文件名称
        String tag = "_" + fmt.format(new Date());
        String extensionName = originFileName.split("\\.")[1];    //文件扩展名

        return fileName + tag + "." +  extensionName;
    }

    /**
     * @param file
     * @param realPath
     * @return 新文件名
     * @throws Exception
     */
    public String upload(MultipartFile file, String realPath) throws IOException {
        String[] fileArr = file .getOriginalFilename().split("\\.");
        if (!"xls".equals(fileArr[fileArr.length - 1]) && !"xlsx".equals(fileArr[fileArr.length - 1])) {
            throw new IllegalArgumentException("请上传Excel文件");
        }
        if (file.getSize() > ALLOW_SIZE) {
            throw new IllegalArgumentException("您上传的文件大小已经超出范围");
        }
        File destFile = new File(uploadDir);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        String fileNameNew = getFileNameNew(file.getOriginalFilename());
        File f = new File(destFile.getAbsoluteFile() + "/" + fileNameNew);
        // FIXME: 用springboot时会有指定临时路径错误的问题, 暂时先使用了另外一种保存文件的办法, 之后修复
//        file.transferTo(f);
        convertMultipartFileToFile(file, f);
        f.createNewFile();
        return uploadDir + fileNameNew;
    }

    private void convertMultipartFileToFile(MultipartFile file, File f) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            fos.write(file.getBytes());
        } catch (Exception e) {
            throw e;
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

    }
}
