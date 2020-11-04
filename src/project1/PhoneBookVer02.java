package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		
		PhoneInfo ph = new PhoneInfo();
		Scanner sc = new Scanner(System.in);
		 
		int cnt =0;
		String b;
		
		Scanner keyboard = new Scanner(System.in);
		 
		while(true) {
		      
		    System.out.println("선택하세요...");
		    System.out.println("1.데이터 입력");
		    System.out.println("2.프로그램종료");
		    System.out.print("선택:");
		    cnt =keyboard.nextInt();
		    if(cnt==1) {
		    	ph.dataput();
		    	ph.showPhoneInfo();
		    }
		    else {

		    	System.out.println("프로그램을 종료합니다.");
		    	break;
		    }
		}
	}
}
