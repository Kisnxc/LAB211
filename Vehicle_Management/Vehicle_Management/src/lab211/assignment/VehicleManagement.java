package lab211.assignment;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.11.31
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleManagement {

    public static void main(String args[]) {
    
        I_Menu menu = new Menu("Vehicle Management");
        
        menu.addItem("1- Add new vehicle");
        menu.addItem("2- Update vehicle by ID");
        menu.addItem("3- Delete vehicle by ID");
        menu.addItem("4- Search vehicle");
        menu.addItem("5- Show vehicle list");
        menu.addItem("6- Store data to file");
        menu.addItem("7- Quit");
        
        int choice, choice1, choice4, choice5;
        boolean cont = false, cont1 = false, cont2 = false, cont3 = false, cont4 = false, cont5 = false;
        
        VehicleList vc = new VehicleList();       
        vc.loadFromFile("Vehicles.txt");
        
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    I_Menu menu1 = new Menu("Add Vehicle");
                    menu1.addItem("1- Add new Car");
                    menu1.addItem("2- Add new Motorbike");
                    
                    do {
                        menu1.showMenu();
                        choice1 = menu1.getChoice();
                        switch  (choice1) {
                            case 1:
                                vc.addCar();
                                break;
                            case 2:
                                vc.addMotorbike();
                                break;
                            
                        }
                        cont1 = menu1.confirmYesNo("Do you want to continuous create new vehicle?(Y/N): ");
                    } while (cont1);
                      
                    break;
                case 2:
                    do {                        
                        vc.updateById();
                        cont2 = menu.confirmYesNo("Do you want to continuous update vehicle?(Y/N): ");
                    } while (cont2);
                    break;
                case 3:
                    do {
                        
                        vc.deleteById();
                        cont3 = menu.confirmYesNo("Do you want to continuous delete vehicle?(Y/N): ");
                    } while (cont3);
                    break;
                case 4:
                    I_Menu menu4 = new Menu("Search Vehicle");
                    menu4.addItem("1- Search by name");
                    menu4.addItem("2- Search by id");                   
                    do {
                        menu4.showMenu();
                        choice4 = menu4.getChoice();
                        switch  (choice4) {
                            case 1:
                                vc.searchByName();
                                break;
                            case 2:
                                vc.searchById();
                                break;
                            
                        }
                        cont4 = menu4.confirmYesNo("Do you want to continuous search vehicle?(Y/N): ");
                    } while (cont4);
                    break;
                case 5:
                    I_Menu menu5 = new Menu("Show Vehicle list");
                    menu5.addItem("1- Show all Vehicle");
                    menu5.addItem("2- Show all Vehicle descending by price");                    
                    do {
                        menu5.showMenu();
                        choice5 = menu5.getChoice();
                        switch  (choice5) {
                            case 1:
                                vc.printList();
                                break;
                            case 2:
                                vc.showAllByDescendingByPrice();
                                break;                           
                        }
                        cont5 = menu5.confirmYesNo("Do you want to continuous Show vehicle list?(Y/N): ");
                    } while (cont5);
                    break;                   
                case 6:
                    vc.saveToFile("Vehicles.txt");
                    System.out.println("Store data to file succesfully ^.^");
                    break;
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
                    if (cont)   System.out.println("Good bye. See you again ^.^");
                    break;
            }
        } while (!cont);
    }
}
