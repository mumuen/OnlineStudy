package lrs.entity;

public class Student {
    private Integer id;
    private String pwd;
    private String name;
    private String tel;
    private String mail;
    private String sex;

    public Student() {
    }

    public Student(Integer id, String pwd, String name, String tel, String mail, String sex) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.tel = tel;
        this.mail = mail;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
