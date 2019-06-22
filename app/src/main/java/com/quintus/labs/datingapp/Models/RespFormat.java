package com.quintus.labs.datingapp.Models;

public class RespFormat {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setBody(Data body) {
        this.data = body;
    }

    public Data getBody() {
        return data;
    }

    private Data data;
}
