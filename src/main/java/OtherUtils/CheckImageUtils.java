package OtherUtils;

import org.springframework.web.multipart.MultipartFile;
import sun.security.pkcs11.wrapper.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * @Author: wenzf
 * @Date 2021-9-16
 * @Description:
 */
public class CheckImageUtils {
    // 图片格式
    private static  String IMAGE_JPG = "jpg"; //jpg图片格式

    private static String IMAGE_PNG = "png"; //png图片格式

    private static String IMAGE_BMP = "bmp"; //bmp图片格式
    // 通过ImageReader来解码这个file并返回一个BufferedImage对象
    // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
    // 或者在解析过程中报错，也返回false
    public static boolean checkIsImage(MultipartFile file) {
        try {
            String extension = "";
            String fileName = file.getOriginalFilename();
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = fileName.substring(i + 1);
            }
            extension = extension.toLowerCase();
            if(IMAGE_JPG.equals(extension) || IMAGE_PNG.equals(extension) || IMAGE_BMP.equals(extension)){
                Image image = ImageIO.read(file.getInputStream());
                if(null == image){
                    return false;
                }
                return true;
            }
            return false;
        }catch (IOException ex){
            return false;
        }
    }
}
