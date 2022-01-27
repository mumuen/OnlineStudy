package lrs.service;

import lrs.entity.Material;
import lrs.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    public List<Material> queryMatsByCouId(Integer cou_id){
        return materialMapper.queryMatsByCouId(cou_id);
    }
}
