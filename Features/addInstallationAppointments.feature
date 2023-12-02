Feature:Customer request Installation



  Scenario :Customer request Installation Appointments successfuly
    Given I choose to reques  Installation Appointments
    When I enter Appointments Id="202"
    And enter date="2023-01-22"
    And enter product name "telephone-holder"
    And enter car make "Golf"
    Then Installation Appointments with id="202" become state="not-available"
    And  the Installation Appointments   request successfuly
    And a notify message will send to customer



  Scenario :Customer fail request Installation  when id not available
    Given I choose to reques  Installation Appointments
    When I enter Appointments Id="200"
    And enter date="2023-01-22"
    And enter product name "telephone-holder"
    And enter car make "Golf"
    Then  the Installation  request fail
