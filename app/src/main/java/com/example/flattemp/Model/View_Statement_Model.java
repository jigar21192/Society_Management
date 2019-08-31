package com.example.flattemp.Model;

public class View_Statement_Model {

    String mem_name,pay_date,pay_fixed,pay_deposit,pay_remaining,type;

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }
    public String getpay_date() {
        return pay_date;
    }

    public void setpay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getpay_fixed() {
        return pay_fixed;
    }

    public void setpay_fixed(String pay_fixed) {
        this.pay_fixed = pay_fixed ;
    }

    public String getpay_deposit() {
        return pay_deposit;
    }

    public void setpay_deposit(String pay_deposit) {
        this.pay_deposit = pay_deposit;
    }

    public String getpay_remaining() {
        return pay_remaining;
    }

    public void setpay_remaining(String pay_remaining) {
        this.pay_remaining = pay_remaining;
    }
/*
    public String getPay_date1() {
        return pay_date1;
    }

    public void setPay_date1(String pay_date1) {
        this.pay_date1 = pay_date1;
    }

    public String getPay_credit1() {
        return pay_credit1;
    }

    public void setPay_credit1(String pay_credit1) {
        this.pay_credit1 = pay_credit1;
    }

    public String getPay_debit1() {
        return pay_debit1;
    }

    public void setPay_debit1(String pay_debit1) {
        this.pay_debit1 = pay_debit1;
    }

    public String getPay_balance1() {
        return pay_balance1;
    }

    public void setPay_balance1(String pay_balance1) {
        this.pay_balance1 = pay_balance1;
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public View_Statement_Model(String mem_name, String pay_date, String pay_fixed,String pay_deposit,String pay_remaining, String type) {
        this.mem_name = mem_name;
        this.pay_date = pay_date;
        this.pay_fixed = pay_fixed;
        this.pay_deposit = pay_deposit;
        this.pay_remaining = pay_remaining;
        this.type = type;
    }
}


