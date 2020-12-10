package com.example.shade;

public class Shade {
    private String name;
    private String detail;
    private String color;

    public Shade(String name, String detail, String color){
        this.name = name;
        this.detail = detail;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
