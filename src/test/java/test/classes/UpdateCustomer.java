package test.classes;

import entities.Data;
import entities.Installation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.CustomerLogin;
import najah.edu.Login;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import entities.Customer;

public class UpdateCustomer {
    CustomerLogin customer;
    Customer customers;
    private String value;
    @Given("that I choose to update customer info")
    public void that_i_choose_to_update_customer_info() {
        customer=new CustomerLogin();
        customer.setCustomer(Data.getCustomers().get(0));
        customers=new Customer();
       // admin = new AdminLogin();
        customers.setId(202);

        customers = new Customer(115, "lama", "lama@gmail.com", "0287465182", "Jericho", "1234");

    }

    @When("I select to update my phone and I enter my new phone = {string}")
    public void i_select_to_update_my_phone(String phone) {
        value=phone;
        customer.updateInfo("phone",value);
    }

    @Then("my phone number will updated successfully")
    public void my_phone_number_will_updated_successfully() {

        assertEquals(customers.getPhone(), value);
        customer.updateMsg();
    }

    @When("I select to update my address and I enter my new address = {string}")
    public void i_select_to_update_my_address(String address) {
        value=address;
        customer.updateInfo("address",value);
    }



    @Then("my address will updated successfully")
    public void my_address_will_updated_successfully() {
        assertEquals(customers.getAddress(), value);
        customer.updateMsg();
        Data.updateCustomers(Data.getCustomers());
        List<najah.edu.Login> loginList=Data.users();
        for (Login login:loginList){
            if(login.getEmail().equals(customer.getCustomer().getEmail())){
                login.setPassword(value);
                break;
            }
        }
        Data.updateLogin(loginList);
        Data.storeObject("product",new Object());
        Data.storeObject("customer",new Object());

    }

}
