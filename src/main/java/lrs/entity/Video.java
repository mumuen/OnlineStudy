package lrs.entity;

public class Video {
    private Integer vid_id;
    private String vid_name;
    private String vid_path;
    private String vid_cover_path;
    private String vid_up_date;

    public Video() {
    }

    public Video(Integer vid_id, String vid_name) {
        this.vid_id = vid_id;
        this.vid_name = vid_name;
    }

    public Video(Integer vid_id, String vid_name, String vid_path, String vid_cover_path, String vid_up_date) {
        this.vid_id = vid_id;
        this.vid_name = vid_name;
        this.vid_path = vid_path;
        this.vid_cover_path = vid_cover_path;
        this.vid_up_date = vid_up_date;
    }

    public Integer getVid_id() {
        return vid_id;
    }

    public void setVid_id(Integer vid_id) {
        this.vid_id = vid_id;
    }

    public String getVid_name() {
        return vid_name;
    }

    public void setVid_name(String vid_name) {
        this.vid_name = vid_name;
    }

    public String getVid_path() {
        return vid_path;
    }

    public void setVid_path(String vid_path) {
        this.vid_path = vid_path;
    }

    public String getVid_cover_path() {
        return vid_cover_path;
    }

    public void setVid_cover_path(String vid_cover_path) {
        this.vid_cover_path = vid_cover_path;
    }

    public String getVid_up_date() {
        return vid_up_date;
    }

    public void setVid_up_date(String vid_up_date) {
        this.vid_up_date = vid_up_date;
    }
}
