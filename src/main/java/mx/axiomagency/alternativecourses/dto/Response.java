package mx.axiomagency.alternativecourses.dto;

import java.io.Serializable;

public class Response implements Serializable {

    private String success;
    private String msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success='" + success + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
