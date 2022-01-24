package lrs.entity;

public class School {
    private Integer sch_id;
    private String sch_name;
    private String sch_img_path;

    public School() {
    }

    public School(Integer sch_id, String sch_name, String sch_img_path) {
        this.sch_id = sch_id;
        this.sch_name = sch_name;
        this.sch_img_path = sch_img_path;
    }

    public Integer getSch_id() {
        return sch_id;
    }

    public void setSch_id(Integer sch_id) {
        this.sch_id = sch_id;
    }

    public String getSch_name() {
        return sch_name;
    }

    public void setSch_name(String sch_name) {
        this.sch_name = sch_name;
    }

    public String getSch_img_path() {
        return sch_img_path;
    }

    public void setSch_img_path(String sch_img_path) {
        this.sch_img_path = sch_img_path;
    }

    @Override
    public String toString() {
        return "School{" +
                "sch_id=" + sch_id +
                ", sch_name='" + sch_name + '\'' +
                ", sch_img_path='" + sch_img_path + '\'' +
                '}';
    }
}
