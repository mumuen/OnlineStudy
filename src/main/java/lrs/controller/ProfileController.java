package lrs.controller;


import lrs.entity.Student;
import lrs.entity.Teacher;
import lrs.mapper.StudentMapper;
import lrs.mapper.TeacherMapper;
import lrs.msg.ProfileMessage;
import lrs.service.StudentService;
import lrs.service.TeacherService;
import lrs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping()
    public String toProfile(){
        return "profile";
    }


    @ResponseBody
    @RequestMapping(value = "/update_profile",method = RequestMethod.POST)
    public ProfileMessage updateStuProfile(@RequestParam("tel") String tel, @RequestParam("mail") String mail, @RequestParam("sex") Integer sex, HttpServletRequest request){
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
//      如果是学生，则执行学生的程序
        if(user instanceof Student){
            Student stu=(Student)user;
            stu.setTel(tel);
            stu.setMail(mail);
            stu.setSex(sex);
            studentService.updateStudent(stu);
        }else{
            Teacher tea=(Teacher) user;
            tea.setMail(mail);
            tea.setTel(tel);
            tea.setSex(sex);
            teacherService.updateTeacher(tea);
        }

        return new ProfileMessage("success");
    }

    @PostMapping("/update_pwd")
    @ResponseBody
    public ProfileMessage updatePwd(@RequestParam("old_pwd") String old_pwd,@RequestParam("new_pwd") String new_pwd,HttpServletRequest request){
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        String pwd= MD5Utils.getPwd(new_pwd);
//        将前端的原密码转换为md5，检查与当前用户的密码是否一致
        String old= MD5Utils.getPwd(old_pwd);
//      如果是学生，则执行学生的程序
        if(user instanceof Student) {
            Student stu=(Student)user;
            if(!stu.getPwd().equals(old)||old_pwd==new_pwd){
                return new ProfileMessage("fail");
            }
            stu.setPwd(pwd);
            studentService.updateStuPwd(stu);
            return new ProfileMessage("success");
        }else{
            Teacher tea=(Teacher)user;
//            检查前端传来的原密码是否与登录用户的密码一致   或与新密码一致
            if(!tea.getPwd().equals(old)||old_pwd==new_pwd){
                return new ProfileMessage("fail");
            }
            tea.setPwd(pwd);
            teacherService.updateTeaPwd(tea);
            return new ProfileMessage("success");
        }
    }

}
