
package data;

import cong.util.newpackage.MyToys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class AssetList extends ArrayList<Asset>{

    public AssetList() {
        
    }
    
    public boolean loadFile(String fileName)  {
        try {
            File f = new File(fileName);
            if(f.exists() == false ) return false; 
            else {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String details;                
                while ((details = br.readLine()) != null) {                   
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String id = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    String color = stk.nextToken().trim();
                    int price = Integer.parseInt(stk.nextToken().trim());
                    double weight = Double.parseDouble(stk.nextToken().trim());
                    int quantity = Integer.parseInt(stk.nextToken().trim());
                    Asset a = new Asset(id, name, color, price, weight, quantity);
                    this.add(a);
            }
            br.close();
            fr.close();
        }
        } catch (Exception e) {
            System.out.println("Something wrong2");    
        }
        
        return true;
    }
    
    public boolean saveToFile(String fileName) {
        if(this.size() == 0) {
            System.out.println("Empty list");
            return true;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Asset x : this) {
                pw.printf("%s, %s, %s, %d, %.2f, %d\n",x.assetId, x.name, x.color, x.price, x.weight, x.quantity);
                
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    
    public int searchId(String id) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).assetId.equals(id))
                return i;
        }
        return -1;
    }
    
    public void addAsset() {
        String newId, newName, newColor;
        int newPrice, newQuantity;
        double newWeight;
        do {            
            newId = MyToys.getID("Input new Asset Id: ", "Your input must be under "
                    + "the format of Axxx, x stands for a digit", "^[A|a]\\d{3}$");           
            if(searchId(newId) != -1)
                System.out.println("Id is dupplicated");
        } while (searchId(newId) != -1);
        
        newName = MyToys.getStringUpperCase("Input new name: ", "Name can't be blank!!!");
        newColor = MyToys.getStringUpperCase("Input new color: ", "Color can't be blank!!!");
        newColor = MyToys.upperLeters(newColor);
        newPrice = MyToys.getAnIntegerGreater("Input new price: ", "Price is integer and > 0", 0);
        newWeight = MyToys.getADoubleGreater("Input new weight: ", "Weight is double > 0", 0);
        newQuantity = MyToys.getAnIntegerGreater("Input new quantity: ", 
                "Quantity is integer and > 0", 0);
        
        Asset a = new Asset(newId, newName, newColor, newPrice, newWeight, newQuantity);
        this.add(a);
        System.out.println("Add " + a.assetId + " succesfully!!!");
    }
    
    public void updateAsset() {
        String id, newName, newColor;
        int newPrice, newQuantity;
        double newWeight;;
        if (this.isEmpty()) {
            System.out.println("The list is empty.Can't update @.@ ");
        } else {
            id = MyToys.getID("Input Asset id to update: ", "Your input must be under "
                    + "the format of Axxx, x stands for a digit","^[A|a]\\d{3}$");
            int pos= searchId(id);
            if (pos == -1) {
                System.out.println("The asset " + id + " doesn't exist");
            } else {
                
                newName = MyToys.getStringAndEnter("Old name: " + 
                        this.get(pos).getName() + " =))) Input new name: ");
                if(newName != null)
                        this.get(pos).setName(newName);              
                    
                newColor = MyToys.getStringAndEnter("Old color: " + 
                        this.get(pos).getColor() + " =))) Input new color: ");
                   
                if (newColor != null) {
                    newColor = MyToys.upperLeters(newColor);
                        this.get(pos).setColor(newColor);                
                    }
                newPrice = MyToys.getIntegerAndEnter("Old price: " + 
                            this.get(pos).getPrice() + " =))) Input new price: ", 
                            "Price must be greater than 0", 0, 999999999);
                if (newPrice != 0)
                        this.get(pos).setPrice(newPrice); 
                    
                    
                newWeight = MyToys.getDoubleAndEnter("Old weight: "+ 
                            this.get(pos).getWeight() + " =))) Input new weight: ", 
                            "Weight is double > 0", 0, 999999999);
                if (newWeight != 0) 
                            this.get(pos).setWeight(newWeight);

                newQuantity = MyToys.getIntegerAndEnter("Old Quantity: " + 
                            this.get(pos).getQuantity() + " =))) Input new price: ", 
                            "Price must be greater than 0", 0,99999999);
                if (newQuantity != 0)
                            this.get(pos).setQuantity(newQuantity); 
                        
                System.out.println("Update " + id +" succesfully");
            }
       }
    }
    
    public void searchByName() {
        String name = MyToys.getString("Input Asset name to search: ", "Asset name can't be blank").toUpperCase();
        int count = 0;
        AssetList vc = new AssetList();
        Asset c;
        for (int i = 0; i < this.size(); i++) {
            c = this.get(i);
            if (c.getName().toUpperCase().contains(name) == true) { 
                
                count ++;
                if(count == 1) {
                    System.out.println("The list is sorted in descending by Quantity");
                    System.out.println("-------------------------------------------------");                
                    System.out.printf("|%-4s|%-25s|%-20s|%-6s|%-6s|%-10s|\n",
                           "Id", "Name", "Color", "Price", "Weight", "Quantity");
                }
                vc.add(c);                              
            }            
        }
        vc.sortByQuantity();
        if (count == 0) 
            System.out.println("No Asset is detected ~.~");       
    }
    
   
    public void sortByQuantity() {
        Comparator a = new Comparator<Asset>() {            
            

            @Override
            public int compare(Asset o1, Asset o2) {
                return o2.getQuantity() - o1.getQuantity();
        } 
        };                
        Collections.sort(this, a);               
        for (Asset x : this) {
            x.print();
        }
    }
    
    public Asset get(String assetId){
        Asset a = null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).assetId.equals(assetId))
                return a = this.get(i);
        }
        return a;
    }
}
