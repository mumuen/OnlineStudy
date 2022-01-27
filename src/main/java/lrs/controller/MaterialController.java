package lrs.controller;

import lrs.entity.Class;
import lrs.entity.Course;
import lrs.entity.Material;
import lrs.mapper.CourseMapper;
import lrs.service.CourseService;
import lrs.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @Autowired
    CourseService courseService;
    @RequestMapping()
    public String toMaterial(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Class cla=(Class) session.getAttribute("class");
        List<Course> courses = courseService.queryCousByClsId(cla.getClass_id());
        model.addAttribute("courses",courses);
        return "material";
    }

    @GetMapping("/{cou_id}")
    public String getMaterials(@PathVariable Integer cou_id, Model model){
        List<Material> materials = materialService.queryMatsByCouId(cou_id);
        model.addAttribute("materials",materials);
        return "materials";
    }



}
