package lrs.controller;

import lrs.entity.Notice;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping("/testJson")
    @ResponseBody
    public BaseResponse  test1(){
        return new BaseResponse(StatusCode.SUCCESS);
    }


    @RequestMapping("/index")
    public String index(Model model){
        List<Notice> notices = noticeService.queryAllNotice();
        model.addAttribute("notices",notices);
        return "index";
    }

    @RequestMapping("/")
    public String index1(Model model){
        List<Notice> notices = noticeService.queryAllNotice();
        model.addAttribute("notices",notices);
        return "index";
    }

}
