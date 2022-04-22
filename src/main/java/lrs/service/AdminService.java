package lrs.service;

import lrs.entity.Admin;
import lrs.mapper.AdminMapper;
import lrs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin queryAdmin(String admin_name, String admin_pwd){
        String pwd = MD5Utils.getPwd(admin_pwd);
        Admin admin = adminMapper.queryAdmin(admin_name, pwd);
        return admin;
    }
}
