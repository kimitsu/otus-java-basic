package ru.otus.java.basic.http.server;

import java.time.LocalDateTime;

public class ErrorDTO {
    private String code;
    private String message;
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ErrorDTO() {
    }

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
        this.date = LocalDateTime.now().toString();
    }
}
