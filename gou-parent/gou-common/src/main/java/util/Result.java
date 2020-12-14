package util;

import java.io.Serializable;

/**
 * @author dongxuelei
 */
public class Result implements Serializable {

    private boolean success;
    private String mag;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String mag) {
        this.success = success;
        this.mag = mag;
    }
}
