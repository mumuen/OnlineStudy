import com.alibaba.fastjson.JSON;
import lrs.entity.Chapter;
import lrs.entity.Comment;
import lrs.entity.Course;
import lrs.entity.Student;
import lrs.mapper.ChapterMapper;
import lrs.mapper.CommentMapper;
import lrs.mapper.CourseMapper;
import lrs.mapper.StudentMapper;
import lrs.service.ChapterService;
import lrs.service.CommentService;
import lrs.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class TestDemo {
    @Test
    public void testJosn(){
        Student student = new Student(1,"123456","lrs","12345678910","2@2",1);
        System.out.println(JSON.toJSONString(student));
    }

    @Autowired
    CourseMapper courseMapper;
    @Test
    public void testCourses(){
        List<Course> courses = courseMapper.queryCousByClaId(10000);
        System.out.println(courses);
    }

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void queryStudent(){
        String pwd_md5= MD5Utils.getPwd("123456");
        Student student = studentMapper.queryStuByIdPwd(120210102, pwd_md5);
        Integer integer = studentMapper.updateStudent(student);
        System.out.println(integer);
    }


    @Autowired
    ChapterService chapterService;
    @Autowired
    ChapterMapper chapterMapper;
    @Test
    public void queryChapter(){
        List<Chapter> chapters = chapterMapper.queryChasByCouId(100000000);
        chapters.sort((a,b)->{
            return a.getCha_seq()-b.getCha_seq();
        });
        System.out.println(chapters);
    }

    @Autowired
    CommentService commentService;
    @Test
    public void test1(){
        Comment comment = new Comment(1,120210101,"1212","2021");
        Integer integer = commentService.insertComment(1, comment);
        System.out.println(integer);
        System.out.println(comment.getCom_id1());
    }

}
