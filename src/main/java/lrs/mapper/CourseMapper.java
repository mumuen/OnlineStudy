package lrs.mapper;

import lrs.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> queryCousByClaId(@Param("cla_id") Integer cla_id);

    String queryCouNameById(@Param("cou_id") Integer cou_id);
}
