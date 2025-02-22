package com.example.kiem_tra_list_view;

public class Point {
    private int x;
    private int y;
    private String name;

    public Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
