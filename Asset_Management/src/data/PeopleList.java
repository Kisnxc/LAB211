
package data;

import cong.util.newpackage.MyToys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class PeopleList extends ArrayList<Person> {

    public PeopleList() {
    }
      
   
    public boolean loadFileEmployee(String fileName) {
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
                    String birthday = stk.nextToken().trim();
                    String role = stk.nextToken().trim();
                    String sex = stk.nextToken().trim();
                    String password = stk.nextToken().trim();
                    Person p = null;
                    if (role.equalsIgnoreCase("MA")) {
                        p = new Manager(id, name, birthday, role, sex, password);
                    } 
                    if (role.equalsIgnoreCase("EM")) {
                        p = new Employee(id, name, birthday, role, sex, password);
                    }
                    this.add(p);
            }
            br.close();
            fr.close();
        }
        } catch (Exception e) {
            System.out.println("Something wrong1");    
        }
        return true;
    }     

    public int searchId(String id) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getEmployId().equals(id))
                return i;
        }
        return -1;
    }
    
    public boolean checkPassword(String id, String password) {
        password = password.trim();
        if (this.get(searchId(id)).getPassword().equalsIgnoreCase(password))
            return true;
        return false;
    }
    
    
    
    public Person logins(Person check) {
        
        while ( check == null ){
            String id = MyToys.getID("Input your Id to login: ", "Your input must be under "
                        + "the format of Exxxxxx, x stands for a digit", "^[E|e]\\d{6}$");
            String password = MyToys.getString("Input your password: ", "Password can't be blank");
            if (searchId(id) != -1  && checkPassword(id,password) && this.get(searchId(id)) instanceof Manager) {
                System.out.println("Login succesfully");
                check = this.get(searchId(id));
            } else {
                System.out.println("Id or password invalid");
                check = null;
            }   
        }
        return check;
    }
    
    
    
}
