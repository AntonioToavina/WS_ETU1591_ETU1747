package com.example.tp_ws2.Service;

public class Error {
    Object error;

    public Error(Object error) {
        this.error = error;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
