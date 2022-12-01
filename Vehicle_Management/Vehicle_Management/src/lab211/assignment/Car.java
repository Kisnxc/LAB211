
package lab211.assignment;


public class Car extends Vehicle{
    protected String type;
    protected int year;

    public Car() {
        
    }

    public Car(String id, String name, String color, int price, String brand, String type, int year) {
        super(id, name, color, price, brand);
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void printList() {
        String a = String.valueOf(price);
        System.out.printf("|%-7s|%-15s|%-15s|%-10s  |%-20s|%-20s|%-14d|\n",
                           id, name, color, a + " $", brand, type, year);
    }

    @Override
    public int getSpeed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSpeed(int speed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLicense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLicense(boolean license) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
