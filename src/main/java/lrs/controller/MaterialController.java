package lrs.controller;

import lrs.entity.Class;
import lrs.entity.Course;
import lrs.entity.Material;
import lrs.mapper.CourseMapper;
import lrs.msg.BaseResponse;
import lrs.msg.StatusCode;
import lrs.service.CourseService;
import lrs.service.MaterialService;
import lrs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @Autowired
    CourseService courseService;
    @RequestMapping("/material")
    public String toMaterial(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Class cla=(Class) session.getAttribute("class");
        List<Course> courses = courseService.queryCousByClsId(cla.getClass_id());
        model.addAttribute("courses",courses);
        return "material";
    }

    @GetMapping("/material/{cou_id}")
    public String getMaterials(@PathVariable Integer cou_id, Model model){
        List<Material> materials = materialService.queryMatsByCouId(cou_id);
        model.addAttribute("materials",materials);

        return "materials";
    }

    @RequestMapping("/toTeaMaterial")
    public String toTeaMaterial(HttpSession session,Model model){
        Object user = session.getAttribute("user");
        Integer tea_id = UserUtils.getUserId(user);
        List<Course> courses = courseService.queryCousByTeaId(tea_id);
        model.addAttribute("courses",courses);
        return "teaMaterial";
    }

    @RequestMapping("/toTeaMaterials")
    public String toTeaMaterials(Integer cou_id,String cou_name,Model model){
        List<Material> materials = materialService.queryMatsByCouId(cou_id);
        model.addAttribute("materials",materials);
        model.addAttribute("cou_name",cou_name);
        model.addAttribute("cou_id",cou_id);
        return "teaMaterials";
    }

    @ResponseBody
    @RequestMapping("/deleteMaterial")
    public BaseResponse deleteMat(Integer cou_id,Integer mat_id,HttpServletRequest request){
        Integer n = materialService.deleteMat(cou_id, mat_id, request);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }

    @ResponseBody
    @PostMapping("/uploadMaterial")
    public BaseResponse uploadMaterial(MultipartFile material,String mat_size,Integer cou_id,HttpServletRequest request) throws IOException {
        int n=materialService.uploadMat(material, cou_id, mat_size,request);
        return n>0?new BaseResponse(StatusCode.SUCCESS):new BaseResponse(StatusCode.FAIL);
    }



}
