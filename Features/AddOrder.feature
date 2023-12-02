Feature: Add new order

  Scenario: add order for exist customer
    Given a customer with name "ali@gmail.com" and id=101

    And  a product with name "telephon-holder" and category="INTERIOR" and material="available"    and coast= 10.0
    When the customer orders the products

    Then the order added successfully




  Scenario: add order for new customer
    Given a customer with name "Alaa Hasan" and id=0
    And  a product with name "telephon-holder" and category="INTERIOR" and material="available"    and coast= 10.0
    When the customer orders the products

    Then the order added successfully




































  Scenario: add Installation time
    Given a customer with name "Alaa Hasan" and id=0
    Then the order added successfully