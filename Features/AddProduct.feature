Feature: Admin Add new order for The Product

  Scenario:Admin  add Product
    Given tha the admin logged in

    And  a product with name "telephon" and category="INTERIOR" and material="test"    and coast= 95.0
    When the admin add orders to the products

    Then the order added successfully





  Scenario: Admin add Product for new customer
    Given tha the admin logged in
    And  a product with name "carpet" and category="EXTERIOR" and material="test"    and coast= 95.0
    When the admin add orders to the products

    Then the order added successfully

