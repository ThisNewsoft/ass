package edu;
import entities.Customer;
import entities.Data;
import java.util.Scanner;
import java.util.logging.Logger;
import entities.Installation;
public class RecordCustomer {
    Logger logger = Logger.getLogger(RecordCustomer.class.getName());
    public Customer newCustomer(){
        Scanner in=new Scanner(System.in);
        Customer customer = new Customer();
        System.err.println("Enter your Name ");
        customer.setFullName(in.nextLine());
        System.err.println("Enter your Email ");
        customer.setEmail(in.nextLine());
        System.err.println("Enter your Phone ");
        customer.setPhone(in.nextLine());
        System.err.println("Enter cust" +
                "" +
                "omer Address ");
        customer.setAddress(in.nextLine());
        System.err.println("Enter your Password ");
        customer.setPassword(in.nextLine());
        customer.setId(Data.getId());
        if(customer.isTakenEmail()){
            System.err.println("This email is already taken ");
            System.err.println(" Pleas Enter new Email");
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
        System.err.println("Donn, Thank you !");
    }
    public void addNewInstallation(Installation customer) {
        Data.storeObject("InstallationApointments",customer);
        Installation login=new Installation();
        login.setId(customer.getId());
        login.setNameProduct(customer.getNameProduct());
        login.setService(customer.getService());
        login.setNameCustomer(customer.getNameCustomer());
        login.setDate(customer.getDate());
        Data.storeObject("InstallationApointments",login);
        System.err.println("Donn, Thank you !");
    }


    public void takenMsg() {
        System.err.println("This email is already taken. ");
    }
}
