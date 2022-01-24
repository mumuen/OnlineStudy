package lrs.service;


import lrs.entity.School;
import lrs.mapper.ClassMapper;
import lrs.mapper.SchoolMapper;
import lrs.mapper.StudentMapper;
import lrs.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public School querySchoolById(Integer sch_id){
        return schoolMapper.querySchById(sch_id);
    }

    public School querySchByStuId(Integer stu_id){
        Integer cla_id = studentMapper.queryClaIdByStuId(stu_id);
        Integer sch_id=classMapper.querySchIdByClaId(cla_id);
        return querySchoolById(sch_id);
    }

    public School querySchByTeaId(Integer tea_id){
        Integer sch_id=teacherMapper.querySchIdByTeaId(tea_id);
        return schoolMapper.querySchById(sch_id);
    }
}
