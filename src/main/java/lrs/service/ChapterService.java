package lrs.service;

import lrs.entity.Chapter;
import lrs.mapper.ChapterMapper;
import lrs.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    VideoMapper videoMapper;

    public List<Chapter> queryChasByCouId(Integer cou_id){
        List<Chapter> chapters = chapterMapper.queryChasByCouId(cou_id);
//        对章节按照章节序号进行排序
        chapters.sort((a,b)->{
            return a.getCha_seq()-b.getCha_seq();
        });

        for(Chapter chapter:chapters){
            List<String> names = videoMapper.queryVidNameByChaId(chapter.getCha_id());
            chapter.setVideo_names(names);
        }
        return chapters;
    }

}
