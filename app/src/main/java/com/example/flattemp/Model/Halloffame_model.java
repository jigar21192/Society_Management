package com.example.flattemp.Model;

public class Halloffame_model {
    public String getFame_id() {
        return fame_id;
    }

    public void setFame_id(String fame_id) {
        this.fame_id = fame_id;
    }



    public String getFame_winner_name() {
        return fame_winner_name;
    }

    public void setFame_winner_name(String fame_winner_name) {
        this.fame_winner_name = fame_winner_name;
    }

    public String getFame_winner_img() {
        return fame_winner_img;
    }

    public void setFame_winner_img(String fame_winner_img) {
        this.fame_winner_img = fame_winner_img;
    }


    public Halloffame_model(String fame_id, String fame_winner_name, String fame_winner_img,String fame_event_name) {
        this.fame_id = fame_id;

        this.fame_winner_name = fame_winner_name;
        this.fame_winner_img = fame_winner_img;
        this.fame_event_name=fame_event_name;

    }

    String fame_id,fame_winner_name,fame_winner_img,fame_event_name;

    public String getFame_event_name() {
        return fame_event_name;
    }

    public void setFame_event_name(String fame_event_name) {
        this.fame_event_name = fame_event_name;
    }
}
