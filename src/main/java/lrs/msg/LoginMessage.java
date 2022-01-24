package lrs.msg;

public class LoginMessage {
    private String msg;

    public LoginMessage() {
    }

    public LoginMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
