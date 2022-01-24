import com.alibaba.fastjson.JSON;
import lrs.entity.Course;
import lrs.entity.Student;
import lrs.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDemo {
    @Test
    public void testJosn(){
        Student student = new Student(1,"123456","lrs","12345678910","2@2","男");
        System.out.println(JSON.toJSONString(student));
    }

    @Autowired
    CourseMapper courseMapper;
    @Test
    public void testCourses(){
        List<Course> courses = courseMapper.queryCousByClaId(10000);
        System.out.println(courses);
    }

}
