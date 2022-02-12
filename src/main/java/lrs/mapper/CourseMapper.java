package lrs.mapper;

import lrs.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> queryCousByClaId(@Param("cla_id") Integer cla_id);

    String queryCouNameById(@Param("cou_id") Integer cou_id);

    List<Course> queryCousByTeaId(@Param("tea_id") Integer tea_id);

    Integer endCourse(@Param("cou_id") Integer cou_id);
    Integer activeCourse(@Param("cou_id") Integer cou_id);

    Integer deleteCourse(@Param("cou_id") Integer cou_id);

    Integer deleteCouChaByCouId(@Param("cou_id") Integer cou_id);
    Integer deleteCouMatByCouId(@Param("cou_id") Integer cou_id);
    String queryCouCoverByCouId(@Param("cou_id") Integer cou_id);

}
