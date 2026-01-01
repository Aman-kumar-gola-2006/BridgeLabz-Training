													
/*Sequence Diagram
The sequence diagram shows the process of bill generation for a customer.
Scenario: A customer checks out at the grocery store, and the total bill is generated.
Actors:
Customer
BillGenerator
→ Draw the Sequence Diagram
*/
													
													
													
													
													
													
													
															
															
															Customer                  BillGenerator
															   |                            |
															   |   checkout()               |
															   |--------------------------->|
															   |                            |
															   |     calculateTotal()       |
															   |<-------------------------->|
															   |                            |
															   |     generateBill()         |
															   |<-------------------------->|
															   |                            |
															   |   displayTotal(amount)     |
															   |<---------------------------|
