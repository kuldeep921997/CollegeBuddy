package com.example.dell.collegebuddy;

public class noticeModel {

    private String Subject;
    private String Starting_time ;
    private String Starting_date;

    public noticeModel() {
        // This is default constructor.
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getStarting_time() {
        return Starting_time;
    }

    public void setStarting_time(String Starting_time) {
        this.Starting_time = Starting_time;
    }

    public String getStarting_date() {
        return Starting_date;
    }

    public void setStarting_date(String Starting_date) {
        this.Starting_date = Starting_date;
    }


}