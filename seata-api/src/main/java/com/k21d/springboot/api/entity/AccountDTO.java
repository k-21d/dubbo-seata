package com.k21d.springboot.api.entity;

import java.io.Serializable;

public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userId;
    private Double amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
