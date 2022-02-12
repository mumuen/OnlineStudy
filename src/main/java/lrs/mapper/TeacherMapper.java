package lrs.mapper;

import lrs.entity.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher queryTeaByIdPwd(@Param("tea_id") Integer tea_id, @Param("tea_pwd") String tea_pwd);

    Integer querySchIdByTeaId(@Param("tea_id") Integer tea_id);

    String queryTeaNameById(@Param("tea_id") Integer tea_id);

    Integer updateTeacher(Teacher teacher);

    Integer updateTeaPwd(Teacher teacher);

    Integer deleteTeaCouByCouId(@Param("cou_id") Integer cou_id);
}
