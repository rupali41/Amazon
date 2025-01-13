Feature: This feature file tests all scenario of loginPage of amazon.
#1
Scenario: To verify that is user can login with valid credential or not.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Enter valid password in password textbox
And Click on signin button
Then Verify that user logedin successfully or not
#2
Scenario: To verify user login with invalid phone number.
When User click on signin link
And Enter invalid phone number in username textbox
And Click on continue button
Then Verify user get invalid phone number error message
#3
Scenario: To verify user login with valid phone number and invalid password.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Enter invalid password in password textbox
And Click on signin button
Then Verify user get invalid password error message
#4
Scenario: To verify user login with blank password.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Click on signin button
Then Verify user get blank password error message
#5
Scenario: To verify user login with valid phone number and valid password in uppercase.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Enter valid Password in uppercase
And Click on signin button
Then Verify user get invalid password error message 
#6
Scenario: To verify user login with valid phone number and valid password in lowercase.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Enter valid Password in lowercase
And Click on signin button
Then Verify user get invalid password error message
#7
Scenario: To verify when user click on forget password link it redirected to password assistance page.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Click on forget password link
Then Verify user is redirected to password assistance page
#8
Scenario: To verify when user redirect to login page default cursor focus should on username textbox
When User click on signin link
Then Verify cursor focus is on username textbox
#9
Scenario: To verify when user enter password it is masked by dot.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Enter valid password in password textbox
Then Verify password masking is performed
#10
Scenario: To verify when user enter phone number less that ten digit gives invalid phone number error.
When User click on signin link
And Enter phone number less than ten digit
And Click on continue button
Then Verify user get error message as Incorrect phone number
#11
Scenario: To verify when user enter non numeric phone number should get error message.
When User click on signin link
And Enter non numeric phone number in username textbox
And Click on continue button
Then Verify user get error message as Wrong or Invalid email address or mobile phone number. Please correct and try again.
#12
Scenario: To verify amazon logo is present on login page.
When User click on signin link
Then Verify is amazon logo is present on login page or not
@today
#13
Scenario: To verify is Paste functionality working in password text box.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Paste the password in password text box
Then Verify is paste functionality working or not
#14
Scenario: To verify when user enter valid credential and hit enter user should get successfully loged in.
When User click on signin link
And Enter valid phone number in username textbox
And Hit enter key on continue
And Enter valid password in password textbox
And Hit enter key on sigin
Then Verify that user logedin successfully or not
#15
Scenario: To verify when user enter invalid email format user should get error message.
When User click on signin link
And Enter invalid email format
And Click on continue button
Then Verify user get error message as Wrong or Invalid email address or mobile phone number. Please correct and try again.
#16
Scenario: To verify login page title.
When User click on signin link
Then Verify login page title is as expected
#17
Scenario: To verify when user click on create account button user should redirect to create account page.
When User click on signin link
And Click on create account button
Then Verify is user redirect on create account page or not
#18
Scenario: To verify when user click on amazon logo it should navigate to amazon home page.
When User click on signin link
And Click on amazon logo
Then Verify is user navigate to amazon home page or not
#19
Scenario: To verify when user enter valid phone number and leave password blank it should get error.
When User click on signin link
And Enter valid phone number in username textbox
And Click on continue button
And Click on signin button
Then Verify is it giving error message or not
#20
Scenario: To verify when user enter blank email id
When User click on signin link
And Click on continue button 
And Wait for Enter your email or mobile phone number error message to appear
Then Verify error message is as expected or not
