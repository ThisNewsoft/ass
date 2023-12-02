Feature: update the Installation information

  Scenario: update  the Installation appointments time
    Given  I choose to update Installation Appointments
    When I select to update  time then I enter my new time
    Then  will updated successfully
