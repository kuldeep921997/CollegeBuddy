package com.example.dell.collegebuddy.FirebaseActivities;

import com.example.dell.collegebuddy.Utils.LetterImageView;

public class subjects {


    private String subject;
    private String fullsubject ;
    private String SubjetType;
    private LetterImageView ivLetter;

    public subjects() {
        // This is default constructor.
    }
    public LetterImageView getIvLetter() {
        return ivLetter;
    }

    public void setIvLetter(LetterImageView ivLetter) {
        this.ivLetter = ivLetter;
    }

    public String getSubjetType() {
        return SubjetType;
    }

    public void setSubjetType(String subjetType) {
        SubjetType = subjetType;
    }

    public void setFullsubject(String fullsubject) {
        this.fullsubject = fullsubject;
    }

    public String getFullsubject() {

        return fullsubject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String Subject) {
        this.subject = Subject;
    }


}