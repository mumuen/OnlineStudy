package lrs.mapper;

import lrs.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
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
    Integer deleteCouMatByCouMat(@Param("cou_id") Integer cou_id,@Param("mat_id") Integer mat_id);
    String queryCouCoverByCouId(@Param("cou_id") Integer cou_id);

    Integer insertCourse(Course course);

    Integer updateCouCoverPathById(@Param("cou_id") Integer cou_id,@Param("cou_cover_path") String cou_cover_path);

    Integer insertCouClaByClasAndCouId(HashMap<String,Object> map);
    Integer insertCouMatByCouIdAndMatId(@Param("cou_id") Integer cou_id,@Param("mat_id") Integer mat_id);

    Integer insertCouChaByCouIdAndChaId(@Param("cou_id") Integer cou_id,@Param("cha_id") Integer cha_id);
}
