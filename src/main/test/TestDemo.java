import com.alibaba.fastjson.JSON;
import lrs.entity.Chapter;
import lrs.entity.Class;
import lrs.entity.Comment;
import lrs.entity.Course;
import lrs.entity.Student;
import lrs.mapper.*;
import lrs.service.ChapterService;
import lrs.service.CommentService;
import lrs.utils.DateUtils;
import lrs.utils.FileUtils;
import lrs.utils.GlobalSetting;
import lrs.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    TeacherMapper teacherMapper;
    @Test
    @Transactional
    public void test2(){
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(new Class(20000,"计科1111"));
        classes.add(new Class(20001,"计科1111"));
        Integer cou_id=200000002;
        HashMap<String, Object> map = new HashMap<>();
        map.put("cou_id",cou_id);
        map.put("list",classes);
        Integer integer = courseMapper.insertCouClaByClasAndCouId(map);
        System.out.println(integer);
    }

    @Test
    public void test3(){
        String s = UUID.randomUUID().toString();
        String replace = s.replace("-", "");
        System.out.println(replace);
        System.out.println(replace.length());
    }

    @Test
    public void test4(){
        Student student = new Student(120210103,"EDD","李四");
        Integer integer = studentMapper.addStudent(student);
        System.out.println(integer);
    }
    @Test
    public void test5(){
        String curDate1 = DateUtils.getCurDate1();
        System.out.println(curDate1);
    }
}
