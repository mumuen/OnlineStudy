package lrs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GlobalSetting {

    public static String SOURCE_PATH=getSourcePath();
    public static List<String> DEFAULTIMGPATHS=defaultImgPath();
//    public static String SCHOOL_BADGE_PATH="";
//    public static String VIDEO_COVER_PATH="";
//    public static String MATERIAL_PATH="";
//    public static String VIDEO_PATH="";

    private static String getSourcePath(){
        String separator = File.separator;
        String path=FileUtils.getConTextPath()+separator+"src"+separator+"main"+separator+"webapp";
        return path;
    }

    private static List<String> defaultImgPath(){
        ArrayList<String> paths = new ArrayList<>();
        paths.add(SOURCE_PATH+"/static/images/course_cover/1.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/2.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/3.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/4.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/5.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/6.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/7.jpg");
        paths.add(SOURCE_PATH+"/static/images/course_cover/8.jpg");
        return paths;
    }


}
