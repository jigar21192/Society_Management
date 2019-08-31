package com.example.flattemp.Model;

public class View_Complain_Model {


    public String getMem_complaint() {
        return mem_complaint;
    }

    public void setMem_complaint(String mem_complaint) {
        this.mem_complaint = mem_complaint;
    }

    public String getMem_complaint_desc() {
        return mem_complaint_desc;
    }

    public void setMem_complaint_desc(String mem_complaint_desc) {
        this.mem_complaint_desc = mem_complaint_desc;
    }

    public String getMem_complaint_date() {
        return mem_complaint_date;
    }

    public void setMem_complaint_date(String mem_complaint_date) {
        this.mem_complaint_date = mem_complaint_date;
    }

    public String getMem_user(){ return mem_user;}

    public void setMem_user(String mem_user) {
        this.mem_user= mem_user;
    }

    public String getAdmin_reply() {
        return admin_reply;
    }

    public void setAdmin_reply(String admin_reply) {
        this.admin_reply = admin_reply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public View_Complain_Model(String mem_complaint, String mem_complaint_desc, String mem_complaint_date, String admin_reply, String status, String c_id) {
        this.mem_complaint = mem_complaint;
        this.mem_complaint_desc = mem_complaint_desc;
        this.mem_complaint_date = mem_complaint_date;
        this.status = status;
        this.c_id = c_id;

        this.admin_reply = admin_reply;
    }

    String mem_complaint,mem_complaint_desc,mem_complaint_date,mem_user,admin_reply,status,c_id;
}
