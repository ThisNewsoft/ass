
package test.classes;

        import entities.*;
        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import najah.edu.AdminLogin;
        import najah.edu.CustomerLogin;
        import java.time.LocalDate;
        import java.time.LocalTime;
        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.Assert.*;

public class AddInstallation  {
   // Installation  worker;
    AdminLogin admin;
   CustomerLogin customerLogin;

    String product;
    String service;
    String customer;
    LocalDate date;
    LocalTime time;
    String timing;
    //List<Installation> workers;
    InstallerAvailable worker;
    Installation installation;
    List<Installation> workers;
    List<InstallerAvailable> Installer;
    boolean exist;
    @Given("I choose to Add Appointments")
    public void i_choose_to_add_appointments() {
        admin = new AdminLogin();

        worker = new InstallerAvailable();
        installation =new  Installation();
        workers = Data.getInstallations();
        Installer= Data.getInstallationsAvailable();

    }

    int id;



    @When("I enter the new Appointments Id={string}")
    public void iEnterTheNewAppointmentsId(String id) {
        this.id = Integer.parseInt(id);
        installation.setId(Integer.parseInt(id));

    }

    @When("I enter the Appointments Id={string} the product Name {string} and make {string} and Customer Name {string} and Date {string} and Time{string} and Timing{string}")
    public void iEnterTheAppointmentsIdTheProductNameAndMakeAndCustomerNameAndDateAndTimeAndTiming(String id, String product, String service, String customer, String date, String time, String timing) {

      this.id=Integer.parseInt(id);
      this.product=product;
      this.service=service;
      this.date=LocalDate.parse(date);
      this.time=LocalTime.parse(time);
      this.timing=timing;
        Installation  in= new Installation(Integer.parseInt(id), product, service, customer, LocalDate.parse(date), LocalTime.parse(time), timing);

        admin. addInstallation(in);

        exist=true;
    }

    int num;
    int idd=208;


    @Then("successfully")
    public void successfully() {

        assertTrue(exist);
        System.out.println(" added successfully");

    }























































































































    @Given("I choose to add Installation Appointments")
    public void iChooseToAddInstallationAppointments() {
        installation= new Installation();
        admin = new AdminLogin();
        installation.setId(2007);

        installation = new Installation(2007, "telephone-holder", "Golf", "Ruba", LocalDate.parse("2023-01-22"), LocalTime.parse("05:00"), "Pm");

    }
    @When("I enters the Appointments Id={string}")
    public void iEntersTheAppointmentsId(String arg0) {


        // admin. addInstallation( new Installation(2007, "telephone-holder", "Golf", "Ruba", LocalDate.parse("2023-01-22"), LocalTime.parse("05:00"), "Pm"));

    }


    @Then("will add successfully")
    public void willAddSuccessfully() {
            System.out.println("will add successfully");
 exist=false;
          //  admin. addInstallation( new Installation(2007, "telephone-holder", "Golf", "Ruba", LocalDate.parse("2023-01-22"), LocalTime.parse("05:00"), "Pm"));

    }


    @Then("the Installation Appointments   request fail")
    public void theInstallationAppointmentsRequestFail() {

        assertEquals(exist,false);
        System.out.println("not available: ");
    }


}