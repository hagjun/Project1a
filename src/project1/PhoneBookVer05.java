 package project1;

import java.util.Scanner;

import project1.ver05.*;
import project1.ver05.MenuItem;

public class PhoneBookVer05 implements MenuItem {

      
   public static void main(String[] args) {

    

  PhoneBookManager pm = new PhoneBookManager(100);
      
      	while(true) {
         
      		pm.printMenu();
         
      		Scanner scanner = new Scanner(System.in);
      		int choice = scanner.nextInt();
         
	        switch (choice) {
	        case DATA_INPUT:
	            pm.dataInput(choice);            
	            break;
	        case DATA_SEARCH:
	            pm.dataSearch();
	            break;
	        case DATA_DELETE:
	            pm.dataDelete();
	            break;
	        case DATA_ALLSHOW:
	            pm.dataAllShow();
	            break;
	        case EXIT:
	            System.out.println("프로그램 종료");
	            return;
	        }
      	}
   	}
}