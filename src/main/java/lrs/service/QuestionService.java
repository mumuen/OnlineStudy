package lrs.service;

import lrs.entity.Question;
import lrs.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    public List<Question> queryQuesByVidId(Integer vid_id){
        return questionMapper.queryQuesByVidId(vid_id);
    }
}
