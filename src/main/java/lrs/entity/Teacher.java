package lrs.entity;

public class Teacher {
    private Integer id;
    private String pwd;
    private String name;
    private String tel;
    private String mail;
    private Integer sex;

    public Teacher() {
    }

    public Teacher(Integer id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public Teacher(Integer id, String pwd, String name, String tel, String mail, Integer sex) {
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
