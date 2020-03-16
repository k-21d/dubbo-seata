package com.k21d.springboot.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BusinessDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String commodityCode;

    private String name;

    private Integer count;

    private Double amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
