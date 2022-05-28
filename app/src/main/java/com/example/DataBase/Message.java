package com.example.DataBase;

public class Message {
    String username1;
    String username2;
    String message;
    String time;
    int sign;

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getUsername1() {
        return username1;
    }

    public String getUsername2() {
        return username2;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public int getSign() {
        return sign;
    }
}
