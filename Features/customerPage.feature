Feature: Customer see his page when he logged in

  Scenario: the customer wants to see his orders
    Given that the customer is logged in
    When he select to see his orders
    Then his orders will be printed

  Scenario: the customer wants to add new order
    Given that the customer is logged in
When he select to add order
    Then his orders will be printed


  Scenario: the customer wants to change his account so change his phone
    Given that I choose to update customer info
    When I select to update my phone and I enter my new phone = "0287465182"
    Then my phone number will updated successfully

  Scenario: the customer wants to change his account so change his address
    Given that I choose to update customer info
    When I select to update my address and I enter my new address = "Jericho"
    Then my address will updated successfully


  Scenario: the customer wants to see installaion Appointments
    Given that the customer is logged in
    When he select to see installaion Appointments
    Then his installaion Appointments will be printed


















