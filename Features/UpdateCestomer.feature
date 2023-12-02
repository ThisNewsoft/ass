Feature:  Admin update/add Customer account


  Scenario: admin update Customer account:change the phone of the customer
    Given that I choose to update customer info
    When I select to update my phone and I enter my new phone = "0287465182"
    Then my phone number will updated successfully

  Scenario:admin update Customer account:change the address of the customer
    Given that I choose to update customer info
    When I select to update my address and I enter my new address = "Jericho"
    Then my address will updated successfully





























  Scenario: admin add Customer done successfully
    Given I choose to delete Appointments
    When I enter the Appointments Id="202"
    Then then  successfully


