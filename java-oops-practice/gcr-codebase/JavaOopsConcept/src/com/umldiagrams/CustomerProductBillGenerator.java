/*
Class Diagram
The class diagram models the system where a customer buys products, and the bill is generated.
Diagram Description:
Classes: Customer, Product, BillGenerator
Relationships:
A Customer can purchase multiple Product items (Composition).
BillGenerator computes the total for the Customer.

*/									
																
																
																
																
																
																
																+----------------------+
																|       Customer       |
																+----------------------+
																| - customerId : int   |
																| - name : String      |
																+----------------------+
																| + addProduct()       |
																| + getProducts()      |
																+----------------------+
																		  ◆
																		  |
																		  | Composition
																		  |
																+----------------------+
																|        Product       |
																+----------------------+
																| - productId : int    |
																| - productName:String |
																| - price : double     |
																+----------------------+
																| + getPrice()         |
																+----------------------+

																		Association
																+----------------------+
																|     BillGenerator    |
																+----------------------+
																|                      |
																+----------------------+
																| + calculateTotal()   |
																| + generateBill()     |
																+----------------------+
																			|
																			|
																			|
																		+---------+
																		| Customer|
																		+---------+
