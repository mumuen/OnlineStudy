package lrs.mapper;

import lrs.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {

    List<Chapter> queryChasByCouId(@Param("cou_id") Integer cou_id);
    Integer deleteChaByCouId(@Param("cou_id") Integer cou_id);
    List<Integer> queryChaIdByCouId(@Param("cou_id") Integer cou_id);
    Integer deleteChaVidByChaIdList(List<Integer> cha_ids);
}
