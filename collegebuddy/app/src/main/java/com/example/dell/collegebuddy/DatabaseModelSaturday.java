package com.example.dell.collegebuddy;
import com.example.dell.collegebuddy.Utils.LetterImageView;

public class DatabaseModelSaturday {
    private String starting_time;
    private String end_time;
    private String id;
    private String subject_name;
    private LetterImageView ivLetter;

    public String getId() {
        return id;
    }

    public LetterImageView getIvLetter() {
        return ivLetter;
    }

    public void setIvLetter(String id) {
        this.ivLetter =ivLetter ;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

}