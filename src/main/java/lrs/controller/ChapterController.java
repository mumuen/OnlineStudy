package lrs.controller;

import lrs.entity.Chapter;
import lrs.service.ChapterService;
import lrs.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
