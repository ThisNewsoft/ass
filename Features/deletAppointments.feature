Feature:admin delete Installation appointments

  Scenario: admin delete Installation appointments successfully
Given I choose to delete Appointments
When I enter the Appointments Id="202"
    Then then  successfully




  Scenario: admin  delete Installation appointments fail when enter wrong appointments Id
    Given I choose to delete Appointments
    When I enter the Appointments Id="1"
    Then The message "This worker doesn't exist" will be shown
























































