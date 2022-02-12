package lrs.service;

import lrs.entity.Class;
import lrs.mapper.ClassMapper;
import lrs.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private StudentMapper studentMapper;


    public Class queryClassById(Integer class_id){
        return classMapper.queryClassById(class_id);
    }


    public Class queryClassByStuId(Integer stu_id){
        Integer class_id = studentMapper.queryClaIdByStuId(stu_id);
        return queryClassById(class_id);
    }



}
