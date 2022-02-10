package lrs.controller;

import lrs.entity.Class;
import lrs.entity.School;
import lrs.entity.Student;
import lrs.entity.Teacher;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.ClassService;
import lrs.service.SchoolService;
import lrs.service.StudentService;
import lrs.service.TeacherService;
import lrs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse login(@RequestParam("uid") Integer id, @RequestParam("upwd") String pwd, HttpServletRequest request){
        String pwd_md5= MD5Utils.getPwd(pwd);
        String s=id+"";
        if(s.startsWith("1")){
            return studentLogin(id,pwd_md5,request);
        }else{
            return teacherLogin(id,pwd_md5,request);
        }
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("class");
        request.getSession().removeAttribute("school");

        return "index";
    }

    public BaseResponse studentLogin(Integer stu_id,String stu_pwd,HttpServletRequest request){
        Student stu=studentService.queryStuByIdPwd(stu_id,stu_pwd);
        if(stu==null){
            return new BaseResponse(StatusCode.FAIL);
        }
        Class cla=classService.queryClassByStuId(stu_id);
        School sch=schoolService.querySchByStuId(stu_id);
        HttpSession session = request.getSession();
        session.setAttribute("user",stu);
        session.setAttribute("class",cla);
        session.setAttribute("school",sch);

        return new BaseResponse(StatusCode.SUCCESS);
    }

    public BaseResponse teacherLogin(Integer tea_id,String tea_pwd,HttpServletRequest request){
        Teacher tea =teacherService.queryTeaByIdPwd(tea_id,tea_pwd);
        if(tea==null){
            return new BaseResponse(StatusCode.FAIL);
        }
        School sch=schoolService.querySchByTeaId(tea_id);
        HttpSession session = request.getSession();
        session.setAttribute("user",tea);
        session.setAttribute("school",sch);

        return new BaseResponse(StatusCode.SUCCESS);
    }
}
