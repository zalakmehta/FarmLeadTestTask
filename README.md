# FarmLeadTestTask

## Pre-requisites

1. Java 8
2. Maven
3. Chrome Driver

## Build Project

    mvn clean package -DskipTests

## Run Test Suite

    mvn test   


## Test Cases

### Test Scenarios

1. Enter Valid/Invalid UserName & Password 
 
 	A1 - Valid UserName & Password should be able to Login

	A2 - InValid UserName & Password should show error message

	A3 - Leave the field empty should trow an error  

2. Forgot Password Link should be clickable & redirect user to provide email
	
	A1 - Enter Valid/Invalid Email
	
	A2 - back to Login link should redirect user to Login page

	A3 - Clicking on Submit Button with Valid Credentials should send reset link to respective email 

3. Click on create new user

	A1 - Create an Account link allow User to Create new Account with Valid name & email

	A2 - Try to enter Numbers in Name field should throw an error message

	A3 - Enter valid Name & Invalid Email should throw an error message

	A4 - If you have existing account, by clicking on Login button should redirect uder to Login page

4. Click Contact Us Link
	
	A1 - Clicking on Contact Us link should open email client with pre filled help email address


### Manual Test Cases

**1. Click on Forgot Password**

Summary:
By clicking on forgot password user shoud redirect user to email provider page and with valid email should send reset link to the provided email address.

Steps to Reproduce:
1. Click on forgot password link
2. Enter valid email address
3. Click on submit button

Actual Outcome:
By submitting valid email throws error message "Whoops! That email is not associated with an account" and not sending reset link to provided email address.

Expected Outcome:
Shouldn't throw an error message with valid email and send link to provided email address.


**2. Click on ContactUs Link**

Summary:
By clicking on ContactUs link should open email client with prefilled email address.

Expected Outcome:
It should open email client and pre filled with help email address "help@combyne.ag".


**3.Create New Account**

Summary:
User should able to create and login with new account.

Steps to Reproduce:
1. Enter valid First Name
2. Enter valid Last Name
3. Enter valid Email address

Actual Outcome:
With Valid Name and Email address throws an error message "The provided email is invalid".

Expected Outcome:
With Valid email address should create new account for user without an error and redirect to the homepage.


**4. Login with Valid Email address and Password**

Summary:
User should able to login with valid credentials

Steps to Reproduce:
1.Enter Valid email address
2.Enter Valid Password
3.Click on Next

Actual Outcome:
It should not throw an error with valid email.

Expected Outcome:
Its not allow to login with valid email address.
