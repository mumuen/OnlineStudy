package lrs.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    List<String> queryVidNameByChaId(@Param("cha_id") Integer cha_id);
}
