package lrs.service;

import com.alibaba.fastjson.JSONArray;
import lrs.entity.Class;
import lrs.entity.Course;
import lrs.mapper.*;
import lrs.utils.FileUtils;
import lrs.utils.GlobalSetting;
import lrs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
    public Boolean deleteCourse(Integer cou_id,String path){
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
        FileUtils.deleteList(all,path);
        return n1>0&&n2>0&&n3>0;
    }

    @Transactional
    public Boolean insertCourse(String cou_name
            ,String cou_tea_name,String cou_info
            ,String classes,String cou_cover_path,Integer cou_hour, MultipartFile file,HttpServletRequest request) throws IOException {


        Object user = request.getSession().getAttribute("user");
        Integer tea_id = UserUtils.getUserId(user);

        List<Class> clas = JSONArray.parseArray(classes, Class.class);
        UUID randomUUID = UUID.randomUUID();

        String realPath = request.getServletContext().getRealPath(GlobalSetting.COU_COVER_PATH_HEAD);
        String cover_path;

        if(file!=null){
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//            存储到本地服务器的路径（绝对路径）
            String des_path=realPath+randomUUID+suffix;
//            存储到数据库的路径 （相对路径）
            cover_path=GlobalSetting.COU_COVER_PATH_HEAD+randomUUID+suffix;
            File file1 = new File(des_path);
            file.transferTo(file1);
        }else{
            cover_path=cou_cover_path;
        }

        Course course = new Course(cou_name, cou_tea_name, cou_info, cou_hour, cover_path, 1);
        Integer n1 = courseMapper.insertCourse(course);

        Integer cou_id=course.getCou_id();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cou_id",cou_id);
        map.put("list",clas);
//        插入到 课程-班级
        Integer n2 = courseMapper.insertCouClaByClasAndCouId(map);
//          插入到 老师-课程
        Integer n3 = teacherMapper.insertTeaCou(tea_id, cou_id);
        return n1>0&&n2>0&&n3>0;
    }

    public Integer insertCourse(Course course){

        return courseMapper.insertCourse(course);
    }

    public Integer insertCouClaByClasAndCouId(HashMap<String,Object> map){
        return courseMapper.insertCouClaByClasAndCouId(map);
    }

}
