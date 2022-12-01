package lab211.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;



public class VehicleList extends ArrayList<Vehicle> implements I_List {

    public VehicleList() {
    }

    @Override
    public boolean loadFromFile(String fileName) {
        try {
            File f = new File(fileName);
            if(f.exists() == false ) return false; 
            else {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String details;
                while ((details = br.readLine()) != null) {                    
                    StringTokenizer stk = new StringTokenizer(details, ",");          
                    String vehicle = stk.nextToken().trim();
                    String id = stk.nextToken().trim().toUpperCase();
                    String name = stk.nextToken().trim().toUpperCase(); 
                    String color = stk.nextToken().trim().toUpperCase();
                    int price = Integer.parseInt(stk.nextToken().trim());
                    String brand = stk.nextToken().trim();
                    if(vehicle.equalsIgnoreCase("car")) {
                        String type = stk.nextToken().trim();
                        int year = Integer.parseInt(stk.nextToken().trim());
                        Car c = new Car(id, name, color, price, brand, type, year);
                        this.add(c);
                    }
                    
                    if(vehicle.equalsIgnoreCase("motorbike")) {
                        int speed = Integer.parseInt(stk.nextToken().trim());
                        String checkLicense = stk.nextToken().trim();
                        boolean license = false; 
                        if (checkLicense.equalsIgnoreCase("true")) 
                            license = true;                        
                        if (checkLicense.equalsIgnoreCase("false")) 
                            license = false;                       
                        Motorbike m = new Motorbike(id, name, color, price, brand, speed, license);
                        this.add(m);
                    }
                }
                br.close();
                fr.close();
            }
        } catch (Exception e) {
            System.out.println("Something wrong ~.~ ");
        }
        return true;
    }

