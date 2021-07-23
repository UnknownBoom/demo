package com.example.demo.excep;

public class MyExep extends RuntimeException{
    private String message;

    public MyExep() {
    }

    public MyExep(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
