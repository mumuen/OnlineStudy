package lrs.controller;

import lrs.entity.Admin;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/admin")
    public String toAdminLogin(){
        return "adminLogin";
    }

    @PostMapping("/admin")
    @ResponseBody
    public BaseResponse adminLogin(@RequestParam("admin_name") String admin_name, @RequestParam("admin_pwd") String admin_pwd){
        Admin admin = adminService.queryAdmin(admin_name, admin_pwd);
        return admin==null?new BaseResponse(StatusCode.FAIL):new BaseResponse(StatusCode.SUCCESS);
    }

    @GetMapping("/toAdmin")
    public String toAdmin(){
        return "admin";
    }

}
