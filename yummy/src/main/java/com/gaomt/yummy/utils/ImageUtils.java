package com.gaomt.yummy.utils;

import com.gaomt.yummy.constant.AvatarType;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author： MengtingGao
 * @Date： Create in 19:28 2019/2/28
 * @Description:
 */
public class ImageUtils {

  public static String transferImageTo(String imageData, AvatarType type) throws IOException {
    String[] tempData = imageData.split("base64,");
    String suffix;
    if ("data:image/jpeg;".equalsIgnoreCase(tempData[0])) {
      suffix = ".jpg";
    } else if ("data:image/x-icon;".equalsIgnoreCase(tempData[0])) {
      suffix = ".ico";
    } else if ("data:image/gif;".equalsIgnoreCase(tempData[0])) {
      suffix = ".gif";
    } else
      throw new IllegalArgumentException("Wrong image format");

    byte[] bsPic = Base64Utils.decodeFromString(tempData[1]);
    String randomName = UUID.randomUUID() + suffix;

    String path = ResourceUtils.getURL("classpath:").getPath();

    String fileName = path + randomName;
    File imageFile = new File(fileName);
    if (!imageFile.exists()) {
      imageFile.createNewFile();
    }

    FileUtils.writeByteArrayToFile(imageFile, bsPic);

    return randomName;
  }

}
