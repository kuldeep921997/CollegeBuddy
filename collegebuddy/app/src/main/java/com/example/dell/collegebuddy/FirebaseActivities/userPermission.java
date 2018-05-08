package com.example.dell.collegebuddy.FirebaseActivities;

public class userPermission {


    private String Email;
    private String UID;
    private String Permission ;

    public userPermission() {
        // This is default constructor.
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUID() {
        return UID;
    }
    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPermission() {
        return Permission;
    }
    public void setPermission(String Permission) {
        this.Permission = Permission;
    }
}