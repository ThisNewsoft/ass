package test.classes;

import entities.Data;
import entities.Installation;
import entities.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.Order;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;

public class AdminPage {
    AdminLogin adminLogin;

    @Given("tha the admin logged in")
    public void tha_the_admin_logged_in() {
        adminLogin=new AdminLogin();
        adminLogin.setEmail("adminClean@gmail.com");
        adminLogin.isLogged();
    }


    @When("he select to see all customers")
    public void heSelectToSeeAllCustomers()  {

        test1(("1\n8\n4\n8\n"));
    }

    @Then("the customers will printed")
    public void theCustomersWillPrinted()  {
        test4("4");
        test2(1,"hgf\nfghgf\ngfd\ntfd\ngfd\n4");
        test2(2,"112");
        test2(2,"hg");
        test2(2,"0");
        test2(3,"jhgh");




    }

    @When("he select to see all Installation Appointments")
    public void heSelectToSeeAllInstallationAppointments() {
        test4("4");
        adminLogin.printInstallation();
    }



    @Then("the Installation Appointments will printed")
    public void theInstallationAppointmentsWillPrinted() {


        for (Installation order : Data.getInstallations()) {

                    System.out.println(order);


                }

            }


    @When("he select to see all product")
    public void heSelectToSeeAllProduct() {
        test4("4");
        adminLogin.printProduct();
    }

    @Then("the product printed")
    public void theProductPrinted() {


        for (Product order : Data.getProduct()) {

            System.out.println(order);


        }

    }

    public void test1(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.adminPage();
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test2(int c,String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.customerOptions(c);
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test4(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.customerMenu();
        System.setIn(stdin);
        System.setOut(stdout);
    }


}
