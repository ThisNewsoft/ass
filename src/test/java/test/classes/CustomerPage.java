package test.classes;

import entities.Customer;
import entities.Data;
import entities.Installation;
import entities.InstallerAvailable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.CustomerLogin;
import najah.edu.Order;
import najah.edu.AdminLogin;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerPage {
    CustomerLogin customerLogin;
   AdminLogin adminLogin;
    Customer customer;
    InstallerAvailable worker;
    boolean done=true;
    @Given("that the customer is logged in")
    public void that_the_customer_is_logged_in() {
        customerLogin=new CustomerLogin();
        customer= Data.getCustomerById(105);
      customerLogin.setCustomer(customer);

    }

    @When("he select to see his orders")
    public void he_select_to_see_his_orders() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("2\n6\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        customerLogin.customerPage();

        System.setIn(stdin);
        System.setOut(stdout);




    }

    @When("he select to add order")
    public void he_select_to_add_order() {
        done=true;
        test();

    }
    @Then("his orders will be printed")
    public void his_orders_will_be_printed() {


        for (Order order:Data.getOrderByCustomer(customer)){
            System.out.println(order);
        }

    }


    @When("he select to see installaion Appointments")
    public void heSelectToSeeInstallaionAppointments() {
        adminLogin=new AdminLogin();
        adminLogin.setEmail("adminClean@gmail.com");
        adminLogin.isLogged();
        adminLogin.printInstallation();
    }

    @Then("his installaion Appointments will be printed")
    public void hisInstallaionAppointmentsWillBePrinted() {

        for (Installation order : Data.getInstallations()) {
            if (order.getId() == 202 && order.getDate() .equals("2023-01-22")) {
                if (worker.getState().equals("available")) {
                    System.out.println(order);


                }

            }
        }

    }

    public void test(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(("1\n6\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        customerLogin.customerPage();

        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test2(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("2\n6\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        customerLogin.customerPage();
        System.setIn(stdin);
        System.setOut(stdout);
    }



}
