package lrs.mapper;

import lrs.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Comment> queryComsByVidId(@Param("vid_id") Integer vid_id);

    Integer insertComment(Comment comment);
}
