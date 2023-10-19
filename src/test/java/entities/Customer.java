package entities;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class Customer {
    private int id;
    private String fullName;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Customer existCustomer;

    public Customer() {
    }
    public Customer(String fullName) {this.fullName = fullName;}
    public Customer(int id, String fullName, String email, String phone, String address, String password) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public Customer(String fullName, String email, String phone, String address, String password) {
        this.id = Data.getId();
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomerDetails() {
        return existCustomer;
    }

    @Override
    public String toString() {
        return id +
                "," + fullName +
                "," + email +
                "," + phone +
                "," + address +
                "," + password + "\r\n";
    }

    public boolean isTakenEmail() {
        List<Customer> customers;
        customers = Data.getCustomers();
        int flag = 0;
        for (Customer customer : customers) {
            if (customer.getEmail().equals(this.getEmail())) {
                flag = 1;
                existCustomer = customer;
                break;
            }
        }
        return flag == 1;
    }

    public boolean isValidEmail() {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(this.getEmail());
        return matcher.find();
    }



    }






