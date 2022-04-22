package lrs.service;

import lrs.entity.Notice;
import lrs.mapper.NoticeMapper;
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
}
