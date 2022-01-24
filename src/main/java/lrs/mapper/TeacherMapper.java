package lrs.mapper;

import lrs.entity.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher queryTeaByIdPwd(@Param("tea_id") Integer tea_id, @Param("tea_pwd") String tea_pwd);

    Integer querySchIdByTeaId(@Param("tea_id") Integer tea_id);
}