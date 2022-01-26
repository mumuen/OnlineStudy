package lrs.controller;


import lrs.entity.Student;
import lrs.entity.Teacher;
import lrs.mapper.StudentMapper;
import lrs.mapper.TeacherMapper;
import lrs.msg.ProfileMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping()
    public String toProfile(){
        return "profile";
    }


    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ProfileMessage updateStuProfile(@RequestParam("tel") String tel, @RequestParam("mail") String mail, @RequestParam("sex") Integer sex, HttpServletRequest request){
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
//      如果是学生，则执行学生的程序
        if(user instanceof Student){
            Student stu=(Student)user;
            stu.setTel(tel);
            stu.setMail(mail);
            stu.setSex(sex);
            studentMapper.updateStudent(stu);
        }else{
            Teacher tea=(Teacher) user;
            tea.setMail(mail);
            tea.setTel(tel);
            tea.setSex(sex);
        }

        return new ProfileMessage("success");
    }

}
