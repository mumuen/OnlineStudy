package lrs.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class MD5Utils {
    public static String getPwd(String original){
        String target="";
        try {
            target=DigestUtils.md5DigestAsHex(original.getBytes("utf8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return target;
    }
}
