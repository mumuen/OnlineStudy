package lrs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getCurDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
    public static String getCurDate1(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(date);
    }
}
