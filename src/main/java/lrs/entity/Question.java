package lrs.entity;

public class Question {
    private Integer que_id;
    private String que_title;
    private String que_item_a;
    private String que_item_b;
    private String que_item_c;
    private String que_item_d;
    private String que_ans;
//    题目分值，默认5分
    private Integer que_score;

    public Question() {
    }

    public Question(Integer que_id, String que_title, String que_item_a, String que_item_b, String que_item_c, String que_item_d, String que_ans, Integer que_score) {
        this.que_id = que_id;
        this.que_title = que_title;
        this.que_item_a = que_item_a;
        this.que_item_b = que_item_b;
        this.que_item_c = que_item_c;
        this.que_item_d = que_item_d;
        this.que_ans = que_ans;
        this.que_score = que_score;
    }

    public Integer getQue_id() {
        return que_id;
    }

    public void setQue_id(Integer que_id) {
        this.que_id = que_id;
    }

    public String getQue_title() {
        return que_title;
    }

    public void setQue_title(String que_title) {
        this.que_title = que_title;
    }

    public String getQue_item_a() {
        return que_item_a;
    }

    public void setQue_item_a(String que_item_a) {
        this.que_item_a = que_item_a;
    }

    public String getQue_item_b() {
        return que_item_b;
    }

    public void setQue_item_b(String que_item_b) {
        this.que_item_b = que_item_b;
    }

    public String getQue_item_c() {
        return que_item_c;
    }

    public void setQue_item_c(String que_item_c) {
        this.que_item_c = que_item_c;
    }

    public String getQue_item_d() {
        return que_item_d;
    }

    public void setQue_item_d(String que_item_d) {
        this.que_item_d = que_item_d;
    }

    public String getQue_ans() {
        return que_ans;
    }

    public void setQue_ans(String que_ans) {
        this.que_ans = que_ans;
    }

    public Integer getQue_score() {
        return que_score;
    }

    public void setQue_score(Integer que_score) {
        this.que_score = que_score;
    }

    @Override
    public String toString() {
        return "Question{" +
                "que_id=" + que_id +
                ", que_title='" + que_title + '\'' +
                ", que_item_a='" + que_item_a + '\'' +
                ", que_item_b='" + que_item_b + '\'' +
                ", que_item_c='" + que_item_c + '\'' +
                ", que_item_d='" + que_item_d + '\'' +
                ", que_ans='" + que_ans + '\'' +
                ", que_score=" + que_score +
                '}';
    }
}
