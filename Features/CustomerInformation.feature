Feature: record customer information
  when There is a new customer want to added to system then he
  should enter his name, email, phone, address, password
  then the email should not taken before

  Scenario: record done successfully
    Given that I enter customer name="Ibrahim Ahmed"
    And customer email="ibrahim@gmail.com"
    And customer phone="059823135"
    And customer address="Nablus"
    And customer password="ibrahim"
    When I chose to record new customer
    Then a unique customer ID will be generated for the customer
    And the customer will recorded successfully


  Scenario: record with taken email
    Given that I enter customer name="Ibrahim "
    And customer email="ali@gmail.com"
    And customer phone="059823135"
    And customer address="Nablus"
    And customer password="ibrahim"
    When I chose to record new customer
    Then I show a message that the email is already taken
    And I have option to reenter new email