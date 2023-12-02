package test.classes;

import entities.Customer;
import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;


        import entities.Data;
        import entities.Installation;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import najah.edu.AdminLogin;
        import entities.Customer;
        import java.util.List;
        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.InputStream;
        import java.io.PrintStream;

        import static org.junit.Assert.*;
        import static org.junit.Assert.assertEquals;

public class DeletCustomer {
    AdminLogin admin;
    Customer customer;
    List<Customer> customers;

    @Given("that the admin choose to delete customer")
    public void that_the_admin_choose_to_delete_customer() {
        admin = new AdminLogin();
        customer = new Customer();


        customers = Data.getCustomers();
    ;

    }

    int id;

    @When("the entered customer Id={string}")
    public void theEnteredCustomerId(String id) {
        this.id = Integer.parseInt(id);
        customer.setId(Integer.parseInt(id));
    }

    @Then("the customer will deleted")
    public void the_customer_will_deleted() {


        assertTrue(customer.isCustomer()  );

        for (Customer worker1:customers){
            if(worker1.getId()==customer.getId()){
                customers.remove(worker1);
                break;
            }
        }
        assertFalse(customers.contains(customer));

    }

    @When("the entered customer id is not exist int the recorded customer")
    public void theEnteredCustomerIdIsNotExistIntTheRecordedCustomer() {
        customer = new Customer();
        customer = Data.getCustomerById(100);

    }

    @Then("the message that the customer not exist will be shown")
    public void the_message_that_the_customer_not_exist_will_be_shown() {
        assertFalse(admin.isExistCustomer(100));


        assertEquals(0, Data.getCustomerById(100).getId());
        admin.deleteCustomer(customer);

    }



}