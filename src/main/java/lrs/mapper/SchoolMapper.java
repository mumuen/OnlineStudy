package lrs.mapper;

import lrs.entity.School;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    School querySchById(@Param("sch_id") Integer sch_id);
}
