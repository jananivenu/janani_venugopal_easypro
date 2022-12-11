Feature: Reject approval  functionality Under Project Operations application
@order=3
Scenario: Manager Rejects the submitted Time Entry and user validates the approval status in
Time Entries
 
Given Manager is in Project Operations App

And Clicks on the Approvals tab to reject the entry

When User rejects the submitted Time Entry

Then User Validates the  rejection in Time Entry page