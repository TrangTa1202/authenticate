package com.example.crm.payload;

public class FileResponse {
    private String message;

    public FileResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
