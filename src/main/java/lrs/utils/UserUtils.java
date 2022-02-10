package lrs.utils;

import lrs.entity.Student;
import lrs.entity.Teacher;

public class UserUtils {
    public static Integer getUserId(Object obj){
        if(obj instanceof Student){
            Student stu = (Student) obj;
            return stu.getId();
        }else{
            Teacher tea=(Teacher)obj;
            return tea.getId();
        }
    }
}
