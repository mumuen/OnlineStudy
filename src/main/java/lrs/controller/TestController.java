package lrs.controller;

import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
