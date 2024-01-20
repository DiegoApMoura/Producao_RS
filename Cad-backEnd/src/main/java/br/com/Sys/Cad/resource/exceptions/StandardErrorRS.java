package br.com.Sys.Cad.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardErrorRS implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer Status;
    private String error;
    private String message;
    private String path;
    public StandardErrorRS(){

    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}