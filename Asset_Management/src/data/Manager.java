
package data;

import cong.util.newpackage.MyToys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Manager extends Person{
    
    ArrayList<Manager> ml = new ArrayList<>();
    public Manager(String employId, String name, String birthday, String role, String sex, String password) {
        super(employId, name, birthday, role, sex, password);
    }

    public Manager() {
    }

    

    public void show() {
        System.out.printf("|%7s|%-20s|%-10s|%-2s|%4s|%-10s|\n",employId, name,birthday, role, sex, password);
    }
    
    public int searchRId(String id, ArrayList<Request> r) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < r.size(); i++) {
            if(r.get(i).rId.equals(id))
                return i;
        }
        return -1;
    }
    
    public int searchBId(String id, ArrayList<Borrow> b) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < b.size(); i++) {
            if(b.get(i).bId.equals(id))
                return i;
        }
        return -1;
    }

    public void approveRequest(ArrayList<Request> a, AssetList b, ArrayList<Borrow> borrow, PeopleList pp, Person check)   
    {
        String newId, newBId;       
        do {            
            newId = MyToys.getID("Input Request Id to approve: ", "Your input must be under "
                    + "the format of Rxxx, x stands for a digit", "^[R|r]\\d{3}$");           
            if(searchRId(newId,a) == -1)
                System.out.println("Request Id is not available");
        } while (searchRId(newId,a) == -1);
        String assetId  = a.get(searchRId(newId, a)).assetId;
        if (a.get(searchRId(newId,a)).quantity <= b.get(assetId).quantity ){
            
            b.get(assetId).quantity = b.get(assetId).quantity - a.get(searchRId(newId,a)).quantity;
            
            
            do {            
                newBId = MyToys.getID("Input Borrow Id to save to Borrow List: ",
                    "Your input must be under the format of Bxxx , x stands for a digit", "^[B|b]\\d{3}$");           
                if(searchBId(newBId,borrow) != -1)
                System.out.println("Borrow Id is  available");
            } while (searchBId(newBId,borrow) != -1);
            
            Person p = pp.logins(check);
            String time = MyToys.getRealTime();           
            Borrow bo = new Borrow(newBId, assetId, a.get(searchRId(newId, a)).employId,a.get(searchRId(newId,a)).quantity, time);
            borrow.add(bo);
            a.remove(a.get(searchRId(newId,a)));
            this.saveBorrowtFile("borrow.dat", borrow);
            this.saveRequestFile("request.dat", a);
            System.out.println("Approve Request Succesfully ~~~");
        } else System.out.println("Not enough quantity");
    }
    
    public ArrayList<Borrow> loadBorrowtFile(String fileName) {
        ArrayList<Borrow> bl = new ArrayList();
        try {
            File f = new File(fileName);
            if(f.exists() == false ) return null; 
            else {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String details;                
                while ((details = br.readLine()) != null) {                   
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String bId = stk.nextToken().trim();
                    String assetId = stk.nextToken().trim();
                    String employId = stk.nextToken().trim();
                    int quantity = Integer.parseInt(stk.nextToken().trim());
                    String date = stk.nextToken().trim();
                    
                    Borrow b = new Borrow(bId, assetId, employId, quantity, date);
                    bl.add(b);
            }
            br.close();
            fr.close();
        }
        } catch (Exception e) {
            System.out.println("Something wrong4");    
        }
        return bl;
    }
    
    public boolean saveBorrowtFile(String fileName, ArrayList<Borrow> br) {
        
        if(br.isEmpty()) {
            System.out.println("Empty list");
            return true;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Borrow x : br) {
                pw.printf("%s, %s, %s, %d, %s\n",x.bId, x.assetId, x.employId, x.quantity, x.date);               
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
