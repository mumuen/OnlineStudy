package lrs.service;

import lrs.entity.Student;
import lrs.mapper.ClassMapper;
import lrs.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassMapper classMapper;

    public Student queryStuByIdPwd(Integer stu_id,String stu_pwd){
        return studentMapper.queryStuByIdPwd(stu_id,stu_pwd);
    }

    public Integer updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    public Integer updateStuPwd(Student student){
        return studentMapper.updateStuPwd(student);
    }

    @Transactional
    public Integer addStudent(Integer cla_id,Student student){
        Integer n1 = studentMapper.addStudent(student);
        Integer n2 = classMapper.addClaStu(cla_id, student.getId());
        return n1;
    }

    public List<Student> queryStus(Integer cla_id){
        List<Student> students = studentMapper.queryStusByClaId(cla_id);
        return students;
    }

}
