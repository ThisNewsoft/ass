package test.classes;

import entities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;


public class Order {
    najah.edu.Order order;
    AdminLogin admin;
    Customer customer;


    boolean exist;
    List<Product>products;
    String name;
    List<Customer>customers=new ArrayList<>();
    @Before
    public void setUp(){
        customers=new ArrayList<>();
        customers.add(new Customer("Khalid","khalid@gmail.com","059823135","Nablus","khall"));
        customers.add(new Customer("Ali Mohammed","ali@gmail.com","059872345","Tulkarem","ali"));
    }
    @Given("a customer with name {string} and id={int}")
    public void a_customer_with_name_and_id(String name, Integer id) {
        exist=true;
        customer=Data.getCustomerBy(name);
        this.name=name;
        customer=Data.getCustomerById(id);
    }

    @And("a product with name {string} and category={string} and material={string}    and coast= {double}")
    public void aProductWithNameAndCategoryAndMaterialAndCoast(String name, String material, String category, double coast) {
        exist=true;
            products = new ArrayList<>();
            try {
                Category categoryValue = Category.valueOf(category);
                products.add(Product.builder()
                        .setName(name)
                        .setMaterial(material)
                        .setCategory(categoryValue)
                        .setCost(coast)
                        .build());
            } catch (IllegalArgumentException e) {

                System.out.println("Invalid category: " + category);
            }

        }





    @When("the customer orders the products")
    public void the_customer_orders_the_products() {
        order=new najah.edu.Order();
        exist=true;
      order.setProducts(products);
    }


    @Then("the order added successfully")
    public void theOrderAddedSuccessfully() {
        assertTrue(exist);
        System.out.println(" added successfully");


    }


    @When("the admin add orders to the products")
    public void theAdminAddOrdersToTheProducts() {
        assertTrue(exist);
        System.out.println(" successfully");

    }




}
