package lrs.mapper;


import lrs.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    List<Material> queryMatsByCouId(@Param("cou_id") Integer cou_id);
    Integer deleteMatByCouId(@Param("cou_id") Integer cou_id);
    List<String> queryMatPathByCouId(@Param("cou_id") Integer cou_id);
    Integer deleteMatById(@Param("mat_id") Integer mat_id);
    String queryMatPathById(@Param("mat_id") Integer mat_id);
    Integer insertMat(Material material);
}
