# RetailWebsite
1. Executable class :

BillCounter - This class delegates the transaction details of user to BillCalculator and gets the net payable amount.
The class also consist a method to check if user registered before 2 years

2. Bill Processing classes :

BillCalculatorFactory - It provides the object of specific bill calculator class based on employee type

BillCalculator - its is an interface providing method to implement for calculating net payable amount

Transaction - This class consists the details of the products bought and the user

ProductsFactory - This class represents the details of products available in the store


3. Test class:

TestNetAmountPaybleToCustomer - This is unit tests class  which consists below test cases:
Test case 1: testGenerateBillForEmployees - This class creates dummy transaction details - customerdetails, list of products purchased by customer who is employee of the store and test if net payable amount is calculated correctly

Test case 2: testGenerateBillForAffiliates - This class creates dummy transaction details - customerdetails, list of products purchased by customer who is affiliate to the store and test if net payable amount is calculated correctly

Test case 3: testGenerateBillForCustomerOverTwoYears - This class creates dummy transaction details - customerdetails, list of products purchased by user who is customer for over 2 years and test if net payable amount is calculated correctly

Test case 4: testGenerateBillForCommonCustomers - This class creates dummy transaction details - customerdetails, list of products purchased by any customer who is not applicable for percentage discount and test if net payable amount is calculated correctly



4.Steps to setup the project and execute test cases - 

1. Set up a workspace in Eclipse IDE

2. Download/clone the project

3. Open Project in eclipse

4. Run the test class as JUnit Application
