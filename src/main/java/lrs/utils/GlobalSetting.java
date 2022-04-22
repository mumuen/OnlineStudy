package lrs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GlobalSetting {


    public static List<String> DEFAULTIMGPATHS=defaultImgPath();
    public static String COU_COVER_PATH_HEAD="/static/images/course_cover/";
    public static String VID_COVER_PATH_HEAD="/static/images/video_cover/";
    public static String VID_PATH="/static/upload/videos/";
    public static String MAT_PATH_HEAD="/static/upload/materials/";


    private static List<String> defaultImgPath(){
        ArrayList<String> paths = new ArrayList<>();
        paths.add("/static/images/course_cover/1.jpg");
        paths.add("/static/images/course_cover/2.jpg");
        paths.add("/static/images/course_cover/3.jpg");
        paths.add("/static/images/course_cover/4.jpg");
        paths.add("/static/images/course_cover/5.jpg");
        paths.add("/static/images/course_cover/6.jpg");
        paths.add("/static/images/course_cover/7.jpg");
        paths.add("/static/images/course_cover/8.jpg");
        return paths;
    }


}
