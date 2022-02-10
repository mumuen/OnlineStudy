package lrs.service;

import lrs.entity.Video;
import lrs.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    VideoMapper videoMapper;

    public Video queryVidById(Integer vid_id){
        return videoMapper.queryVidById(vid_id);
    }

}
