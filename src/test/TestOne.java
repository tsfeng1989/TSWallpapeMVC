package test;

import java.util.UUID;

public class TestOne {
	
    public static String getUUID() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // È¥µô"-"·ûºÅ  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        return temp;  
    }   
  
    public static void main(String[] args) {  
    	System.out.println(getUUID());
    }  
	
}
