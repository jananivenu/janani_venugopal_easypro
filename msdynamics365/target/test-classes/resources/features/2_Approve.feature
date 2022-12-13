
Feature: Approvals functionality Under Project Operations application
@order=2
Scenario: Manager Approves the submitted Time Entry and user validates the approval status in
Time Entries
 
Given User is in Project Operations App

And Clicks on the Approvals tab

When User approves the submitted Time Entry

Then User Validates the  approval in Time Entry page