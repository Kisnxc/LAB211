
package lab211.assignment;


public class Motorbike extends Vehicle{
    private int speed;
    private boolean license;

    public Motorbike() {
        
    }

    public Motorbike(String id, String name, String color, int price, String brand, int speed, boolean license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }
    
    public void printList() {
        String a = String.valueOf(price);
        System.out.printf("|%-7s|%-15s|%-15s|%-10s  |%-20s|%15d km/h|%14s|\n",
                           id, name, color, price +" $", brand, speed, license);
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setYear(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
