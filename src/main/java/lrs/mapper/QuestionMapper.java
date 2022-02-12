package lrs.mapper;

import lrs.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    List<Question> queryQuesByVidId(@Param("vid_id") Integer vid_id);
    List<Integer> queryQueIdByVidId(@Param("vid_id") Integer vid_id);
    Integer deleteQueByIdList(List<Integer> que_ids);
    Integer deleteQueById(@Param("que_id") Integer que_id);
}
