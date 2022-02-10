package lrs.entity;

import java.util.List;

public class Chapter {
    private Integer cha_id;
    private Integer cha_seq;
    private String cha_name;
    private List<Video> videos;

    public Chapter() {
    }

    public Chapter(Integer cha_id, Integer cha_seq, String cha_name, List<Video> videos) {
        this.cha_id = cha_id;
        this.cha_seq = cha_seq;
        this.cha_name = cha_name;
        this.videos = videos;
    }


    public Chapter(Integer cha_id, Integer cha_seq, String cha_name) {
        this.cha_id = cha_id;
        this.cha_seq = cha_seq;
        this.cha_name = cha_name;
    }

    public Integer getCha_id() {
        return cha_id;
    }

    public void setCha_id(Integer cha_id) {
        this.cha_id = cha_id;
    }

    public Integer getCha_seq() {
        return cha_seq;
    }

    public void setCha_seq(Integer cha_seq) {
        this.cha_seq = cha_seq;
    }

    public String getCha_name() {
        return cha_name;
    }

    public void setCha_name(String cha_name) {
        this.cha_name = cha_name;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "cha_id=" + cha_id +
                ", cha_seq=" + cha_seq +
                ", cha_name='" + cha_name + '\'' +
                ", videos=" + videos +
                '}';
    }
}
