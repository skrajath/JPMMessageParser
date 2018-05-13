# JPMMessageParser
Sales Message parsing

Input is json file containing sales info. 
-

Message Type 1 - single sale, adjsutment is set to null
```
{
  "productType":"Banana",
  "saleCount":1,
  "unitPrice":10,
  "adjsutmentType":null,
  "adjustmentPrice":null
}
```
Message Type 2 - multiple sales, adjustment is set to null
```
{
  "productType":"Banana",
  "saleCount":4,
  "unitPrice":10.23,
  "adjsutmentType":null,
  "adjustmentPrice":null
}
```
Message Type 3 - sale with adjustment
```
{
  "productType":"Banana",
  "saleCount":3,
  "unitPrice":11,
  "adjustmentType":"ADD",
  "adjustmentPrice":20
}
```

Output is printed to console
-
```
######## Sales Report ########
Total sales of Apple : 85 and its total value is 5050.0
Total sales of Mango : 57 and its total value is 2456.76
Total sales of Banana : 42 and its total value is 1381.1399
##############################
######## Adjustment Report ########
Ajustment - "ADD 20.0" to product Banana. Total sales affected 1, adjustment of sale price from 10.0 to 30.0
Ajustment - "ADD 20.0" to product Banana. Total sales affected 4, adjustment of sale price from 10.23 to 30.23
Ajustment - "ADD 20.0" to product Banana. Total sales affected 3, adjustment of sale price from 11.0 to 31.0
Ajustment - "ADD 2.0" to product Mango. Total sales affected 3, adjustment of sale price from 7.23 to 9.23
Ajustment - "ADD 2.0" to product Mango. Total sales affected 4, adjustment of sale price from 7.0 to 9.0
###################################
```

In the Adjustment report, each sale of the product (not each message) is adjusted to the adjustment price.

Design
-------
Json file is read using Jackson library

Class
----
```
Sale - Sales Message data is read into Sale object from Json
Product - Contains product details with history of each transaction/sale of the product
Transaction - Each sale message is formatted to transaction object which is stored in each product object
AdjustmentLog - The Log class, to store adjustment of a sale

SalesParser - The core engine, parses the sales messages and prints the reports
ParseSales - Main method to run the app
```
Resources
---
Project directory contains resources folder
```
resources/lib - contains external libs required
resources/sales - contains json input files 
```

Repository
---------
Repository contains all source files and resource files (except external lib). Also a zip folder is available, which is Eclipse project, which can be imported to eclipse.

Command
---
Run ParseSales.java file.
Input can be edited 'resources/sales/sales.json' file.

