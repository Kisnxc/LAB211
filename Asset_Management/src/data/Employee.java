package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Employee extends Person{

    public Employee(String employId, String name, String birthday, String role, String sex, String passwword) {
        super(employId, name, birthday, role, sex, passwword);
    }

    public Employee() {
    }
    
    public void show() {
        System.out.printf("|%7s|%-20s|%-10s|%-2s|%4s|%-10s|\n",employId, name,birthday, role, sex, password);
    }
    
    
}