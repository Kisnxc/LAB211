
package data;

import cong.util.newpackage.Menu;
import java.util.ArrayList;

public class ManagerProgram {
    public static void main(String[] args) {
        Menu menu = new Menu("Manager Program");
        menu.addNewOption("1. Login");
        menu.addNewOption("2. Search asset by name");
        menu.addNewOption("3. Create new asset");
        menu.addNewOption("4. Updating asset's information");
        menu.addNewOption("5. Approve the request of employee");
        menu.addNewOption("6. Show list of borrow asset");
        menu.addNewOption("7. Quit");
        
        
        PeopleList pl = new PeopleList();   
        pl.loadFileEmployee("employee.dat");
        
        Manager e = new Manager();
        
        AssetList al = new AssetList();
        al.loadFile("asset.dat");
        
        ArrayList<Request> rl = new ArrayList<>();
        rl =  e.loadRequestFile("request.dat");
        
        ArrayList<Borrow> bl = new ArrayList<>();
        bl = e.loadBorrowtFile("borrow.dat");
        
        
        boolean cont = false;   
        Person check = null;
        int choice;
        do {  
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    if (check == null)
                        check = pl.logins(check); 
                    else
                        System.out.println("You are already logged in");
                    
                    break;
                case 2:
                    al.searchByName();
                    break;
                case 3:
                    boolean cont1;
                    if (check != null){              
                        do {
                            al.addAsset();
                            al.saveToFile("asset.dat");
                            cont1 = menu.confirmYesNo("Do you want to continuous create new Asset?(Y/N): ");
                        } while (cont1);
                    } else {
                        System.out.println("You must login to use this function");
                        check = pl.logins(check);
                        do {
                            al.addAsset();    
                            al.saveToFile("asset.dat");
                            cont1 = menu.confirmYesNo("Do you want to continuous create new Asset?(Y/N): ");
                        } while (cont1);
                    }
                    break;
                case 4:    
                    
                    if (check != null){
                        al.updateAsset();      
                        al.saveToFile("asset.dat");
                    } else {
                        System.out.println("You must login to use this function");
                        check = pl.logins(check);
                        al.updateAsset();    
                        al.saveToFile("asset.dat");
                    }
                    break;
                case 5:
                    if (check != null){
                        System.out.println("Request List: ");
                        for (Request request : rl) {
                            request.show();
                        }
                        e.approveRequest(rl, al,bl,pl,check);                               
                    } else {
                        System.out.println("You must login to use this function");
                        check = pl.logins(check);
                        System.out.println("Request List: ");
                        for (Request request : rl) {
                            request.show();
                        }
                        e.approveRequest(rl, al,bl,pl,check);                                                                      
                    }
                    break;
                case 6:                                                       
                    if (check != null){                        
                        System.out.println("Borrow List:");
                        System.out.printf("|%-4s|%8s|%9s|%8s|%-20s|\n", "BId", "Asset Id", "Employ Id", "Quantity", "Date");
                        for (Borrow borrow : bl) {
                            borrow.show();
                        }                                 
                    } else {
                        System.out.println("You must login to use this function");
                        check = pl.logins(check);                        
                        System.out.println("Borrow List:");
                        System.out.printf("|%-4s|%8s|%9s|%8s|%-20s|\n", "BId", "Asset Id", "Employ Id", "Quantity", "Date");
                        for (Borrow borrow : bl) {
                            borrow.show();
                        }                                               
                    }
                    break;                 
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
                    if (cont)   System.out.println("Good bye. See you again ^.^");
                    break;
            }
            
        } while (!cont);
    }
}
