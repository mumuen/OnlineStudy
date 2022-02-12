package lrs.utils;

import java.io.File;

public class GlobalSetting {

    public static String SOURCE_PATH=getSourcePath();
//    public static String SCHOOL_BADGE_PATH="";
//    public static String VIDEO_COVER_PATH="";
//    public static String MATERIAL_PATH="";
//    public static String VIDEO_PATH="";

    public static String getSourcePath(){
        String separator = File.separator;
        String path=FileUtils.getConTextPath()+separator+"src"+separator+"main"+separator+"webapp";
        return path;
    }


}
