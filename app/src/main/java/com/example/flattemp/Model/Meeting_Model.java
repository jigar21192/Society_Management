package com.example.flattemp.Model;

public class Meeting_Model {

String date,title,description,time;

    public Meeting_Model(String date, String title, String description,String time) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.time = time;

    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