    @Override
    public boolean saveToFile(String fileName) {
        if(this.isEmpty()) {
            System.out.println("Empty list");
            return true;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                if(this.get(i) instanceof Car) {
                    pw.println("car, " + this.get(i).id + ", " + this.get(i).name + ", " + this.get(i).color + ", " + this.get(i).price + ", " + this.get(i).brand + ", " + this.get(i).getType() + ", " + this.get(i).getYear());
                }
                if(this.get(i) instanceof Motorbike) {
                    pw.println("motorbike, " + this.get(i).id + ", " + this.get(i).name + ", " + this.get(i).color + ", " + this.get(i).price + ", " + this.get(i).brand + ", " + this.get(i).getSpeed()+ ", " + this.get(i).isLicense());
                }
            }
            pw.close();
            fw.close();         
        } catch (Exception e) {
            System.out.println("Something wrong ~~~");
        }
        return true;
    }


    @Override
    public int searchId(String newId) {
        newId = newId.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).id.equals(newId))
                return i;
        }
        return -1;
    }
    
    @Override
    public void addCar() {
        String newId, newName, newColor, newBrand, newType;
        int  newPrice, newYear;
        do {            
            newId = Utils.getString("Input new Car Id: ", "Id can't be blank" );
            newId = newId.trim().toUpperCase();
            if (searchId(newId) != -1) 
                System.out.println("Id is dupplicated");           
        } while (searchId(newId) != -1);
        newName = Utils.getString("Input new Car name: ", "Name can't be blank").toUpperCase();
        newColor = Utils.getString("Input new Car color: ", "Color can't be blank").toUpperCase();
        newPrice = Utils.getAnIntegerGreater("Input new Car price: ", "Car price must be greater than 0 !!!", 0);
        newBrand = Utils.getString("Input new Car brand: ", "Brand can't be blank");
        newType = Utils.getString("Input new Car type: ", "Type can't be blank");
        newYear = Utils.getAnInteger("Input new year of manufacture: ", "Input real year please", 1800, 2022);
        Car c = new Car(newId, newName, newColor, newPrice, newBrand, newType, newYear);
        this.add(c);
        System.out.println("The Car " + c.getId() + " added succesful");
    }
    
    @Override
    public void addMotorbike() {
        String newId, newName, newColor, newBrand;
        int  newPrice, newSpeed;
        boolean newLicense;
        do {            
            newId = Utils.getString("Input new Motorbike Id: ", "Id can't be blank" );
            newId = newId.trim().toUpperCase();
            if (searchId(newId) != -1) 
                System.out.println("Id is dupplicated");            
        } while (searchId(newId) != -1);
        newName = Utils.getString("Input new Motorbike name: ", "Name can't be blank");
        newColor = Utils.getString("Input new Motorbike color: ", "Color can't be blank");
        newPrice = Utils.getAnIntegerGreater("Input new Motorbike price: ", "Motorbike price must be greater than 0 !!!", 0);
        newBrand = Utils.getString("Input new Motorbike brand: ", "Brand can't be blank");
        newSpeed = Utils.getAnIntegerGreater("Input new Motorbike speed: ", "Speed must be greater than 0", 0);
        newLicense = Utils.confirmYesNo("Is this Motorbike require license (Y/N): ");
        Motorbike m = new Motorbike(newId, newName, newColor, newPrice, newBrand, newSpeed, newLicense);
        this.add(m);
        System.out.println("The Motorbike " + m.getId() + " added succesful");
    }
    
    @Override
    public void updateById() {
        String id, newName, newColor, newBrand, newType;
        int newPrice, newYear, newSpeed;
        boolean newLicense;
        Scanner sc = new Scanner(System.in);
        if (this.isEmpty()) {
            System.out.println("The list is empty.Can't update @.@ ");
        } else {
            id = Utils.getString("Input Vehicle id to update: ", "Id can't be blank").trim().toUpperCase();
            if (searchId(id) == -1) {
                System.out.println("Vehicle doesn't exist");
            } else {
                if (this.get(searchId(id)) instanceof Car) {                   
                    newName = Utils.getStringAndEnter("Old name: " + this.get(searchId(id)).getName() + "   =)))   Input new name: ");
                    if(newName != null)
                        this.get(searchId(id)).setName(newName);              
                    
                    newColor = Utils.getStringAndEnter("Old color: " + this.get(searchId(id)).getColor() + "   =)))   Input new color: ");
                    if (newColor != null) 
                        this.get(searchId(id)).setColor(newColor);                
                    
                    newPrice = Utils.getIntegerAndEnter("Old price: " + this.get(searchId(id)).getPrice() + "   =)))   Input new price: ", "Price must be greater than 0", 0, 9999999);
                    if (newPrice != 0)
                        this.get(searchId(id)).setPrice(newPrice);                    
                    
                    newBrand = Utils.getStringAndEnter("Old brand: " + this.get(searchId(id)).getBrand() + "   =)))   Input new brand: ");
                    if (newBrand != null) 
                        this.get(searchId(id)).setBrand(newBrand);                   
                    
                    newType = Utils.getStringAndEnter("Old Type: " + this.get(searchId(id)).getType() + "   =)))   Input new type: ");
                    if (newType != null)                     
                        this.get(searchId(id)).setType(newType);
                         
                    newYear= Utils.getIntegerAndEnter("Old year: " + this.get(searchId(id)).getYear() + "   =)))   Input new year: ", "Real year please", 1800, 2022);
                    if (newYear != 0)                     
                        this.get(searchId(id)).setYear(newYear);    
                
                }
                // Update Motorbike
                if (this.get(searchId(id)) instanceof Motorbike) {                   
                    newName = Utils.getStringAndEnter("Old name: " + this.get(searchId(id)).getName() + "   =)))   Input new name: ");
                    if(newName != null)
                        this.get(searchId(id)).setName(newName);              
                    
                    newColor = Utils.getStringAndEnter("Old color: " + this.get(searchId(id)).getColor() + "   =)))   Input new color: ");
                    if (newColor != null) 
                        this.get(searchId(id)).setColor(newColor);                
                    
                    newPrice = Utils.getIntegerAndEnter("Old price: " + this.get(searchId(id)).getPrice() + "   =)))   Input new price: ", "Price must be greater than 0", 0, 9999999);
                    if (newPrice != 0)
                        this.get(searchId(id)).setPrice(newPrice);                    
                    
                    newBrand = Utils.getStringAndEnter("Old brand: " + this.get(searchId(id)).getBrand() + "   =)))   Input new brand: ");
                    if (newBrand != null) 
                        this.get(searchId(id)).setBrand(newBrand);                   
                    
                    
                         
                    newSpeed = Utils.getIntegerAndEnter("Old speed: " + this.get(searchId(id)).getSpeed() + "   =)))   Input new speed: ", "Real year please", 0, 99999);
                    if (newSpeed != 0)                     
                        this.get(searchId(id)).setSpeed(newSpeed); 
                    
                    newLicense = Utils.confirmYesNo("Old Required Liscense: " + this.get(searchId(id)).isLicense() + "   =)))   New Required Liscense(Y/N): ");
                        this.get(searchId(id)).setLicense(newLicense);
            }
        }
        
    }
}
    
    @Override
    public void deleteById() {
        if (this.isEmpty())
            System.out.println("The list is empty.Can't removed @.@ ");
        else {                    
            String id = Utils.getString("Input Vehicle id to removed: ", "Id can't be blank").trim().toUpperCase();
            if(searchId(id) == -1) {                           
                System.out.println("Id doesn't exist");
                System.out.println("Delete fail ~~~");
            }
            else {
                this.remove(searchId(id));
                System.out.println("The vehicle " + id + " has been removed");
                System.out.println("Delete succesfull");
            }       
        }
        
    }
    
    @Override
    public void searchById() {
        String id;
        if (this.isEmpty()) {
            System.out.println("The list is empty.Can't search @.@ ");
        } else {
            id = Utils.getString("Input id to search a vehicle: ", "Id can't be blank");
            id = id.trim().toUpperCase();
            if (searchId(id) != -1) {
                System.out.println("The Vehicle you want to fine Here =))");
                
                this.get(searchId(id)).printList();
            } else 
                System.out.println("Can't find the Vehicle " + id);           
        }
    }
    
    @Override
    public void searchByName() {
        String name = Utils.getString("Input Vehicle name to search: ", "Vehicle name can't be blank").toUpperCase();
        int count = 0;
        VehicleList vc = new VehicleList();
        Vehicle c;
        for (int i = 0; i < this.size(); i++) {
            c = this.get(i);
            if (c.getName().toUpperCase().contains(name) == true) {         
                count ++;
                if(count == 1) {
                    System.out.println("The list is sorted in descending by brand");
                    System.out.println("-------------------------------------------------");                
                    System.out.printf("|%-7s|%-15s|%-15s|%-12s|%-20s|%-10s%10s|%-7s%7s|\n",
                           "Id", "Name", "Color", "Price", "Brand", "Type", "Speed", "Year","License");
                }
                vc.add(c);                              
            }            
        }
        vc.sortByBrand();
        if (count == 0) 
            System.out.println("No Vehicle is detected ~.~");       
    }
    
    @Override
    public void sortByBrand() {
        Comparator a = new Comparator<Vehicle>() {            
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getBrand().compareToIgnoreCase(v2.getBrand());                              
            }
        };        
        Collections.sort(this, a);               
        for (Vehicle x : this) {
            x.printList();
        }
    }
    
    
    @Override
    public void printList() {
        if (this.isEmpty())
            System.out.println("The list is empty.Can't print list @.@ ");
        else {
            System.out.println("The list here: ");
            System.out.printf("|%-7s|%-15s|%-15s|%-12s|%-20s|%-10s%10s|%-7s%7s|\n",
                           "Id", "Name", "Color", "Price", "Brand", "Type", "Speed", "Year","License");
            for (Vehicle x : this) {
                 x.printList();
            }
        }
    }    
    
    
    @Override
    public void showAllByDescendingByPrice() {
        VehicleList c = new VehicleList();
        for (int i = 0; i < this.size(); i++) {
            c.add(this.get(i));
        }    
        if (c.isEmpty())
            System.out.println("The list is empty.Can't print list @.@ ");
        else {
            for (int i = 0; i < (c.size() - 1); i++) 
                for (int j = i+1; j < c.size(); j++) 
                    if(c.get(i).getPrice() <= c.get(j).getPrice()){
                        Vehicle p = c.get(i);
                        c.set(i, c.get(j));
                        c.set(j, p);
                    }                        
            System.out.println("The Vehicle list with Price in ascending order: ");
            System.out.printf("|%-7s|%-15s|%-15s|%-12s|%-20s|%-10s%10s|%-7s%7s|\n",
                           "Id", "Name", "Color", "Price", "Brand", "Type", "Speed", "Year","License");
            for (Vehicle x : c) {
                x.printList();
            }
            
        }
        
    }
}
   




 
