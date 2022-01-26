package lrs.service;

import lrs.entity.Student;
import lrs.mapper.ClassMapper;
import lrs.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student queryStuByIdPwd(Integer stu_id,String stu_pwd){
        return studentMapper.queryStuByIdPwd(stu_id,stu_pwd);
    }

    public Integer updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    public Integer updateStuPwd(Student student){
        return studentMapper.updateStuPwd(student);
    }


}
