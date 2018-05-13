package com.jpm.sales.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jpm.sales.entities.AdjustmentLog;
import com.jpm.sales.entities.Product;
import com.jpm.sales.entities.Sale;
import com.jpm.sales.entities.Transaction;

public class SalesProcessor {

    Map<String,Product> products = new HashMap<>();
    List<AdjustmentLog> adjustmentHistory = new ArrayList<>();
    int salesMessageCount = 0;
    
    public void processSales(List<Sale> sales) {
        for(Sale sale:sales){
            String productType = sale.getProductType();
            if(!products.containsKey(productType)){
                Product product = new Product();
                product.setName(productType);
                product.setTransactions(new ArrayList<>());
                proccessTransaction(product,sale);
                products.put(productType, product);
            }else{
                proccessTransaction(products.get(productType),sale);
            }
            salesMessageCount++;
            if((salesMessageCount % 10) == 0){
                generateSalesReport();
            }
            
            if((salesMessageCount % 50) == 0){
                generateAjustmentReport();
                break;
            }
        }
    }

    private void proccessTransaction(Product product,Sale sale) {
        if(sale.getAdjustmentType()==null && sale.getAdjustmentPrice() ==null){
            // Normal Sale
            float totalSaleValue = sale.getSaleCount() * sale.getUnitPrice();
            product.setTotalSales(product.getTotalSales()+sale.getSaleCount());
            product.setTotalValue(product.getTotalValue()+totalSaleValue);
            product.getTransactions().add(new Transaction(sale.getSaleCount(),sale.getUnitPrice(),totalSaleValue));
        }else{
            // Sale with adjustment
            
            //first - adding sale
            float totalSaleValue = sale.getSaleCount() * sale.getUnitPrice();
            product.setTotalSales(product.getTotalSales()+sale.getSaleCount());
            product.setTotalValue(product.getTotalValue()+totalSaleValue);
            product.getTransactions().add(new Transaction(sale.getSaleCount(),sale.getUnitPrice(),totalSaleValue));
            
            //second - adjusting sales 
            for(Transaction tran: product.getTransactions()){
                Integer saleCount = tran.getSaleCount();
                Float initialUnitSalePrice = tran.getUnitPrice();
                Float oldTransactionPrice = tran.getTransactionPrice();
                
                Float newUnitSalePrice = 0f;
                switch(sale.getAdjustmentType()){
                    case "ADD":
                            newUnitSalePrice = initialUnitSalePrice + sale.getAdjustmentPrice();
                        break;
                    case "MUL":
                            newUnitSalePrice = initialUnitSalePrice * sale.getAdjustmentPrice();
                        break;
                    case "SUB":
                            newUnitSalePrice = initialUnitSalePrice - sale.getAdjustmentPrice();
                        break;
                }
                tran.setUnitPrice(newUnitSalePrice); //Sale unit price adjusted
                
                //adjusting total sales value of the transaction
                Float newTransactionPrice = saleCount * newUnitSalePrice;
                tran.setTransactionPrice(newTransactionPrice);
                
                //adjusting total sales value of the product
                product.setTotalValue(product.getTotalValue()+(newTransactionPrice-oldTransactionPrice));
                
                adjustmentHistory.add(new AdjustmentLog(sale.getAdjustmentType(), sale.getAdjustmentPrice() ,
                        product.getName(), saleCount, initialUnitSalePrice, newUnitSalePrice));
            }
        }
    }
    
    private void generateSalesReport() {
        System.out.println("######## Sales Report ########");
        for(Entry<String, Product> entry : products.entrySet()){
            Product product = entry.getValue();
            System.out.println("Total sales of " + entry.getKey() 
                + " : "+product.getTotalSales()
                +" and its total value is "+product.getTotalValue());
        }
        System.out.println("##############################");
    }
    
    private void generateAjustmentReport() {
        System.out.println("######## Adjustment Report ########");
        for(AdjustmentLog adjustmentLog : adjustmentHistory){
            System.out.println(adjustmentLog.generateReport());
        }
        System.out.println("###################################");
    }
}
