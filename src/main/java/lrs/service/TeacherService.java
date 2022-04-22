package lrs.service;

import lrs.entity.School;
import lrs.entity.Teacher;
import lrs.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public Teacher queryTeaByIdPwd(Integer tea_id,String tea_pwd){
        return teacherMapper.queryTeaByIdPwd(tea_id,tea_pwd);
    }

    public Integer updateTeacher(Teacher teacher){
        return teacherMapper.updateTeacher(teacher);
    }

    public Integer updateTeaPwd(Teacher teacher){
        return teacherMapper.updateTeaPwd(teacher);
    }

    public Integer insertTeaCou(Integer tea_id,Integer cou_id){
        return teacherMapper.insertTeaCou(tea_id,cou_id);
    }
}
