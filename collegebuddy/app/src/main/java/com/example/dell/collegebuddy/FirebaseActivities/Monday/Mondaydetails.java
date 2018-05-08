package com.example.dell.collegebuddy.FirebaseActivities.Monday;

import com.example.dell.collegebuddy.Utils.LetterImageView;
public class Mondaydetails {

    private String Subject;
    private String Starting_time ;
    private String Ending_time ;
    private LetterImageView ivLetter;

    public Mondaydetails() {
        // This is default constructor.
    }


    public LetterImageView getIvLetter() {
        return ivLetter;
    }

    public void setIvLetter(LetterImageView ivLetter) {
        this.ivLetter = ivLetter;
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

    public String getEnding_time() {
        return Ending_time;
    }

    public void setEnding_time(String Ending_time) {
        this.Ending_time = Ending_time;
    }

}