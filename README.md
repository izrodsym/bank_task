# bank_task
Implement a class structure to represent the operation of a bank

Customers of the bank may open deposit or credit accounts in a bank. Each client has the following characteristics:
• Name
• Address
• Cash on hand (cash on hand)
• Monthly salary in BGN
• List of Bank Deposits
• List of Bank loans

The customer can perform the following operations:
• Can open a deposit for a certain amount and a certain period
• Can ask for a loan
• Can deposit money on loans.

The bank has the following characteristics:
• Name
• Address
• Banking products (deposits and loans)
• Cash availability (we will assume that the bank operates only in BGN). The cash balance cannot be less than 10% of all deposits in the bank. This is called bank reserve.

The bank can perform the following operations:
• Accepting a deposit of a certain amount. In such a case, the cash availability of the bank is increased by the amount of the deposit and the reserve is increased by 90% of the amount of the deposit
• Payment of interest on all bank deposits. The bank adds to all deposits an amount equal to the interest on the deposit multiplied by the amount of the deposit. To do this, you need a method that calculates the interest on the deposit.
• Issuance of credit for a certain amount and for a certain period in months. The interest rate on the loan is fixed. The bank must check whether the total installment on the client's loans does not exceed 50% of his monthly salary. If it does not exceed, the bank grants credit to the customer, if it exceeds the credit is granted. If the requested loan amount exceeds the bank reserve, the bank cannot grant the loan. To do this, you need a method that calculates the deposit fee.

Each bank account/product has:
• Account name
• The bank account can be a credit or a deposit
• Annual interest rate (positive number)
• Product period in months (from 1 to 60 months)
• Monthly installment in case of credit
• Monthly amount paid in case of deposit
• Availability in BGN (may be negative in case of credit)

The bank can grant loans and accept deposits from customers. Accordingly, to open a deposit account or credit accounts. A customer can leave their money on deposit only if their cash balance is positive. When a person decides to leave their money on deposit, then their cash balance is reduced by the money for the deposit, and the bank's cash balance is increased by the amount of the deposit.

A customer can take a loan from a bank at any time only if the total amount of monthly installments on all his loans is not more than 50% of his salary. The bank can grant a loan to the client only if the cash availability of the bank minus the amount of the loan is greater than 10% of the total amount of deposits in the bank. When the bank extends a loan to a customer, then the customer's cash availability in cash increases by the amount of the loan, and the bank's cash availability decreases by the amount of the loan.

To implement a demo program that has the following characteristics:
1. To create an abstract class for a banking product with the main characteristics described above.
2. To create separate deposit and credit classes that inherit the banking product.
3. To create 2 deposits - Short Deposit with a period of 3 months and interest 3% and Long Deposit with a period of 12 months and interest 5%.
4. To create 2 credits - Home Credit with an interest rate of 6% and Consumer Credit with an interest rate of 10%. As the loan period is determined by the client from the bank.
5. To establish 1 bank in Bulgaria
6. To create 10 customers with different cash and monthly salary. Initially, customers do not have deposits and loans. Put these clients in the $clients array.
7. Initially, all 10 customers deposit 80% to 100% (based on a random number) of the money in the bank.
8. Then write the bank's cash availability as well as its cash reserve.
9. Each of these customers to randomly take loans from the bank.
10. To print information (all properties) about all customers, all deposits, all granted loans and information about the state of the bank
