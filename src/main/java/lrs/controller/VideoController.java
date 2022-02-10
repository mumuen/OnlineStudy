package lrs.controller;


import lrs.entity.Comment;
import lrs.entity.Question;
import lrs.entity.Video;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.CommentService;
import lrs.service.QuestionService;
import lrs.service.VideoService;
import lrs.utils.DateUtils;
import lrs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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


    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse insertComment(Integer vid_id, Integer com_id2, String content, HttpSession session){
        Integer uid= UserUtils.getUserId(session.getAttribute("user"));
        String date = DateUtils.getCurDate();
        Comment comment = new Comment(com_id2,uid,content,date);
        Integer integer = commentService.insertComment(vid_id, comment);
        return integer>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }






}
