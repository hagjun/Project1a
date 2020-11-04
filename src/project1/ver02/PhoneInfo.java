package project1.ver02;

import java.util.Scanner;

public class PhoneInfo {


    String name;
    String phoneNumber;
    String birthday;
      

    public PhoneInfo(String name, String phoneNumber, String birthday) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }


    public PhoneInfo() {
    	
    	this.name = name;
    	this.phoneNumber = phoneNumber;
    	this.birthday = birthday;
    }

    public void dataput() {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("이름:");
    	name = keyboard.nextLine();
    	System.out.println("전화번호:");
    	phoneNumber = keyboard.nextLine();
    	
    	System.out.println("생년월일:");
    	birthday = keyboard.nextLine();
    	  
    }
    public void showPhoneInfo() {
        
    	System.out.println("입력된 정보 출력...");
        System.out.println("name:"+name);
        System.out.println("phone:"+phoneNumber);
        System.out.println("birth:"+birthday);
         
         
         
    }
}