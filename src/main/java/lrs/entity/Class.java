package lrs.entity;


public class Class {
    private Integer class_id;
    private String class_name;

    public Class() {
    }

    public Class(Integer class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
