
package lab211.assignment;


public abstract class Vehicle {
    protected String id;
    protected String name;
    protected String color;
    protected int price;
    protected String brand;

    public Vehicle() {
    }

    public Vehicle(String id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract String getType();
    public abstract void setType(String type);
    public abstract int getYear();
    public abstract void setYear(int year);
    public abstract int getSpeed();
    public abstract void setSpeed(int speed);
    public abstract boolean isLicense() ;
    public abstract void setLicense(boolean license);
        
    
    
    
    public abstract void printList();
        
    
            
}
