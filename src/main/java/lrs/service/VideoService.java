package lrs.service;

import lrs.entity.Video;
import lrs.mapper.ChapterMapper;
import lrs.mapper.CommentMapper;
import lrs.mapper.VideoMapper;
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
public class VideoService {

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    CommentMapper commentMapper;

    public Video queryVidById(Integer vid_id){
        return videoMapper.queryVidById(vid_id);
    }
    public Integer insertVideo(Video video){
        return videoMapper.insertVideo(video);
    }

    @Transactional
    public int creVid(MultipartFile video, MultipartFile vid_cover, Integer cha_id, HttpServletRequest request) throws IOException {
        String vid_name=video.getOriginalFilename();
        String vid_up_date= DateUtils.getCurDate();
        String vid_cover_path=null;

        String realPath = request.getServletContext().getRealPath(GlobalSetting.VID_PATH);
        String suffix = vid_name.substring(vid_name.lastIndexOf("."));
//            存储视频到本地服务器的路径（绝对路径）
        String vid_path=UUIDUtils.getUUID()+suffix;
        String des_path=realPath+vid_path;
        vid_path=GlobalSetting.VID_PATH+vid_path;
        File file = new File(des_path);
        video.transferTo(file);

//        如果图片不为空的话
        if(vid_cover!=null){

            String cover_real_path = request.getServletContext().getRealPath(GlobalSetting.VID_COVER_PATH_HEAD);
            String cover_name=vid_cover.getOriginalFilename();
            String suffi = cover_name.substring(cover_name.lastIndexOf("."));
            vid_cover_path=UUIDUtils.getUUID()+suffi;
//            存储视频到本地服务器的路径（绝对路径）
            String cover_des_path=cover_real_path+vid_cover_path;
            File file1 = new File(cover_des_path);
            vid_cover_path=GlobalSetting.COU_COVER_PATH_HEAD+vid_cover_path;
            vid_cover.transferTo(file1);

        }

        Video vid = new Video(vid_name,vid_path,vid_cover_path,vid_up_date);

        int i=insertVideo(vid);
        chapterMapper.insertChaVid(cha_id,vid.getVid_id());
        return i;
    }

    @Transactional
    public Integer deleteVid(Integer cha_id,Integer vid_id,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/");
        String vid_path=videoMapper.queryVidPathByVidId(vid_id);

        String cover_path=videoMapper.queryVidCoverPathByVidId(vid_id);
        if(!"".equals(cover_path)){
            FileUtils.delete(path+cover_path);
        }
        FileUtils.delete(path+vid_path);
        List<Integer> list = commentMapper.queryComIdByVidId(vid_id);
        commentMapper.deleteComByIdList(list);
        videoMapper.deleteVidComByVid(vid_id);
        Integer n1=videoMapper.deleteVidById(vid_id);
        chapterMapper.deleteVidByChaAndVid(cha_id,vid_id);

        return n1;
    }


}
