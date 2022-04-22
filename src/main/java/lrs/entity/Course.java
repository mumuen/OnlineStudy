package lrs.entity;

public class Course {
    private Integer cou_id;
    private String cou_name;
    private String cou_tea_name;
    private String cou_info;
    private Integer cou_hour;
    private String cou_cover_path;
    private Integer cou_state;

    public Course() {
    }

    public Course(String cou_name, String cou_tea_name, String cou_info, Integer cou_hour, String cou_cover_path, Integer cou_state) {
        this.cou_name = cou_name;
        this.cou_tea_name = cou_tea_name;
        this.cou_info = cou_info;
        this.cou_hour = cou_hour;
        this.cou_cover_path = cou_cover_path;
        this.cou_state = cou_state;
    }

    public Course(Integer cou_id, String cou_name, String cou_tea_name, String cou_info, Integer cou_hour, String cou_cover_path, Integer cou_state) {
        this.cou_id = cou_id;
        this.cou_name = cou_name;
        this.cou_tea_name = cou_tea_name;
        this.cou_info = cou_info;
        this.cou_hour = cou_hour;
        this.cou_cover_path = cou_cover_path;
        this.cou_state = cou_state;
    }

    public String getCou_cover_path() {
        return cou_cover_path;
    }

    public void setCou_cover_path(String cou_cover_path) {
        this.cou_cover_path = cou_cover_path;
    }

    public Integer getCou_id() {
        return cou_id;
    }

    public void setCou_id(Integer cou_id) {
        this.cou_id = cou_id;
    }

    public String getCou_name() {
        return cou_name;
    }

    public void setCou_name(String cou_name) {
        this.cou_name = cou_name;
    }

    public String getCou_tea_name() {
        return cou_tea_name;
    }

    public void setCou_tea_name(String cou_tea_name) {
        this.cou_tea_name = cou_tea_name;
    }

    public String getCou_info() {
        return cou_info;
    }

    public void setCou_info(String cou_info) {
        this.cou_info = cou_info;
    }

    public Integer getCou_hour() {
        return cou_hour;
    }

    public void setCou_hour(Integer cou_hour) {
        this.cou_hour = cou_hour;
    }

    public Integer getCou_state() {
        return cou_state;
    }

    public void setCou_state(Integer cou_state) {
        this.cou_state = cou_state;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cou_id=" + cou_id +
                ", cou_name='" + cou_name + '\'' +
                ", cou_tea_name='" + cou_tea_name + '\'' +
                ", cou_info='" + cou_info + '\'' +
                ", cou_hour=" + cou_hour +
                ", cou_cover_path='" + cou_cover_path + '\'' +
                ", cou_state=" + cou_state +
                '}';
    }
}
