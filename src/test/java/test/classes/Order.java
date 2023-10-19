package test.classes;

import entities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


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
        customer=Data.getCustomerBy(name);
        this.name=name;
        customer=Data.getCustomerById(id);
    }

    @And("a product with name {string} and category={string} and material={string}    and coast= {double}")
    public void aProductWithNameAndCategoryAndMaterialAndCoast(String name, String material, String category, double coast) {
        products=new ArrayList<>();
        products.add(Product.builder().setName(name).setMaterial(material).setCategory(Category.valueOf(category)).setCost(coast).build());




    }



    @When("the customer orders the products")
    public void the_customer_orders_the_products() {
        order=new najah.edu.Order();
      order.setProducts(products);
    }



    @Then("a unique order Id will generated to the order")
    public void a_unique_order_id_will_generated_to_the_order() {
        assertTrue(exist);
        assertEquals(2,order.getProducts().size());
        order.setId(Data.getOrderId());
        admin=new AdminLogin();
    }
    @Then("the order added successfully")
    public void the_order_added_successfully() {
        assertTrue(exist);
      assertEquals(2,order.getProducts().size());
     //   admin.addOrder(order);
        System.out.println("The Order added successfully");
       // order.setWorker(new Worker());
        System.out.println(order.getString());
       // order.setPaid(true);
        System.out.println(order.getString());
    }


}
