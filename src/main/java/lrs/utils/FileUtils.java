package lrs.utils;

import java.io.File;
import java.util.List;

public class FileUtils {
    /**
     * 获取windows/linux的项目根目录
     *
     * @return
     */
    public static String getConTextPath() {
        String projectPath = System.getProperty("user.dir");
        return projectPath;
    }

    /*判断文件是否存在*/
    public static boolean isExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /*判断是否是文件夹*/
    public static boolean isDir(String path) {
        File file = new File(path);
        if(file.exists()){
            return file.isDirectory();
        }else{
            return false;
        }
    }

    /**
     * 文件或者目录重命名
     * @param oldFilePath 旧文件路径
     * @param newName 新的文件名,可以是单个文件名和绝对路径
     * @return
     */
    public static boolean renameTo(String oldFilePath, String newName) {
        try {
            File oldFile = new File(oldFilePath);
            //若文件存在
            if(oldFile.exists()){
                //判断是全路径还是文件名
                if (newName.indexOf("/") < 0 && newName.indexOf("\\") < 0){
                    //单文件名，判断是windows还是Linux系统
                    String absolutePath = oldFile.getAbsolutePath();
                    if(newName.indexOf("/") > 0){
                        //Linux系统
                        newName = absolutePath.substring(0, absolutePath.lastIndexOf("/") + 1)  + newName;
                    }else{
                        newName = absolutePath.substring(0, absolutePath.lastIndexOf("\\") + 1)  + newName;
                    }
                }
                File file = new File(newName);
                //判断重命名后的文件是否存在
                if(file.exists()){
                    System.out.println("该文件已存在,不能重命名");
                }else{
                    //不存在，重命名
                    return oldFile.renameTo(file);
                }
            }else {
                System.out.println("原该文件不存在,不能重命名");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (String fileName){
        try{
            File sourceFile = new File(fileName);
            if(sourceFile.isDirectory()){
                for (File listFile : sourceFile.listFiles()) {
                    delete(listFile.getAbsolutePath());
                }
            }
            return sourceFile.delete();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteList (List<String> fileNames,String path){
        fileNames.removeAll(GlobalSetting.DEFAULTIMGPATHS);
        try{
            for(String fileName:fileNames){
                File file = new File(path+fileName);
                System.out.println(file);
                if(file.exists()&&file.isFile()){
                    file.delete();
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
