package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class InstallerAvailable {
    private int id;
    private String nameInstaller;
    private String state;

    private LocalDate date;
    private LocalTime time;

    private String timing;





    public InstallerAvailable() {
    }
    public InstallerAvailable(int id, String nameInstaller, String state, LocalDate date,LocalTime time,String timing) {
        this.id = id;
        this.nameInstaller =nameInstaller;
        this.state= state;

        this.date=date;
        this.time=time;
        this.timing=timing;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameInstaller() {
        return nameInstaller;
    }
    public void setNameInstaller(String nameInstaller) {
        this.nameInstaller = nameInstaller;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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

    public String toString() {
        return
                id +
                        "," + nameInstaller +
                        "," + state +
                        ","  +
                         date +"," +time+timing+"," +

                        "\r\n";
    }



    public boolean isExistInstallationAvailable() {
        boolean flag=false;
        for(InstallerAvailable worker:Data.getInstallationsAvailable()){
            if(worker.getId()==this.id) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
