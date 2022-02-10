package lrs.mapper;

import lrs.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    List<Question> queryQuesByVidId(@Param("vid_id") Integer vid_id);
}
