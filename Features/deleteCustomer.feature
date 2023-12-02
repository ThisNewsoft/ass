Feature: Delete Customer
  Scenario: delete Customer done successfully
    Given that the admin choose to delete customer
    When the entered customer Id="120"
    Then the customer will deleted

  Scenario: delete Customer fail
    Given that the admin choose to delete customer
    When the entered customer id is not exist int the recorded customer
    Then the message that the customer not exist will be shown

























