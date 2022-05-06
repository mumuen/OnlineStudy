package lrs.controller;

import lrs.entity.*;
import lrs.entity.Class;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.*;
import lrs.utils.MD5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @GetMapping("/admin")
    public String toAdminLogin(){
        return "adminLogin";
    }

    @PostMapping("/admin")
    @ResponseBody
    public BaseResponse adminLogin(@RequestParam("admin_name") String admin_name, @RequestParam("admin_pwd") String admin_pwd, HttpServletRequest request){
        Admin admin = adminService.queryAdmin(admin_name, admin_pwd);
        if(admin!=null){
            request.getSession().setAttribute("admin",admin);
        }
        return admin==null?new BaseResponse(StatusCode.FAIL):new BaseResponse(StatusCode.SUCCESS);
    }

    @GetMapping("/toAdmin")
    public String toAdmin(Model model){
        List<Notice> notices = noticeService.queryAllNotice2();
        List<School> schools=schoolService.queryAllSchool();
        model.addAttribute("notices",notices);
        model.addAttribute("schools",schools);
        return "admin";
    }

    @GetMapping("/admin/delete")
    @ResponseBody
    public BaseResponse deleteNotice(@RequestParam("not_id") Integer not_id){
        Integer n = noticeService.deleteNotice(not_id);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @PostMapping("/admin/add")
    @ResponseBody
    public BaseResponse addNotice(@RequestParam("not_title") String not_title,@RequestParam("not_content") String not_content){
        Integer n = noticeService.addNotice(not_title, not_content);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @PostMapping("/admin/update")
    @ResponseBody
    public BaseResponse updateNotice(@RequestParam("not_id") Integer not_id, @RequestParam("not_content") String not_content){
        Integer n = noticeService.updateNotice(not_id, not_content);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @GetMapping("/admin/queryClass")
    @ResponseBody
    public List<Class> queryAllClaBySchId(@RequestParam("sch_id") Integer sch_id){
        List<Class> classes = schoolService.queryAllClaBySchId(sch_id);

        return classes;
    }

    @PostMapping("/admin/addStu")
    @ResponseBody
    public BaseResponse addStudent(@RequestParam("u_id") Integer stu_id,@RequestParam("u_pwd") String stu_pwd,@RequestParam("u_name") String stu_name,@RequestParam("cla_id") Integer cla_id){
        String pwd = MD5Utils.getPwd(stu_pwd);
        Student student = new Student(stu_id, pwd, stu_name);
        Integer n = studentService.addStudent(cla_id, student);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @PostMapping("/admin/addTea")
    @ResponseBody
    public BaseResponse addTeacher(@RequestParam("u_id") Integer tea_id,@RequestParam("u_pwd") String tea_pwd,@RequestParam("u_name") String tea_name,@RequestParam("sch_id") Integer sch_id){
        String pwd = MD5Utils.getPwd(tea_pwd);
        Teacher teacher = new Teacher(tea_id, pwd, tea_name);
        Integer n = teacherService.addTeacher(teacher, sch_id);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @GetMapping("/admin/queryStu")
    @ResponseBody
    public List<Student> queryStu(@RequestParam("cla_id") Integer cla_id){

        return studentService.queryStus(cla_id);
    }

    @GetMapping("/admin/queryTea")
    @ResponseBody
    public List<Teacher> queryTea(@RequestParam("sch_id") Integer sch_id){
        return teacherService.queryTeas(sch_id);
    }

}
