package lrs.controller;

import com.alibaba.fastjson.JSON;
import lrs.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @RequestMapping("/testJson")
    @ResponseBody
    public Student test1(){
        Student student = new Student(1,"123456","lrs","12345678910","2@2",1);


        return student;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/")
    public String index1(){
        return "index";
    }

    @RequestMapping("/video")
    public String video(){
        return "video";
    }
}
