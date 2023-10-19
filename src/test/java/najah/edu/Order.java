package najah.edu;

import entities.Customer;
import entities.Data;
//import entities.Worker;
import entities.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Order {
    private int id;
    private Customer customer;
    private String name;
   // private LocalDate date;
    private double total;
  //  private boolean paid;
    private  List<Product> products;
   // private Worker worker;
   // public Worker getWorker() {
       // return worker;
  //  }
  //  public void setWorker(Worker worker) {
   //     this.worker = worker;
   // }
    //public boolean getPaid() {
      //  return paid;
   // }
   private int number;
    @Override
    public String toString() {

        return customer.getId()+","+id+","+name+","+number+"\r\n";
    }
    public  String getString(){
        String threeSpace="\t\t\t";
        StringBuilder str;
        str = new StringBuilder(this.getId() + "\t\t" + this.getCustomer().getFullName() + threeSpace+
               threeSpace+threeSpace + this.getStatus() + threeSpace + this.getName() +
                threeSpace+ "\n");
        for (Product product:this.getProducts()){
          str.append(product.toString()).append("  ").append("\n");
        }
        str.append("\t\t\n");
        return str.toString();
    }

  //  public LocalDate getDate() {
   //     return date;
   // }
    public Order() {
        products=new ArrayList<>();
    }
   // public void setDate(LocalDate date) {
    //    this.date = date;
  //  }
    public void setNumber(int number) {
        this.number = number;
    }
   // private  List<Product> products;

    public Customer getCustomer() {
        return customer;
    }
    public void setProducts(List<Product> products) {
        this.products = products;

    }
    public List<Product> getProducts() {
      return products;
   }
    public int getStatus() {
        return number;
    }
  // public Order(List<Product> products, String status) {
  //    this.id= Data.getOrderId();
     // this.date=LocalDate.now();
   //    this.products=products;
 //    this.status=status;
  //     this.name=getName();

  //  }

   public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCustomer(Customer customer) {
        this.customer=customer;



    }


    public double getTotal(){
        return total;
    }
    public void displayStatus() {
        logger.info("The Order Status is: "+this.getStatus());
    }
    static Logger logger = Logger.getLogger(Order.class.getName());


}
