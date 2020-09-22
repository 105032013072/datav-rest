 package com.bosssoft.platform.datav.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;


public class DatavUtil {
    
    private static Logger log = LoggerFactory.getLogger(DatavUtil.class);
    
    /**
     * 将类路径下的文件读取为字符串
     * @param relativePath：相对路径
     * @return
     */
    public static String readClassPathFileToStr(String relativePath){
        String result = "";
        InputStream in = null;
        ClassPathResource classPathResource = new ClassPathResource(relativePath);
        try {
            in = classPathResource.getInputStream();
            result = IOUtils.toString(in, "utf-8");
        } catch (IOException e) {
            log.error(e.toString());
        } finally {
            try {
                // 关闭文件输入流
                in.close();
            } catch (Exception e) {
                log.error(e.toString());
            }

        }
        return result;
    }

     public static String getUUID32() {
         String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
         return uuid;
     }
}
