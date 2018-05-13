package com.jpm.sales;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpm.sales.entities.Sale;
import com.jpm.sales.util.SalesProcessor;

public class ParseSales {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Sale> sales = Arrays.asList(mapper.readValue(new File("resources/sales/sales.json"), Sale[].class));
        SalesProcessor processor = new SalesProcessor();
        processor.processSales(sales);
    }

}
