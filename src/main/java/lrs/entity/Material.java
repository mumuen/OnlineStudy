package lrs.entity;

public class Material {
    private Integer mat_id;
    private String mat_name;
    private String mat_path;
    private String mat_size;
    private String mat_date;

    public Material() {
    }

    public Material(String mat_name, String mat_path, String mat_size, String mat_date) {
        this.mat_name = mat_name;
        this.mat_path = mat_path;
        this.mat_size = mat_size;
        this.mat_date = mat_date;
    }

    public Material(Integer mat_id, String mat_name, String mat_path, String mat_size, String mat_date) {
        this.mat_id = mat_id;
        this.mat_name = mat_name;
        this.mat_path = mat_path;
        this.mat_size = mat_size;
        this.mat_date = mat_date;
    }

    public Integer getMat_id() {
        return mat_id;
    }

    public void setMat_id(Integer mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_name() {
        return mat_name;
    }

    public void setMat_name(String mat_name) {
        this.mat_name = mat_name;
    }

    public String getMat_path() {
        return mat_path;
    }

    public void setMat_path(String mat_path) {
        this.mat_path = mat_path;
    }

    public String getMat_size() {
        return mat_size;
    }

    public void setMat_size(String mat_size) {
        this.mat_size = mat_size;
    }

    public String getMat_date() {
        return mat_date;
    }

    public void setMat_date(String mat_date) {
        this.mat_date = mat_date;
    }
}
