													
			/*
Object Diagram
An object diagram shows the details of a Customer and the Product objects they have purchased.
Example:
Customer: Alice
Products:
Apples (2 kg at $3 per kg)
Milk (1 liter at $2 per liter)

			*/									
													
													
													
													
													
													+---------------------------+
													| customer1 : Customer      |
													+---------------------------+
													| name = "Alice"            |
													+---------------------------+
																◆
																|
															purchases
																|
													   -------------------------------
													   |                               |
													+-------------------------+   +-------------------------+
													| product1 : Product      |   | product2 : Product      |
													+-------------------------+   +-------------------------+
													| productName = "Apples"  |   | productName = "Milk"    |
													| quantity = 2 kg         |   | quantity = 1 liter      |
													| pricePerUnit = $3       |   | pricePerUnit = $2       |
													+-------------------------+   +-------------------------+
