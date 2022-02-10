package lrs.mapper;

import lrs.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student queryStuByIdPwd(@Param("stu_id") Integer stu_id, @Param("stu_pwd") String stu_pwd);

    String queryStuNameById(@Param("stu_id") Integer stu_id);

//    Integer deleteStudentById(Integer stu_id);
    Integer updateStudent(Student student);

//    stu->class
    Integer queryClaIdByStuId(@Param("stu_id") Integer stu_id);

    Integer updateStuPwd(Student student);
}
