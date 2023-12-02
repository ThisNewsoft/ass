package entities;

import najah.edu.Order;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProductFile {
    static RandomAccessFile fromFile;
    static Logger logger = Logger.getLogger(ProductFile.class.getName());
    public static List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        try {
            fromFile=new RandomAccessFile("src/main/resources/Back/product", "rw");
            fromFile.seek(0);
            String productSplit;
            Product product;
            while ((productSplit = fromFile.readLine()) != null){
                String[] array = productSplit.split(",");
                Double dimension=array[2].equals("")?null:Double.parseDouble(array[2]);
                Integer numOfSofa=array[3].equals("")?null:Integer.parseInt(array[3]);

                product=Product
                        .builder()
                        .setName(array[0])
                        .setPictureName(array[1])

                        .setMaterial(array[2])

                        .setCategory(Category.valueOf(array[3]))
                        .setCost(Double.parseDouble(array[4]))
                        .setOrderId(Integer.parseInt(array[5]))
                        .build();
                products.add(product);
            }
            fromFile.close();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return products;

    }
    public static void storeProducts(List<Product> products) {
        try(RandomAccessFile writer = new RandomAccessFile("src/main/resources/Back/product", "rw")){
            for (Product product:products) {
                writer.seek(writer.length());
                writer.write(product.toString().getBytes());
                writer.write("\n".getBytes());
            }
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
    public static List<Product> getProductByOrder(int id){
        List<Product> products=new ArrayList<>();
        for (Product product1:getProduct()){
            if(product1.getOrderId()==id){
                products.add(product1);
            }
        }
        return products;
    }

    public static double discount(double total){
        double disc;
        if(total>=500){
            disc = 0.2;
        }else if(total>=150){
            disc = 0.15;
        }else if(total>=100){
            disc = 0.07;
        }else{
            disc=0;
        }
        return disc;
    }


    public static double[] getCostOfCategory(){
        double []costCat=new double[7];
        try {
            fromFile=new RandomAccessFile("src/main/resources/Back/Cost.txt", "rw");
            fromFile.seek(0);
            String costSplit=fromFile.readLine();
            String[] array=costSplit.split(",");
            for (int i=0;i<array.length;i++){
                costCat[i]=Double.parseDouble(array[i]);
            }
            fromFile.close();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return costCat;
    }

    private ProductFile(){}
}