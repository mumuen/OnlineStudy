package lrs.entity;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private Integer com_id1;
    private Integer com_id2;
    private Integer com_uid;
    private String  com_uname;
    private String com_content;
    private String com_date;
    private List<Comment> replys;

    @Override
    public String toString() {
        return "Comment{" +
                "com_id1=" + com_id1 +
                ", com_id2=" + com_id2 +
                ", com_uid=" + com_uid +
                ", com_uname='" + com_uname + '\'' +
                ", com_content='" + com_content + '\'' +
                ", com_date='" + com_date + '\'' +
                ", replys=" + replys +
                '}';
    }

    public Comment() {
    }

    public Comment(Integer com_id2, Integer com_uid,  String com_content, String com_date) {
        this.com_id2 = com_id2;
        this.com_uid = com_uid;
        this.com_content = com_content;
        this.com_date = com_date;
    }

    public Comment(Integer com_id1, Integer com_id2, Integer com_uid, String com_content, String com_date) {
        this.com_id1 = com_id1;
        this.com_id2 = com_id2;
        this.com_uid = com_uid;
        this.com_content = com_content;
        this.com_date = com_date;
    }

    public Comment(Integer com_id1, Integer com_id2, Integer com_uid, String com_uname, String com_content, String com_date, List<Comment> replys) {
        this.com_id1 = com_id1;
        this.com_id2 = com_id2;
        this.com_uid = com_uid;
        this.com_uname = com_uname;
        this.com_content = com_content;
        this.com_date = com_date;
        this.replys = replys;
    }

    public Integer getCom_id1() {
        return com_id1;
    }

    public void setCom_id1(Integer com_id1) {
        this.com_id1 = com_id1;
    }

    public Integer getCom_id2() {
        return com_id2;
    }

    public void setCom_id2(Integer com_id2) {
        this.com_id2 = com_id2;
    }

    public Integer getCom_uid() {
        return com_uid;
    }

    public void setCom_uid(Integer com_uid) {
        this.com_uid = com_uid;
    }

    public String getCom_uname() {
        return com_uname;
    }

    public void setCom_uname(String com_uname) {
        this.com_uname = com_uname;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getCom_date() {
        return com_date;
    }

    public void setCom_date(String com_date) {
        this.com_date = com_date;
    }

    public List<Comment> getReplys() {
        return replys;
    }

    public void setReplys(List<Comment> replys) {
        this.replys = replys;
    }
}
