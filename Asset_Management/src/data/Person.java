
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Person {
    protected String employId;
    protected String name;
    protected String birthday;               
    protected String role;
    protected String sex;
    protected String password;

    public Person(String employId, String name, String birthday, String role, String sex, String password) {
        this.employId = employId;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public Person() {
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
    public void show() {
        
    }
    
    public ArrayList<Request> loadRequestFile(String fileName) {
        ArrayList<Request> r = new ArrayList();
        try {
            File f = new File(fileName);
            if(f.exists() == false ) return null; 
            else {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String details;                
                while ((details = br.readLine()) != null) {                   
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String rId = stk.nextToken().trim();
                    String assetId = stk.nextToken().trim();
                    String employId = stk.nextToken().trim();
                    int quantity = Integer.parseInt(stk.nextToken().trim());
                    String date = stk.nextToken().trim();
                    
                    Request re = new Request(rId, assetId, employId, quantity, date);
                    r.add(re);
            }
            br.close();
            fr.close();
        }
        } catch (Exception e) {
            System.out.println("Something wrong3");    
        }
        return r;
    }
    
    
    
    public boolean saveRequestFile(String fileName, ArrayList<Request> ar) {
        
        if(ar.isEmpty()) {
            System.out.println("Empty list");
            return true;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Request x : ar) {
                pw.printf("%s, %s, %s, %d, %s\n",x.rId, x.assetId, x.employId, x.quantity, x.date);
                
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    
   
}
