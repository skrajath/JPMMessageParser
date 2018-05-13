package com.jpm.sales.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale {

    String productType;
    Integer saleCount;
    Float unitPrice;
    String adjustmentType;
    Float adjustmentPrice;

    public Sale(){
        
    }
    
    public Sale(String productType, Integer saleCount, Float unitPrice, String adjustmentType, Float adjustmentPrice) {
        this.productType = productType;
        this.saleCount = saleCount;
        this.unitPrice = unitPrice;
        this.adjustmentType = adjustmentType;
        this.adjustmentPrice = adjustmentPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public String getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Float getAdjustmentPrice() {
        return adjustmentPrice;
    }

    public void setAdjustmentPrice(Float adjustmentPrice) {
        this.adjustmentPrice = adjustmentPrice;
    }
    
    @Override
    public String toString() {
        return "Sale [productType=" + productType + ", saleCount=" + saleCount + ", unitPrice=" + unitPrice
                + ", adjustmentType=" + adjustmentType + ", adjustmentPrice=" + adjustmentPrice + "]";
    }
}
