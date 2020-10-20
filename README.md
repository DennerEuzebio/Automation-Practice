# Automation-Practice

This project was developed to test the purchase flow of the automation practice site

## Technologies used

This project uses the following technologies:

- JUnit5
- Maven
- Java 
- ExtentReport
- Javafaker
- WebDriveManager


## Patterns used

**Main/Java**

- **support** : Contains the classes to support the testes, like fakers, reports and file readers.

**Main/Resources**

- **Properties** : Contains the .properties files to store the user and products data.


**Test/Java**

- **PageObjects** : Contains the classes used to map the web elements.

- **Tasks** : Contains the interactions with the web elements.

- **TestCases** : Contains the test scenarios.

- **Validations** : Contains the validations of the tests.

- **TestsSuites** : Contains the suite for the execution of the tests.

## Test scenarios

- **BuyAnItemBasic** : Test the purchase flow of one item, creating a new user and validating some informations in 
the create user form and the address confirmation page. Contains a success and a fail case.

- **BuyMultiplesItens** : Teste the purchase flow of multiples itens, loging in with the last user created 
(wich has the data storaged in the properties file) and validate some cart informations, like the unit price and 
quantity for each item the itens names and the total price. Contains a success and a fail case.

## Running the project

Simply clone it to your computer, import the maven dependencies, build the project and then run the class 
in the **TestsSuites** package ou one of the classes in the **TestCases** package.

Obs: for some reason, if you run the test suite just after cloning the project, the tests will be ignored, because the 
junit-engine blocks the use of the junitPlatform, then, build it before running

## Report

As this project uses the Extent Report dependency, after the first run it wil create a **report** folder in the root
folder of this project, choose the report folder for the execution you want and open the .html file inside of it.