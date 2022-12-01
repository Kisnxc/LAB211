
package data;


public class Borrow {
    protected String bId;
    protected String assetId;
    protected String employId;
    protected int quantity;
    protected String date;

    public Borrow() {
    }

    public Borrow(String bId, String assetId, String employId, int quantity, String date) {
        this.bId = bId;
        this.assetId = assetId;
        this.employId = employId;
        this.quantity = quantity;
        this.date = date;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void show() {
         System.out.printf("|%-4s|%-8s|%-9s|%-8d|%-20s|\n", bId, assetId, employId, quantity, date);
    }
}
