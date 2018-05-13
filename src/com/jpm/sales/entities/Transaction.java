package com.jpm.sales.entities;

public class Transaction {
    Integer saleCount=0;
    Float unitPrice=0f;
    private Float transactionPrice;
    
    public Transaction(Integer saleCount, Float unitPrice,Float transactionPrice) {
        this.saleCount = saleCount;
        this.unitPrice = unitPrice;
        this.transactionPrice = transactionPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Float transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
}
