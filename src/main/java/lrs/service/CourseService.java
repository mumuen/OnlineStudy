package lrs.service;

import lrs.entity.Course;
import lrs.mapper.*;
import lrs.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    MaterialMapper materialMapper;
    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    QuestionMapper questionMapper;

    public List<Course> queryCousByClsId(Integer cla_id){
        return courseMapper.queryCousByClaId(cla_id);
    }

    public String queryCouNameById(Integer cou_id){
        return courseMapper.queryCouNameById(cou_id);
    }

    public List<Course> queryCousByTeaId(Integer tea_id){
        return courseMapper.queryCousByTeaId(tea_id);

    }

    public Integer endCourse(Integer cou_id){
        return courseMapper.endCourse(cou_id);
    }

    public Integer activeCourse(Integer cou_id){
        return courseMapper.activeCourse(cou_id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCourse(Integer cou_id){
        //        查询出课程章节id
        List<Integer> cha_ids = chapterMapper.queryChaIdByCouId(cou_id);
//        根据课程章节id查出所有视频
        ArrayList<Integer> vid_ids = new ArrayList<>();
        for(Integer cha_id:cha_ids){
            vid_ids.addAll(videoMapper.queryVidIdByChaId(cha_id));
        }
//        根据视频id查出所有评论id
        ArrayList<Integer> com_ids = new ArrayList<>();
        for(Integer vid_id:vid_ids){
            com_ids.addAll(commentMapper.queryComIdByVidId(vid_id));
        }
//        根据视频id查出所有视频的文件路径封面路径
        ArrayList<String> vid_paths = new ArrayList<>();
        for(Integer vid_id:vid_ids){
            vid_paths.add(videoMapper.queryVidPathByVidId(vid_id));
        }
        ArrayList<String> vid_cover_paths = new ArrayList<>();
        for(Integer vid_id:vid_ids){
            vid_cover_paths.add(videoMapper.queryVidCoverPathByVidId(vid_id));
        }

//        根据视频id查出所有的题目id
        ArrayList<Integer> que_ids = new ArrayList<>();
        for(Integer vid_id:vid_ids){
            que_ids.addAll(questionMapper.queryQueIdByVidId(vid_id));
        }

        //        先把所有的材料路径查询出来，后面要删除
        List<String> mat_paths = materialMapper.queryMatPathByCouId(cou_id);

//        课程封面路径，默认路径不能删
        String cou_cover_path=courseMapper.queryCouCoverByCouId(cou_id);



//        删除课程
        Integer n1 = courseMapper.deleteCourse(cou_id);
//        删除老师-课程
        Integer n2 = teacherMapper.deleteTeaCouByCouId(cou_id);
//        删除课程-班级
        Integer n3 = classMapper.deleteClaCouByCouId(cou_id);
//        删除课程章节
        Integer n4 = chapterMapper.deleteChaByCouId(cou_id);
//        删除课程-章节
        Integer n5 = courseMapper.deleteCouChaByCouId(cou_id);
//        删除章节-视频
        if(cha_ids.size()>0){
            chapterMapper.deleteChaVidByChaIdList(cha_ids);
        }

//        删除课程材料
        Integer n6 = materialMapper.deleteMatByCouId(cou_id);
//        删除课程-材料
        Integer n7 = courseMapper.deleteCouMatByCouId(cou_id);
//        删除所以评论
        if(com_ids.size()>0){
            commentMapper.deleteComByIdList(com_ids);
        }
//        删除所有视频 和视频-评论
        if(vid_ids.size()>0){
            videoMapper.deleteVidByIdList(vid_ids);
            videoMapper.deleteVidComByVidId(vid_ids);
        }

//        当有题目时才删除所有题目 判空
        if(que_ids.size()>0){
            questionMapper.deleteQueByIdList(que_ids);
        }


        ArrayList<String> all = new ArrayList<>();
        all.addAll(vid_paths);
        all.addAll(vid_cover_paths);
        all.addAll(mat_paths);
        all.add(cou_cover_path);
        FileUtils.deleteList(all);
        return n1>0&&n2>0&&n3>0;
    }
}
