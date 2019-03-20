Mint

Application objective - Brings all user bank accounts/credit cards into one place and analyze them.
Targets users - public with bank and credit cards.

Features
- Gather transactions of all accounts in one place.
- Show total debts and outstanding money for each accounts.
	- Show transactions for that account.
- Create Budgets (o)
- Analyze spending trends.
- Track bills for credit cards (o)


Assumptions/Constraints

No of users 1 million active users
Request per second - 100 requests per second
Read/Write ratio
	Users mostly read so 90 - R  10 - W
	USers write scenario
		-New budget
		- New goals
		- Change category
	System performs write in the background to dump the transactions into the Mint DB.

Core components:
1. Enter user account information.
2. Fetch transactions from all user accounts.
3. Fetch transactions from stored transactions.
4. Fetch accounts information from stored accounts. 

Model/Schema

Choice of DB:  
1. RDMBS because of the financial nature associated
2. Data has to be consistent.
3. Schema is more or less rigid.

Schema/Tables

1. User Account - accountId, bank_user_name, bank_credentials, bank name, account type, checking number, routing number, credit card number 
2. Transactions - transactionId, accountId, category, description, amount, amountType
3. Banks - bankid, bankname, account type, url


Services 

- fetchLatestTransactions
	- getUserAccountsInformation
- processTransactions
- enterNewAccontInformation
	- connectToUserAccountFinancialService
	- encryptUserCredentials
- fetchStoredTransactions
	- fetchStoredTransactionsPerAccount
- fetchStoredAccountInformatons

Objects

User - enter/update account information, check transactions for particular/all accounts;
Account 
Transaction



