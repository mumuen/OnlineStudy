package lrs.service;

import lrs.entity.Material;
import lrs.mapper.CourseMapper;
import lrs.mapper.MaterialMapper;
import lrs.utils.DateUtils;
import lrs.utils.FileUtils;
import lrs.utils.GlobalSetting;
import lrs.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    @Autowired
    CourseMapper courseMapper;

    public List<Material> queryMatsByCouId(Integer cou_id){

        return materialMapper.queryMatsByCouId(cou_id);
    }

    @Transactional
    public Integer deleteMat(Integer cou_id, Integer mat_id, HttpServletRequest request){
        String mat_path=materialMapper.queryMatPathById(mat_id);
        String context_path= request.getServletContext().getRealPath("/");
        FileUtils.delete(context_path+mat_path);
        courseMapper.deleteCouMatByCouMat(cou_id,mat_id);
        Integer n=materialMapper.deleteMatById(mat_id);
        return n;
    }

    @Transactional
    public Integer uploadMat(MultipartFile material,Integer cou_id,String size,HttpServletRequest request) throws IOException {
        String mat_name = material.getOriginalFilename();
        String mat_size=size;
        String uuid= UUIDUtils.getUUID();
        String suffix = mat_name.substring(mat_name.lastIndexOf("."));
        String mat_path=GlobalSetting.MAT_PATH_HEAD+uuid+suffix;
        String mat_date= DateUtils.getCurDate();
        String local_path_head=request.getServletContext().getRealPath("/");
        String local_parh=local_path_head+GlobalSetting.MAT_PATH_HEAD+uuid+suffix;
        File file = new File(local_parh);
        material.transferTo(file);
        Material mat=new Material(mat_name,mat_path,mat_size,mat_date);
        Integer n = materialMapper.insertMat(mat);
        courseMapper.insertCouMatByCouIdAndMatId(cou_id,mat.getMat_id());
        return n;
    }
}
