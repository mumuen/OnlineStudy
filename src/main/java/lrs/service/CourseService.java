package lrs.service;

import lrs.entity.Course;
import lrs.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> queryCousByClsId(Integer cla_id){
        return courseMapper.queryCousByClaId(cla_id);
    }

    public String queryCouNameById(Integer cou_id){
        return courseMapper.queryCouNameById(cou_id);
    }
}
