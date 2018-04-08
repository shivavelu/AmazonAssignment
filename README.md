# AmazonAssignment
Framework Instructions:
1. Framework is designed using Page Object Model (POM) approach with Page Factory
2. Project is used Maven( build tool)
3. Used Java and Selenium for UI Automation
4. Chrome and Firefox driver is used for testing application
5. TestNG used for test execution and control engine
6. log4j used for track log
7. Snapshot folder to keep failed test cases screen capture
8. Maven POM.xml all dependency and plugin added
9. Used Extent report the shown the test results
10. Utility file has action which going to be performed frequently


Test Instructions:
1. Category and search product is made generic
2. Category and search product being externalized in josn file, so that user could change for other
 Category and product by change in json file
3. Test Data is read from json file
4. Test environment is refer from property file
5. pages class is defined to interact with each pages through variables and methods
6. Test output is printed on console
7. For test execution use Testng.xml file in where test case being added


Reason for choosing this approach:
1. considering E-commerce application which involves many pages, to cover end to end business process flow
 hence POM is suitable for this application, if form based application like CRM data driver would suite
as have to fill the many forms with huge fields frequently
2. Json is lightweight and easily understandable and maintainable one, having said that used data driven from 
Json file.

Mode of running test:
1. Clone/download this git project to Eclipse IDE,
2. project directory look for testng.xml file right click and run as testing suite 
3. From command prompt navigate to this project directory, run following command
 mvn clean
 mvn install
