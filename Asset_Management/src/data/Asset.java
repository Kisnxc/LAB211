
package data;


public class Asset  {
    protected String assetId;
    protected String name;
    protected String color;
    protected int price;
    protected double weight;
    protected int quantity;

    public Asset(String assetId, String name, String color, int price, double weight, int quantity) {
        this.assetId = assetId;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void print() {
        System.out.printf("|%4s|%-25s|%-20s|%-6d|%-6.2f|%-10d|\n",assetId, name, color, price, weight, quantity);
    }
}
