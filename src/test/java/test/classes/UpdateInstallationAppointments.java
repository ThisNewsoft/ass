
package test.classes;

        import entities.Data;
        import entities.Installation;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import najah.edu.*;
        import io.cucumber.java.PendingException;

        import java.time.LocalTime;
        import java.util.List;

        import java.time.LocalDate;
        import entities.Data;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import najah.edu.CustomerLogin;
        import najah.edu.Login;

//import static org.junit.jupiter.api.Assertions.*;

        import java.util.List;

        import static org.junit.Assert.*;


public class UpdateInstallationAppointments {
    AdminLogin admin;
    Installation installation;
    private String value;

    List<Installation> workers;

    @Given("I choose to update Installation Appointments")
    public void iChooseToUpdateInstallationAppointments() {
        installation= new Installation();
        admin = new AdminLogin();
        installation.setId(202);

        installation = new Installation(202, "telephone-holder", "Golf", "Ruba", LocalDate.parse("2023-01-22"), LocalTime.parse("05:00"), "Pm");


    }

    @When("I select to update  time then I enter my new time")
    public void iSelectToUpdateTimeThenIEnterMyNewTime() {
        assertTrue(installation.isExistInstallation());


        admin.NewTime(installation, "06:00", "Pm");


        //throw new io.cucumber.java.PendingException();
    }

    @Then("will updated successfully")
    public void willUpdatedSuccessfully() {

        assertEquals(LocalTime.parse("06:00"),installation.getTime());


    }


}