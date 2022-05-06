package lrs.service;

import lrs.entity.Notice;
import lrs.mapper.NoticeMapper;
import lrs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    public List<Notice> queryAllNotice(){
        return noticeMapper.queryAllNotice();
    }
    public List<Notice> queryAllNotice2(){
        return noticeMapper.queryAllNotice2();
    }
    public Integer deleteNotice(Integer not_id){
        Integer n = noticeMapper.deleteNoticeById(not_id);
        return n;
    }

    public Integer addNotice(String not_title,String not_content){
        String not_date= DateUtils.getCurDate1();
        Notice notice = new Notice(not_title,not_content,not_date);
        Integer n = noticeMapper.addNotice(notice);
        return n;
    }
    public Integer updateNotice(Integer not_id,String not_content){
        Integer n = noticeMapper.updateNotice(not_id, not_content);
        return n;
    }
}
