Feature: Admin see his page when he logged in

  Scenario: admin want to see all customers
    Given tha the admin logged in
    When he select to see all customers
    Then the customers will printed

  Scenario: admin want to see all Installation Appointments
    Given tha the admin logged in
    When he select to see all Installation Appointments
    Then the Installation Appointments will printed
