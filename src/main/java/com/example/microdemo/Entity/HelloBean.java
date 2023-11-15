package com.example.microdemo.Entity;

public class HelloBean {
   private  String massage;
    public HelloBean(String massage) {
        this.massage = massage;
    }
    public HelloBean() {
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "massage='" + massage + '\'' +
                '}';
    }
}
