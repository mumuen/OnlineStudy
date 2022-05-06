package lrs.entity;

public class Notice {
    private Integer not_id;
    private String not_title;
    private String not_content;
    private String not_date;

    public Notice() {
    }

    public Notice(String not_title, String not_content, String not_date) {
        this.not_title = not_title;
        this.not_content = not_content;
        this.not_date = not_date;
    }

    public Integer getNot_id() {
        return not_id;
    }

    public void setNot_id(Integer not_id) {
        this.not_id = not_id;
    }

    public String getNot_title() {
        return not_title;
    }

    public void setNot_title(String not_title) {
        this.not_title = not_title;
    }

    public String getNot_content() {
        return not_content;
    }

    public void setNot_content(String not_content) {
        this.not_content = not_content;
    }

    public String getNot_date() {
        return not_date;
    }

    public void setNot_date(String not_date) {
        this.not_date = not_date;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "not_id=" + not_id +
                ", not_title='" + not_title + '\'' +
                ", not_content='" + not_content + '\'' +
                ", not_date='" + not_date + '\'' +
                '}';
    }
}
