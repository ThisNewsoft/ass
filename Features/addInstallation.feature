Feature: Admin add new Installation Appointments



  Scenario : added  new Installation Appointments successfully
    Given  the customer logged in
   And I choose to Add Appointments

    When I enter the Appointments Id="0" the product Name "Sofa" and make "BMW" and Customer Name "bara" and Date "2024-12-07" and Time"05:12" and Timing"Am"
    Then then  successfully







































  Scenario: add  the Installation appointments time
    Given  I choose to add Installation Appointments

    When I enters the Appointments Id="2007"

    Then  will add successfully




  Scenario:customer request  the Installation
    Given  I choose to add Installation Appointments

    When I enters the Appointments Id="202"


    Then  will add successfully



  Scenario:customer fail request the Installation
    Given  I choose to add Installation Appointments

    When I enters the Appointments Id="200"
    Then  the Installation Appointments   request fail