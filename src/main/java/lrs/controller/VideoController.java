package lrs.controller;


import lrs.entity.Comment;
import lrs.entity.Question;
import lrs.entity.Video;
import lrs.service.CommentService;
import lrs.service.QuestionService;
import lrs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    VideoService videoService;

    @Autowired
    CommentService commentService;

    @Autowired
    QuestionService questionService;


    @RequestMapping("/video/{vid_id}")
    public String queryVid(@PathVariable("vid_id") Integer vid_id, Model model){
        Video video = videoService.queryVidById(vid_id);
        model.addAttribute("video",video);

        List<Comment> comments = commentService.queryComsByVidId(vid_id);
        model.addAttribute("comments",comments);

        List<Question> questions = questionService.queryQuesByVidId(vid_id);
        model.addAttribute("questions",questions);
        return "video";
    }


}
