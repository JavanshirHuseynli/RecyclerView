package com.android.myapplication;

public class Movie {
    private String title, type, year;

    public Movie() {
    }

    public Movie(String title, String type, String year) {
        this.title = title;
        this.type = type;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String genre) {
        this.type = type;
    }
}
