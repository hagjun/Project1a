 package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.AutoSaveT;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08 extends MenuSelectException{

      
   public static void main(String[] args) throws MenuSelectException {

    

	PhoneBookManager pm = new PhoneBookManager(100);
	AutoSaveT t = new AutoSaveT(pm);
	t.setDaemon(true);
	  
	  while(true) {
		  
		pm.printMenu();
		  
		Scanner scanner = new Scanner(System.in);
	  
			try {
				  
				int choice = scanner.nextInt();
					
				if(choice<1 || choice>6) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
					
				}
				
				
				switch (choice) {
				case MenuItem.DATA_INPUT:
					pm.dataInput(choice);            
					break;
				case MenuItem.DATA_SEARCH:
					pm.dataSearch();
					break;
				case MenuItem.DATA_DELETE:
					pm.dataDelete();
					break;
				case MenuItem.DATA_ALLSHOW:
					pm.dataAllShow();
					break;
				case MenuItem.AUTOOPTION:
					if(t.getState()==Thread.State.TERMINATED) {
						t= new AutoSaveT(pm);
					}
					pm.autoOption(t);
					break;
					  
				case MenuItem.EXIT:
					pm.exitSave();
					System.out.println("프로그램 종료");
					return;
					
				}
					  
			}
				  
			catch (InputMismatchException e) {
				System.err.println("숫자만 입력하세요");
				 
			}
			catch (Exception e) {
				System.err.println("1~6까지만입력해주세용");
				
			} 		
		}
   	}
}
