package lrs.mapper;

import lrs.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    List<Notice> queryAllNotice();
    List<Notice> queryAllNotice2();
    Integer addNotice(Notice notice);
    Integer deleteNoticeById(@Param("not_id") Integer not_id);
}
