
package data;

import java.util.ArrayList;


public class Request {
    protected String rId;
    protected String assetId;
    protected String employId;
    protected int quantity;
    protected String date;

    public Request() {
    }

    public Request(String rId, String assetId, String employId, int quantity, String date) {
        this.rId = rId;
        this.assetId = assetId;
        this.employId = employId;
        this.quantity = quantity;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
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
    
    public void show() {
        System.out.printf("|%4s|%4s|%7s|%3d|%20s|\n", rId, assetId, employId, quantity, date);
    }
    
    
    
}
