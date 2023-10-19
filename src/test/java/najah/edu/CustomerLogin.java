package najah.edu;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import entities.Customer;
import entities.Data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CustomerLogin {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
    static String path = "src/main/resources/back1/";
    static Logger logger = Logger.getLogger(Data.class.getName());

    public void menu(){
        System.err.println("If you want to add new order enter number 1");
        System.err.println("If you want to see your orders enter number 2");
        System.err.println("If you want to see your information enter number 3");
        System.err.println("If you want to Update your information enter number 4");
        System.err.println("If you want to see all product 5");
        System.err.println("If you want to logout enter number 6");


    }
    private static String readFromFil(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            // Handle file reading error
        }
        return content.toString();
    }

    private static void writeToFil(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            // Handle file writing error
        }
    }



    public static List<String> getObjects(String fileName) {
        List<String> strings = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(path + fileName + ".txt", "rw")) {
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                strings.add(s);
            }
        } catch (Exception e) {//ignored
        }
        return strings;
    }

    public static void storeObject(String fileName, Object object) {
        try (RandomAccessFile raf = new RandomAccessFile(path + fileName + ".txt", "rw")) {

            raf.seek(raf.length());
            raf.write(object.toString().getBytes());
        } catch (Exception e) {
            logger.info("ة");

        }
    }








    private static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }








private static void writeToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void customerPage(){
        System.err.println("Welcome To The Customer Dashboard ");
        Scanner in=new Scanner(System.in);
        int j=1;
        menu();
        try {
            int option = in.nextInt();

            while (true) {
                if (option == 1) {

                    Order  login=new  Order();
                    login.setCustomer(this.customer);



                    String path = "src/main/resources/back1/";

                    Scanner scanner = new Scanner(System.in);
                    System.err.println("Enter the name of Product:");
                    String inputData = scanner.nextLine();


                    System.err.println("Enter the id of Product:");
                    String inp = scanner.nextLine();


                    System.err.println("Enter the number of Product:");
                    String input = scanner.nextLine();

                    String fileName = path + "order.txt";

                    int customerI = customer.getId();
                    String currentContent = readFromFil(fileName);

                    System.err.println("If you want to confirm tho order enter 1 else enter 2 ");
                    int x = in.nextInt();

                    if (x==1) {

                        String newContent = currentContent +customerI + " " +inp + " " + inputData + " " + input + "\n";
                        writeToFil(fileName, newContent);

                        System.out.println("Done. " + inputData + " has been added .");
                        menu();
                        option = in.nextInt();

                    } else if (x ==2) {

                        System.err.println("OK");
                        menu();
                        option = in.nextInt();


                    }
                }


                else if (option == 2) {
                    int customerUniqueId = customer.getId();
                    String filePath = "src/main/resources/back1/order.txt";
                    System.err.println("Customer Name Customer email Order ID product name number of Products:");

                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(" ");

                            if (parts.length > 0) {
                                try {
                                    int uniqueCustomerIdInFile = Integer.parseInt(parts[0]);

                                    if (customerUniqueId == uniqueCustomerIdInFile) {
                                        System.out.println(line);
                                    }
                                } catch (NumberFormatException e) {
                                    // Handle the case where the first part is not a valid integer (e.g., empty string)
                                }
                            }
                        }
                    } catch (IOException e) {
                        // Handle the IOException
                    }
                }




                else if (option == 3) {
                    logger.info(() -> String.valueOf(customer));

                }
                else if (option == 4) {
                    men();
                    int x = in.nextInt();
                    String attribute = "";
                    String  value= "";

                    if (x == 1) {
                     System.err.println("Enter new Phone number");
                   Scanner i = new Scanner(System.in);
                       value = i.nextLine();
                    attribute = "phone";

                    updateMsg();
                       System.err.println("Done");



                    }


                    else if (x == 2) {
                        System.err.println("Enter New Address");
                        Scanner i = new Scanner(System.in);
                        value = i.nextLine();
                        attribute = "address";
                        updateMsg();
                        System.err.println("Done");
                    }
                    else if (x == 3) {
                        System.err.println("Enter new Password");
                        Scanner i = new Scanner(System.in);
                        value = i.nextLine();
                        attribute = "password";

                        updateMsg();
                        System.err.println("Done");

                    }

                    updateInfo(attribute, value);
                } else if (option == 6) {
                    break;
                }


                else if(option==5) {



                            String fileName = "src/main/resources/back1/product";

                            try {

                                FileReader fileReader = new FileReader(fileName);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);

                                String line;

                                while ((line = bufferedReader.readLine()) != null) {
                                    System.out.println(line);
                                }


                                bufferedReader.close();
                            } catch (IOException e) {
                                System.err.println("error while reading " + e.getMessage());
                            }
                        }






            menu();
                option = in.nextInt();

        }
    }
        catch (InputMismatchException e){
            logger.info("please enter a valid number ");
        }
    }




    public void men(){
        System.err.println("If you want to update your Phone enter number 1");
        System.err.println("If you want to update your Address enter number 2");
        System.err.println("If you want to update your Password enter number 3");
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateMsg() {
        System.err.println("Your Information Updated Successfully");
    }

    public void updateInfo(String attribute, String value) {
        if (attribute.equalsIgnoreCase("address")) {
            customer.setAddress(value);
        } else if (attribute.equalsIgnoreCase("password")) {
            customer.setPassword(value);
        } else if (attribute.equalsIgnoreCase("phone")) {
            customer.setPhone(value);
        }


    }
}