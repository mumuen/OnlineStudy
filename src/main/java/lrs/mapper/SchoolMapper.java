package lrs.mapper;

import lrs.entity.Class;
import lrs.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolMapper {
    School querySchById(@Param("sch_id") Integer sch_id);
    List<School> queryAllSchool();
    List<Class> queryAllClaBySchId(@Param("sch_id") Integer sch_id);
    Integer addSchTea(@Param("sch_id") Integer sch_id,@Param("tea_id") Integer tea_id);
}
