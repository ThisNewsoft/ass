package entities;

import java.util.Objects;

public class Product {
    private String name;
    private String pictureName;

    private String material;

    private Category category;

    private Double cost;
    private int orderId;
    public Product() {

    }
    private Product(Builder builder) {
        setName(builder.name);
        setPictureName(builder.pictureName);
        //setDimension(builder.dimension);
      //  setNumOfSofa(builder.numOfSofa);
        setMaterial(builder.material);
      //  setSpecialTreatment(builder.specialTreatment);
        setCategory(builder.category);
       // setCover(builder.cover);
        setCost(builder.cost);
        setOrderId(builder.orderId);

    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }



    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getPictureName() {
        return pictureName;
    }
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getCost() {return cost;}
    public void setCost(Double cost) {this.cost = cost;}
    @Override
    public String toString() {

        return String.format("%s,%s,%s,%s,%s,%s", name, pictureName, material, category, cost, orderId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return orderId == product.orderId && Objects.equals(name, product.name) && Objects.equals(pictureName, product.pictureName) &&   Objects.equals(material, product.material)&& category == product.category && Objects.equals(cost, product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pictureName, material, category,cost, orderId);
    }

   // public static double carpetCost(Double dimension){
    //    double []costCat = ProductFile.getCostOfCategory();
    //    return dimension * costCat[0];
   // }
  //  public static double sofaCost(Integer numOfSofa){
       // double []costCat = ProductFile.getCostOfCategory();
    //    return numOfSofa * costCat[1];
  //  }

    public static double coverCost(String sizeOfCover){
        double costOfProduct ;
        double []costCat = ProductFile.getCostOfCategory();
        if(sizeOfCover.equalsIgnoreCase("KING")){
            costOfProduct=costCat[2];
        }else if (sizeOfCover.equalsIgnoreCase("QUEEN")) {
            costOfProduct=costCat[3];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN_XL")) {
            costOfProduct=costCat[4];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN")) {
            costOfProduct=costCat[5];
        }else{
            costOfProduct=costCat[6];
        }
        return costOfProduct;
    }


    public static Builder builder(){
        return new Builder();
    }
    /**
     * {@code Product} builder static inner class.
     */
    public static final class Builder {
        int orderId;
        private String name;
        private String pictureName;
       // private Double dimension;
        // private Integer numOfSofa;
        private String material;
        //private String specialTreatment;
        private Category category;
      //  private SizeOfCover cover;
        private Double cost;
        private Builder() {
            name=null;
            pictureName=null;

            material=null;

            category=null;


        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }


        public Builder setPictureName(String pictureName) {
            this.pictureName = pictureName;
            return this;
        }

        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setCost(Double cost) {
            this.cost = cost;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}