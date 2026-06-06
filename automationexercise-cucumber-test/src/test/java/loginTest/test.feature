Feature: Login Feature

Scenario: Verify the Homepage logo 

Given Open browser "chrome"
And Navigate to Website URL "https://automationexercise.com/"
When Click Login 
Then  Enter EmailId "admin1002000@gmail.com" and Password "Admin123"
And Verify " Logged in as Admin " is visible