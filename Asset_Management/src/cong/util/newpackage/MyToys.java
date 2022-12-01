
package cong.util.newpackage;

import java.util.Calendar;
import java.util.Scanner;


public class MyToys {
private static Scanner sc = new Scanner(System.in);


    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {  
                check = false;
            }
        } while (check);
        return result;
    }

    public static String updateString(String welcome, String oldData) {
        String result = oldData;       
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {              
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int updateInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
               
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm;
        do {
        confirm = MyToys.getString(welcome).trim();
        if ("Y".equalsIgnoreCase(confirm)) 
            result = true;
        
        if ("N".equalsIgnoreCase(confirm)) 
            result = false;
        
        } while (confirm.equalsIgnoreCase("Y") == false && confirm.equalsIgnoreCase("N") == false);
        return result;
    }
    
//    public static boolean confirmYesNo(String welcome) {
//        boolean result = false;
//        String confirm = Utils.getString(welcome);
//        if ("Y".equalsIgnoreCase(confirm)) {
//            result = true;
//        }
//        return result;
//    }
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnIntegerGreater(String inputMsg, String errorMsg, int lowerBound) {
        int n;
        
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n > lowerBound) {
                } else {                
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnIntegerLower(String inputMsg, String errorMsg, int greaterBound) {
        int n;
        
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= greaterBound) {
                } else {                
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getADoubleLower(String inputMsg, String errorMsg, double greaterBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= greaterBound) {
                } else {                
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getADoubleGreater(String inputMsg, String errorMsg, double lowerBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n > lowerBound) {
                } else {                
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
        
    
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return id;            
        }
    }
    
    
    public static String getString(String inputMsg, String errorMsg) {
        String id;        
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().replaceAll(" +", " ");            
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    
    public static boolean containsDigit(String s) {
    boolean containsDigit = false;

    if (s != null && !s.isEmpty()) {
        for (char c : s.toCharArray()) {
            if (containsDigit = Character.isDigit(c)) {
                break;
            }
        }
    }

    return containsDigit;
    }
    
    public static int getIntegerAndEnter(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        String s;
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                s = sc.nextLine();
                if (s.equalsIgnoreCase("") == false){
                    n = Integer.parseInt(s);
                    if (n < lowerBound || n > upperBound)
                        throw new Exception();                
                    return n;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }      
    }
    
    public static double getDoubleAndEnter(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        String s;
        double n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                s = sc.nextLine();
                if (s.equalsIgnoreCase("") == false){
                    n = Double.parseDouble(s);
                    if (n < lowerBound || n > upperBound)
                        throw new Exception();                
                    return n;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }      
    }
    
    public static String getStringAndEnter(String inputMsg) {
        String st;        
        
            System.out.print(inputMsg);
            st = sc.nextLine().trim().replaceAll(" +", " ");            
            if (st.equalsIgnoreCase("") == false)
                return st;
            else 
                return null;
        
    }
    
    public static String getStringUpperCase(String inputMsg, String errorMsg) {
        String id;        
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().replaceAll(" +", " ");  
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else {
                // chuỗi firstLetter chứa chữ cái đầu tiên của  name
                String firstLetter = id.substring(0, 1).toUpperCase();
                // chuỗi remainingLetters chứa phần còn lại của name
                String remainingLetters = id.substring(1, id.length());
            
                id = firstLetter + remainingLetters;
                return id;
            }
            
            
            
            
        }
    }
    
    public static String upperLeters(String message) {
        char[] charArray = message.toCharArray();
        boolean foundSpace = true;
        //sử dụng vòng lặp for để duyệt các phần tử trong charArray
        for(int i = 0; i < charArray.length; i++) {
          // nếu phần tử trong mảng là một chữ cái
          if(Character.isLetter(charArray[i])) {
            // kiểm tra khoảng trắng có trước chữ cái
            if(foundSpace) {
              //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
              charArray[i] = Character.toUpperCase(charArray[i]);
              foundSpace = false;
            }
          }
          else {
            foundSpace = true;
          }
        }
        // chuyển đổi mảng char thành string
        message = String.valueOf(charArray);
        return message;
    }
    public static void main(String[] args) {
        String a ="a   b   c";
        a = MyToys.upperLeters(a);
        System.out.println(a);
    }
    
    public static String getRealTime() {
        Calendar c = Calendar.getInstance();
        
	int year = c.get(Calendar.YEAR);
        String y = String.valueOf(year);
		
	int month = c.get(Calendar.MONTH);
        String mo = String.valueOf(month);
        
	int day = c.get(Calendar.DAY_OF_MONTH);
        String d = String.valueOf(day);
	int hour = c.get(Calendar.HOUR_OF_DAY);
        String h = String.valueOf(hour);
	int minute = c.get(Calendar.MINUTE);
        String mi = String.valueOf(minute);
	int second = c.get(Calendar.SECOND);
	String s = String.valueOf(second);
        
        String time = d + "-" + mo + "-" + y + " " + h + ":" + mi + ":" + s;            
        return time;
    }
}
