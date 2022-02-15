package lrs.controller;

import jdk.nashorn.internal.objects.Global;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.utils.GlobalSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class TestController {


    @RequestMapping("/testJson")
    @ResponseBody
    public BaseResponse  test1(){
        return new BaseResponse(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "success";
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

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/");
        String path=realPath+"/static/images/school_badge/10410.jpg";
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(realPath);
        
        return "login";
    }


}
