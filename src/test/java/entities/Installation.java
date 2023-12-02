package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
public class Installation {
    private int id;
    private String nameProduct;
    private String service;
    private String nameCustomer;
    private LocalDate date;
    private LocalTime time;

    private String timing;
    Category category;
    private List<InstallerAvailable> installer;
    public Installation() { installer=new ArrayList<>();
    }
    public Installation(int id, String nameProduct, String service, String nameCustomer, LocalDate date,LocalTime time,String timing) {
        this.id = id;
        this.nameProduct =nameProduct;
        this.service = service;
        this.nameCustomer = nameCustomer;
        this.date=date;
        this.time=time;
        this.timing=timing;
    }
    public void setInstaller(List<InstallerAvailable> installer) {
        this.installer = installer;

    }
    public static Installation.Builder builder(){
        return new Installation.Builder();
    }

    public List<InstallerAvailable> getInstaller() {
        return installer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public String getNameCustomer() {
        return nameCustomer;
    }
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date =date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
         this.time =time;
    }

    public String getTiming() {
        return timing;
    }
    public void setTiming(String timing) {
        this.timing= timing;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return
                id +
                        "," + nameProduct +
                        "," + service +
                        "," + nameCustomer +
                        "," + date +"," +time+timing+"," +

                        "\r\n";
    }
  //  public boolean isValidEmail() {
      //  String emailRegex= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
     //   Pattern emailPat=Pattern.compile (emailRegex, Pattern.CASE_INSENSITIVE);
    //    Matcher matcher=emailPat.matcher (this.getEmail());
    //    return matcher.find();
   // }
    public boolean isExistInstallation() {
        boolean flag=false;
        for(Installation worker:Data.getInstallations()){
            if(worker.getId()==this.id) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public void updateDate(LocalDate newDate) {
        this.date = newDate;
    }


    public static final class Builder {
        private int id;
        private String nameProduct;
        private String service;
        private String nameCustomer;
        private LocalDate date;
        private LocalTime time;

        private String timing;
        private Builder() {
            nameProduct=null;
            service=null;

            nameCustomer=null;

            date=null;
            time=null;

            timing=null;

        }

        public Installation.Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Installation.Builder setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
            return this;
        }




        public Installation.Builder setService(String service) {
            this.service = service;
            return this;
        }
        public Installation.Builder setNameCustomer(String nameCustomer) {
            this.nameCustomer = nameCustomer;
            return this;
        }

        public Installation.Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Installation.Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Installation.Builder setTiming(String timing) {
            this.timing = timing;
            return this;
        }
        public Installation build() {
            return new Installation(this);
        }
    }

    private Installation(Installation.Builder builder) {
        setId(builder.id);
        setNameProduct(builder.nameProduct);
        setService(builder.service);

        setNameCustomer(builder.nameCustomer);

        setDate(builder.date);

        setTime(builder.time);
        setTiming(builder.timing);

    }
}