package lrs.mapper;

import lrs.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin queryAdmin(@Param("admin_name") String admin_name, @Param("admin_pwd") String admin_pwd);
}
