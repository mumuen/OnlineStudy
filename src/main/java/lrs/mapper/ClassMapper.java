package lrs.mapper;

import lrs.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {

    Class queryClassById(@Param("cla_id") Integer cla_id);

    Integer querySchIdByClaId(@Param("cla_id") Integer cla_id);

    List<Class> queryClasByCouId(@Param("cou_id") Integer cou_id);

    Integer deleteClaCouByCouId(@Param("cou_id") Integer cou_id);
}
