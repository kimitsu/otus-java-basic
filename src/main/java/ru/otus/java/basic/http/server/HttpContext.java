package ru.otus.java.basic.http.server;

public class HttpContext {
    private Exception exception = null;
    public HttpContext() {
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
