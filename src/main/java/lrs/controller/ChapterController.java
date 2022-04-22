package lrs.controller;

import lrs.entity.Chapter;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.ChapterService;
import lrs.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @Autowired
    CourseService courseService;

    @RequestMapping("/chapter/{cou_id}")
    public String chapter(@PathVariable("cou_id") Integer cou_id, Model model){
        List<Chapter> chapters = chapterService.queryChasByCouId(cou_id);
        model.addAttribute("chapters",chapters);
        String cou_name = courseService.queryCouNameById(cou_id);
        model.addAttribute("cou_name",cou_name);
        return "chapters";
    }

    @RequestMapping(value="/teachapter/{cou_id}")
    public String tea_chapter(@PathVariable("cou_id") Integer cou_id,Model model){
        List<Chapter> chapters = chapterService.queryChasByCouId(cou_id);
        model.addAttribute("chapters",chapters);
        String cou_name = courseService.queryCouNameById(cou_id);
        model.addAttribute("cou_name",cou_name);
        model.addAttribute("cou_id",cou_id);
        return "teaChapter";
    }

    @RequestMapping("/creChapter")
    @ResponseBody
    public BaseResponse creChapter(Integer cou_id,String cha_name,Integer cha_seq){
        Chapter chapter = new Chapter(cha_seq, cha_name);
        Boolean bol = chapterService.insertChapter(chapter, cou_id);
        return bol?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @RequestMapping("/creVideo")
    public String toCreVideo(Integer cha_id,Model model){
        model.addAttribute("cha_id",cha_id);
        return "creVideo";
    }




}
