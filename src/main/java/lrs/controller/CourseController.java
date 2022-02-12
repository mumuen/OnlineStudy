package lrs.controller;

import lrs.entity.Class;
import lrs.entity.Course;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.CourseService;
import lrs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;


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
    public BaseResponse deleteCourse(@PathVariable("cou_id") Integer cou_id){
        Boolean bol = courseService.deleteCourse(cou_id);
        return bol?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }








}
