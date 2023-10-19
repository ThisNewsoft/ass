package najah.edu;

import entities.*;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.view.JasperViewer;
import java.util.*;
import java.util.logging.Logger;

public class AdminLogin {
    Admin admin=new Admin();
    Logger logger = Logger.getLogger(AdminLogin.class.getName());
    String msg="Enter valid number";
    String msgInv="Invalid Input, try again";
    String statusString ="waiting";
    private boolean logged;
    public void setEmail(String email) {
        this.admin.setEmail(email);
    }
    public void adminMenu() {
        logger.info("To see all customers details enter number 1 ");
   //     logger.info("To see all workers details enter number 2 ");
        logger.info("To see all orders details enter number 3 ");
        logger.info("To add new order enter number 4");
   //     logger.info("To generate report about financial information  enter number 5");
     //   logger.info("To generate report about Business enter number 6");
      //  logger.info("To update the cost of category enter 7");
        logger.info("To logout enter number 8");
    }
    public void customerMenu() {
        while (true) {
            logger.info("If you want to add new customer enter number 1");
            logger.info("If you want to delete customer enter number 2");
        //    logger.info("If you want to contact customer enter number 3");
            logger.info("If you want to back enter number 4");
            Scanner in = new Scanner(System.in);
            int x ;
            x = in.nextInt();
            if(x==1){
                RecordCustomer customer=new RecordCustomer();
                customer.newCustomer();

            } else if (x==2) {
                deleteCustomer();
            }
            if(x==4){
                break;
            }
        }
    }

    public void adminOptions(int option){
        if (option == 1) {
            List<Customer> customers = Data.getCustomers();
            logger.info("****************************************************Customers**********************************************************");
            logger.info("ID               Name                                Email                           Mobile Number" +
                    "                        Address  " +
                    "");
            for (Customer customer : customers) {
         //       logger.info(customer.getId() + "\t\t\t\t" +customer.getFullName() + getSpaces(customer.getFullName()) + customer.getEmail() + getSpaces(customer.getEmail())
            //            + customer.getPhone() + getSpaces(customer.getPhone()) + customer.getAddress()
               // );
            }
            customerMenu();

        }

        else if (option==2) {

        }
        else if (option == 3) {
            logger.info("********************************************************************************************************************************");
            logger.info("Order ID\t   Customer Name\t\t   Order Date\t\t\t  Total Coast\t\t  Order Status \n Products: ");
            for (Order order:Data.getOrders()){
                logger.info(order.getString());
                logger.info("********************************************************************************************************************************");
            }
            orderMenu();

        }
        else if (option == 4) {
     //       takenOrder();
        } else if (option==5) {

        } else if (option==6) {


        } else if (option==7) {
      //      ProductFile.updateCostOfCategory();
        }
    }
    public void customerOptions(int option) {
        if(option==1){
            RecordCustomer customer=new RecordCustomer();
            customer.newCustomer();

        } else if (option==2) {
            deleteCustomer();
        }
    }
    public void deleteCustomer() {
        logger.info("Enter the ID of the customer you want to delete ");
        Scanner in=new Scanner(System.in);
        Customer customer=new Customer();
        try {
            int id=in.nextInt();
            customer=Data.getCustomerById(id);

        }
        catch (InputMismatchException e){
            logger.info(msgInv);
        }
        deleteCustomer(customer);
    }
    public void deleteCustomer(Customer customer){
        int flag=0;
        List<Customer>customers=Data.getCustomers();
        for(Customer customer1:customers){
            if(customer1.getId()==(customer.getId())){
                customers.remove(customer1);
                flag=1;
                break;
            }
        }
        if(flag==1) {
            Data.updateCustomers(customers);
            logger.info("The customer removed successfully");
        }
        else {
            logger.info("This Customer is not exist in our customers");
        }

    }
    public void orderMenu() {
        boolean cond=true;
        while (cond) {
            Scanner in = new Scanner(System.in);
            int x;
            logger.info("If you want to change the order status enter number 1");
            logger.info("If you want to invoice the order enter number 2");
            logger.info("If you want to back enter number 3");
            try {
                x = in.nextInt();

            } catch (Exception ignored) {
                logger.info(msg);
                break;
            }
            if(x!=3){
                orderOptions(x);
            }else{
                cond=false;
            }
        }
    }
    public void orderOptions(int x) {
        Scanner in=new Scanner(System.in);
        if(x==1){
            logger.info("Enter the order number you want to change it's Number  ");
            int orderId=in.nextInt();
            logger.info("Enter the new status for this order ");
            in.nextLine();
            String status=in.nextLine();
            changeStatus(orderId,status);
            List<Order>orders=Data.getOrders();

            Data.updateOrders(orders);

        }
        else if (x==2) {
            logger.info("Enter the order ID you want to invoice ");
            int id=in.nextInt();
            if(isExistOrder(id)){
                Order order=Data.getOrderByID(id);
                List<Order>orders=Data.getOrders();
                for (Order order1:orders){
                    if(order1.getId()==id) {
                  //      order1.setPaid(true);
                        break;
                    }
                }
                Data.updateOrders(orders);
            //    invoice(order);
            }
            else {
                logger.info("This Id is not exist try again");
            }
        }

    }
    public boolean isExistOrder(int id) {
        Order order=Data.getOrderByID(id);
        return order.getId()==id;
    }
    public void changeStatus(int orderId,String status){
        List<Order>orders=Data.getOrders();
        Customer customer=new Customer();
        for (Order order:orders) {
            if (order.getId() == orderId) {
                customer=order.getCustomer();
               // order.setStatus(status);
                break;
            }
        }
        Data.updateOrders(orders);

    }





    public void adminPage(){
        Scanner in=new Scanner(System.in);
        boolean cond=true;
        while (cond) {
            try {
                adminMenu();
                int option = in.nextInt();
                if(option==8){
                    logger.info("Goodbye");
                    cond=false;
                }else{
                    adminOptions(option);
                }

            } catch (Exception e) {
                logger.info("Enter a valid option number ");
                break;
            }
        }
    }
    public boolean isExistCustomer(int id){
        int flag=0;
        for(Customer customer:Data.getCustomers()){
            if(customer.getId()==id){
                flag=1;
                break;
            }
        }
        return flag==1;
    }

}