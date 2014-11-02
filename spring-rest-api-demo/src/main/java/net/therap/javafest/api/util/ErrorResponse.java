package net.therap.javafest.api.util;

import java.io.Serializable;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 1;

    private String code;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
