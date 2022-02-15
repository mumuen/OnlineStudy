package lrs.controller;

import lrs.entity.Class;
import lrs.entity.Course;
import lrs.entity.School;
import lrs.mapper.ClassMapper;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.ClassService;
import lrs.service.CourseService;
import lrs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    ClassService classService;


    @RequestMapping(value = "/stu_courses")
    public String toStuCourse(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Class cla=(Class) session.getAttribute("class");
        List<Course> courses = courseService.queryCousByClsId(cla.getClass_id());
        model.addAttribute("courses",courses);
        return "stu_course";
    }

    @RequestMapping(value="/tea_courses")
    public String toTeaCourse(HttpSession session,Model model){
        Object user = session.getAttribute("user");
        Integer tea_id = UserUtils.getUserId(user);
        List<Course> courses = courseService.queryCousByTeaId(tea_id);
        model.addAttribute("courses",courses);
        return "tea_course";
    }

    @RequestMapping("/tea_courses/endCourse/{cou_id}")
    @ResponseBody
    public BaseResponse endCourse(@PathVariable("cou_id") Integer cou_id){
        Integer integer = courseService.endCourse(cou_id);
        return integer>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @RequestMapping("/tea_courses/activeCourse/{cou_id}")
    @ResponseBody
    public BaseResponse activeCourse(@PathVariable("cou_id") Integer cou_id){
        Integer integer = courseService.activeCourse(cou_id);
        return integer>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @RequestMapping("/tea_courses/deleteCourse/{cou_id}")
    @ResponseBody
    public BaseResponse deleteCourse(@PathVariable("cou_id") Integer cou_id,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/");
        Boolean bol = courseService.deleteCourse(cou_id,path);
        return bol?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @RequestMapping("/cre_course")
    public String toCreCourse(){
        return "cre_course";
    }

    @RequestMapping(value = "/queryCla")
    @ResponseBody
    public  List<Class> queryClaByNameAndSchId(@RequestParam("cla_name") String cla_name, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");
        Integer sch_id = school.getSch_id();
        List<Class> classes = classService.queryClaByClaNameAndSchId(cla_name, sch_id);
        return classes;
    }









}
