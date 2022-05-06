package lrs.mapper;

import lrs.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {

    Class queryClassById(@Param("cla_id") Integer cla_id);

    Integer querySchIdByClaId(@Param("cla_id") Integer cla_id);

    List<Class> queryClasByCouId(@Param("cou_id") Integer cou_id);

    Integer deleteClaCouByCouId(@Param("cou_id") Integer cou_id);

    List<Class> queryClaByClaNameAndSchId(@Param("cla_name") String cla_name,@Param("sch_id") Integer sch_id);
    Integer addClaStu(@Param("cla_id") Integer cla_id,@Param("stu_id") Integer stu_id);
}
