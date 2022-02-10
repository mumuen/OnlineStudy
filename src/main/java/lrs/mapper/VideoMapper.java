package lrs.mapper;

import lrs.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    List<Video> queryVidsByChaId(@Param("cha_id") Integer cha_id);

    Video queryVidById(@Param("vid_id") Integer vid_id);

    Integer insertVidCom(@Param("vid_id") Integer vid_id,@Param("com_id") Integer com_id);
}
