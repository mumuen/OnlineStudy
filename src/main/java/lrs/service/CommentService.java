package lrs.service;

import lrs.entity.Comment;
import lrs.mapper.CommentMapper;
import lrs.mapper.StudentMapper;
import lrs.mapper.TeacherMapper;
import lrs.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    VideoMapper videoMapper;

    public List<Comment> queryComsByVidId(Integer vid_id){
        List<Comment> comments = commentMapper.queryComsByVidId(vid_id);
        for(Comment comment:comments){
            if(comment.getCom_uid()<200000000){
                String stu_name = studentMapper.queryStuNameById(comment.getCom_uid());

                comment.setCom_uname(stu_name);
            }else{
                String tea_name = teacherMapper.queryTeaNameById(comment.getCom_uid());
                comment.setCom_uname(tea_name);
            }
        }
        HashMap<Integer, Comment> map = new LinkedHashMap<>();

        Iterator<Comment> iterator = comments.iterator();
        while(iterator.hasNext()){
            Comment comment = iterator.next();
            if(comment.getCom_id2()==null){
                map.put(comment.getCom_id1(),comment);
                iterator.remove();
            }
        }

        for(Comment comment:comments){
            Comment c = map.get(comment.getCom_id2());
            if(c.getReplys()==null){
                c.setReplys(new ArrayList<>());
            }
            c.getReplys().add(comment);
        }

        ArrayList<Comment> list = new ArrayList<>(map.values());

        return list;
    }

    public Integer insertComment(Integer vid_id,Comment comment){
        Integer addNum = commentMapper.insertComment(comment);
        Integer com_id=comment.getCom_id1();
        videoMapper.insertVidCom(vid_id,com_id);
        return addNum;
    }
}
