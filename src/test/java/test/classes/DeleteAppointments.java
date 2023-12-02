
package test.classes;

        import entities.Data;
        import entities.Installation;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import najah.edu.AdminLogin;

        import static org.junit.Assert.*;

        import java.time.LocalDate;
        import java.util.List;
        import java.time.LocalTime;
//import static org.junit.jupiter.api.Assertions.*;

public class DeleteAppointments {
    AdminLogin admin;
    Installation worker;
    List<Installation> workers;

    @Given("I choose to delete Appointments")
    public void i_choose_to_delete_appointments() {
        admin = new AdminLogin();
        worker = new Installation();
        workers = Data.getInstallations();
    }

    int id;

    @When("I enter the Appointments Id={string}")
    public void i_enter_the_appointments_id(String id) {
        this.id = Integer.parseInt(id);
        worker.setId(Integer.parseInt(id));

    }

    @Then("then  successfully")
    public void thenSuccessfully() {

    assertTrue(worker.isExistInstallation()  );

        for (Installation worker1:workers){
            if(worker1.getId()==worker.getId()){
                workers.remove(worker1);
                break;
            }
        }
        assertFalse(workers.contains(worker));

    }


    @Then("The message {string} will be shown")
    public void the_message_will_be_shown(String msg) {
        assertFalse(worker.isExistInstallation
                ());
        assertEquals(0, Data.getInstallationById(id).getId());
        assertEquals("This worker doesn't exist", msg);

    }












}
