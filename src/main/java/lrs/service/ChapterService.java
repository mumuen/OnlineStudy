package lrs.service;

import lrs.entity.Chapter;
import lrs.entity.Video;
import lrs.mapper.ChapterMapper;
import lrs.mapper.CourseMapper;
import lrs.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    CourseMapper courseMapper;

    public List<Chapter> queryChasByCouId(Integer cou_id){
        List<Chapter> chapters = chapterMapper.queryChasByCouId(cou_id);
//        对章节按照章节序号进行排序
        chapters.sort((a,b)->{
            return a.getCha_seq()-b.getCha_seq();
        });

        for(Chapter chapter:chapters){
            List<Video> vids = videoMapper.queryVidsByChaId(chapter.getCha_id());
            chapter.setVideos(vids);
        }
        return chapters;
    }

    @Transactional
    public Boolean insertChapter(Chapter chapter,Integer cou_id){
        Integer n1 = chapterMapper.insertChapter(chapter);
        Integer cha_id = chapter.getCha_id();
        Integer n2 = courseMapper.insertCouChaByCouIdAndChaId(cou_id, cha_id);
        return n1>0&&n2>0;
    }

}
