package test.classes;
import entities.Data;
import entities.Installation;
import entities.InstallerAvailable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.CustomerLogin;
import entities.Customer;
import najah.edu.Order;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
public class choiceInstallationAppointments {


    boolean exite=true;
    AdminLogin admin;
    Customer customer;
    InstallerAvailable worker;
    Installation installation;
    List<Installation> workers;
    List<InstallerAvailable> Installer;
    String product;
    String service;
    String state;
    String customerName;
   LocalDate date;
    LocalTime time;
    String timing;

    int id = 202;
    CustomerLogin customerLogin;





    @Given("the customer logged in")
    public void theCustomerLoggedIn() {

        customerLogin=new CustomerLogin();

        customer= Data.getCustomerById(105);
        customerLogin.setCustomer(customer);

        admin = new AdminLogin();

        worker = new InstallerAvailable();
        installation =new  Installation();
        workers = Data.getInstallations();
        Installer= Data.getInstallationsAvailable();
    }
    @Given("I choose to reques  Installation Appointments")
    public void iChooseToRequesInstallationAppointments() {



        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("7\n6\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        customerLogin.customerPage();

        System.setIn(stdin);
        System.setOut(stdout);
    }

    @When("I enter Appointments Id={string}")
    public void iEnterAppointmentsId(String id) {
        this.id = Integer.parseInt(id);
        installation.setId(Integer.parseInt(id));


    }

    @And("enter date={string}")
    public void enterDate(String date) {
        this.date = LocalDate.parse(date);
        installation.setDate(LocalDate.parse(date));

        worker= Data.getInstallationAvailableById(id,LocalDate.parse(date));

        customerLogin.setInstaller(worker);

    }

    @And("enter product name {string}")
    public void enterProductName(String product) {
        this.product =product;
        installation.setNameProduct(product);
    }

    @And("enter car make {string}")
    public void enterCarMake(String service) {
        this.service =service;
        installation.setService(service);
    }

    @Then("Installation Appointments with id={string} become state={string}")
    public void installationAppointmentsWithIdBecomeState(String idd, String state) {
        customerLogin.updateState((id), date);
        this.state=state;

        for (InstallerAvailable worker1:Installer){
            if(worker1.getId()==(id)&& worker1.getDate().equals(date)){
                if(worker1.getState().equals("available"))
                {
                    exite=true;
                    break;


                }
                exite=false;
                break;
            }
        }
       worker.setState("state");

        installation.setTime(worker.getTime());
        installation.setTiming(worker.getTiming());
        installation.setNameCustomer(customer.getFullName());
    }

    @And("the Installation Appointments   request successfuly")
    public void theInstallationAppointmentsRequestSuccessfuly() {
      assertTrue(exite);
        workers.add(installation);
    }



    @Then("the Installation  request fail")
    public void theInstallationRequestFail(){
        assertFalse(exite);
        System.out.println("not available: ");
    }

    @And("a notify message will send to customer")
    public void aNotifyMessageWillSendToCustomer() {
        assertNotNull(Data.getCustomerById(115));
        customerLogin.notifyCustomer(Data.getCustomerById(115));
    }




}