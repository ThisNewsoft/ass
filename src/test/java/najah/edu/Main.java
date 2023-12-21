package najah.edu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void menu(){
        System.err.println("************Welcome to Car accessories company System************");
        System.err.println("If you want to login enter number 1");
        System.err.println("If you are new customer enter number 2");

    }

    public static void main(String[]args) {



        Scanner in = new Scanner(System.in);
        int option = 0;
        try {
            menu();
            option = in.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("please enter a valid number");
            main(new String[5]);
        }
        if (option == 1) {  userLogin();
        } else if(option==2) {
            RecordCustomer recordCustomer = new RecordCustomer();
            recordCustomer.newCustomer();
        }

    }





    public static void userLogin(){

        Scanner in=new Scanner(System.in);

        System.err.println("***************Welcome Back***************");
        while(true) {
            System.err.println("Enter your email ");
            String email = in.nextLine();
            System.err.println("Enter your password ");
            String password = in.nextLine();
            Login login=new Login();
            login.setEmail(email);
            login.setPassword(password);
            if(email.equals("adminClean@gmail.com")){
                login.setRul("admin");
            }
            else login.setRul("customer");
            if(login.isCorrectInfo()){
                login.login();
                break;
            }
            else {
                System.err.println("Incorrect user name or password, try again");
            }

        }
    }
}