package lrs.mapper;

import lrs.entity.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {

    Class queryClassById(@Param("cla_id") Integer cla_id);

    Integer querySchIdByClaId(@Param("cla_id") Integer cla_id);
}
