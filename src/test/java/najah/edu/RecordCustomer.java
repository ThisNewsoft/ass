package najah.edu;
import entities.Customer;
import entities.Data;
import java.util.Scanner;
import java.util.logging.Logger;

public class RecordCustomer {
    Logger logger = Logger.getLogger(RecordCustomer.class.getName());
    public Customer newCustomer(){
        Scanner in=new Scanner(System.in);
        Customer customer = new Customer();
        System.err.println("Enter customer Name ");
        customer.setFullName(in.nextLine());
        System.err.println("Enter customer Email ");
        customer.setEmail(in.nextLine());
        System.err.println("Enter customer Phone ");
        customer.setPhone(in.nextLine());
        System.err.println("Enter cust" +
                "" +
                "omer Address ");
        customer.setAddress(in.nextLine());
        System.err.println("Enter customer Password ");
        customer.setPassword(in.nextLine());
        customer.setId(Data.getId());
        if(customer.isTakenEmail()){
            System.err.println("This email is already taken and this is his details");
            System.err.println("Enter new Email");
            customer.setEmail(in.nextLine());
        }
        addNewCustomer(customer);
        return customer;
    }
    public void addNewCustomer(Customer customer) {
        Data.storeObject("Customer",customer);
        Login login=new Login();
        login.setEmail(customer.getEmail());
        login.setPassword(customer.getPassword());
        login.setRul("customer");
        Data.storeObject("Login",login);
        System.err.println("You have been one of our Customer, Thank you!");
    }

    public void takenMsg() {
        System.err.println("This email is already taken. ");
    }
}
