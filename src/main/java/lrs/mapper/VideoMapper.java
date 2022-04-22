package lrs.mapper;

import lrs.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    List<Video> queryVidsByChaId(@Param("cha_id") Integer cha_id);

    Video queryVidById(@Param("vid_id") Integer vid_id);

    Integer insertVidCom(@Param("vid_id") Integer vid_id,@Param("com_id") Integer com_id);

    List<Integer> queryVidIdByChaId(@Param("cha_id") Integer cha_id);
    String queryVidPathByVidId(@Param("vid_id") Integer vid_id);
    String queryVidCoverPathByVidId(@Param("vid_id") Integer vid_id);
    Integer deleteVidById(@Param("vid_id") Integer vid_id);
    Integer deleteVidByIdList(List<Integer> vid_ids);

    Integer deleteVidComByVidId(List<Integer> vid_ids);
    Integer deleteVidComByVid(@Param("vid_id") Integer vid_id);

    Integer insertVideo(Video video);


}
