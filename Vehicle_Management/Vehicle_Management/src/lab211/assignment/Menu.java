package lab211.assignment;


import java.util.ArrayList;

public class Menu extends ArrayList<String> implements I_Menu {
    
    private String menuTitle;
    
    
    public Menu() {
        super();
    }
    
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    // must implement all abstract method of I_Menu interface

    @Override
    public void addItem(String s) {        
        this.add(s);
    }

    @Override
    public void showMenu() {
        if (this.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println("Welcome to " + menuTitle);
        for (String x : this)
            System.out.println(x);
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        boolean result= false;
        result= Utils.confirmYesNo(welcome);
        return result;
    }

//    @Override
//    public int getChoice() {
//        return Utils.getInt("Input your choice:", 1, this.size());
//    }
    
    @Override
    public int getChoice() {
        int maxOption = this.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return Utils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        
    }

}
