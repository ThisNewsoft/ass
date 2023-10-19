Feature: Add new order

  Scenario: add order for exist customer
    Given a customer with name "ali@gmail.com" and id=101

    And  a product with name "carpet" and category="CARPET" and material="test"    and coast= 95.0
    When the customer orders the products


    And a unique order Id will generated to the order
    And the order added successfully



  Scenario: add order for new customer
    Given a customer with name "Alaa Hasan" and id=0
    And  a product with name "carpet" and category="CARPET" and material="test"    and coast= 95.0
    When the customer orders the products


    And a unique order Id will generated to the order
    And the order added successfully

