package com.example.flattemp.Model;

public class Recipt {
    String pay_id,pay_date,pay_deposit;

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_deposit() {
        return pay_deposit;
    }

    public void setPay_deposit(String pay_deposit) {
        this.pay_deposit = pay_deposit;
    }

    public Recipt(String pay_id, String pay_date, String pay_deposit) {
        this.pay_id = pay_id;
        this.pay_date = pay_date;
        this.pay_deposit = pay_deposit;
    }
}
