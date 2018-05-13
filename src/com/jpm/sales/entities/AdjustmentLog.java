package com.jpm.sales.entities;

public class AdjustmentLog {
    
    String adjustmentType;
    Float adjustmentPrice;
    String product;
    Integer saleCount;
    Float initialSaleprice;
    Float finalSalePrice;
    
    public AdjustmentLog(String adjustmentType, Float adjustmentPrice, String product, Integer saleCount,
            Float initialSaleprice, Float finalSalePrice) {
        super();
        this.adjustmentType = adjustmentType;
        this.adjustmentPrice = adjustmentPrice;
        this.product = product;
        this.saleCount = saleCount;
        this.initialSaleprice = initialSaleprice;
        this.finalSalePrice = finalSalePrice;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Float getInitialSaleprice() {
        return initialSaleprice;
    }

    public void setInitialSaleprice(Float initialSaleprice) {
        this.initialSaleprice = initialSaleprice;
    }

    public Float getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(Float finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }

    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ajustment - \"").append(adjustmentType).append(" ").append(adjustmentPrice).append("\"")
        .append(" to product ").append(product).append(". Total sales affected ").append(saleCount)
        .append(", adjustment of sale price from ").append(initialSaleprice).append(" to ")
        .append(finalSalePrice);
        return builder.toString();
    }
}
