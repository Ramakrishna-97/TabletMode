package com.example.tabletmode;


public class ModelClass {
    String fname,lname,mail,mobile,doj,desg;

    public ModelClass(String fname, String lname, String mail, String mobile, String doj, String desg) {
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.mobile = mobile;
        this.doj = doj;
        this.desg = desg;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }
}