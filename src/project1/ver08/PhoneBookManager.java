package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager extends Thread{
   
   HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
   PhoneInfo phoneInfo = new PhoneInfo();
   public int numOfpInfo;//한명 정보 추가시 1씩 증가
   
   
   //생성자-인자로 전달되는 num크기의 객체배열 생성
   public PhoneBookManager (int num) {
//      pInfo = new PhoneInfo[num];      
      numOfpInfo = 0;
      try {
          ObjectInputStream in =
                new ObjectInputStream(
                   new FileInputStream("src/project1/ver08/PhoneBook.obj")
                );
          
             set = (HashSet<PhoneInfo>)in.readObject();
             in.close();
             
       } catch (Exception e) {
          System.out.println("복원시 예외발생");
       }
    
   	}   
      
      
   //데이터입력
   public void dataInput(int choice)  {

      Scanner sc = new Scanner(System.in);
      String iName , iphoneN, iCompany, major;
      int grade;
   
      System.out.println("데이터 입력을 시작합니다!");
      System.out.println("1.일반, 2.동창, 3.회사");
      System.out.print("선택>>");
      
      try {
      
         int choice1 = sc.nextInt();
         sc.nextLine();
         
         if(choice1==SubMenuItem.NORMAL) {
            System.out.print("이름:");iName = sc.nextLine();
            System.out.print("전화번호:");iphoneN = sc.next();
            PhoneInfo pi = new PhoneInfo(iName,iphoneN);
//            PhoneInfo pInfo = new PhoneInfo(iName , iphoneN);
            boolean NORMAL = set.add(pi);
            
//               PhoneInfos.add(ph1);
             if(!(NORMAL)) {
                 
            	   System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
                     Scanner scan = new Scanner(System.in);
                     String str = scan.nextLine();
                     
                     if(str.equalsIgnoreCase("y")) {
                           if(!(NORMAL)) {
                              set.remove(pi);
                              set.add(pi);
                              //break;
                           	}
                        
                        set.add(new PhoneInfo(iName,iphoneN));
                        System.out.println("덮어쓰기가 완료되었습니다.");
                    }
                     if(str.equalsIgnoreCase("n")) {
                        System.out.println("덮어쓰기에 실패했습니다.");
                    }
            }
           // System.out.println("성공asdfasdfasdf");
            //
         }      
         else if(choice1==SubMenuItem.SCHOOL_FRIEND) {
            System.out.print("이름:");iName = sc.nextLine();
            System.out.print("전화번호:");iphoneN = sc.nextLine();
            System.out.print("전공:");major = sc.nextLine();
            System.out.print("학년:");grade = sc.nextInt();
            
            PhoneSchoolInfo pi2 = new PhoneSchoolInfo(iName, iphoneN, major, grade);
            boolean SCHOOL_FRIEND = set.add(pi2);
            
//               PhoneInfos.add(ph2);
               if(!(SCHOOL_FRIEND)) {
                     System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
                     Scanner scan = new Scanner(System.in);
                     String str = scan.nextLine();
                     if(str.equalsIgnoreCase("y")) {
    
                           if(!(SCHOOL_FRIEND)) {
                              set.remove(pi2);
                           }
                          
                        set.add(new PhoneSchoolInfo(iName, iphoneN, major, grade));
                        System.out.println("덮어쓰기가 완료되었습니다.");
                     }
                     if(str.equalsIgnoreCase("n")) {
                        System.out.println("덮어쓰기에 실패했습니다.");
                     }
                  }
            
            
         }
         else if(choice1==SubMenuItem.COM_FRIEND) {
            System.out.print("이름:");iName = sc.nextLine();
            System.out.print("전화번호:");iphoneN = sc.nextLine();
            System.out.print("회사:");iCompany=sc.nextLine();
            
            PhoneCompanyInfo pi = new PhoneCompanyInfo(iName, iphoneN, iCompany);
            boolean COM_FRIEND = set.add(pi);
//               PhoneInfos.add(ph3);
               if(!(COM_FRIEND)) {
                     System.out.print("중복된 데이터가 있습니다. 덮어쓸까요? Y(y) / N(n)");
                     Scanner scan = new Scanner(System.in);
                     String str = scan.nextLine();
                     if(str.equalsIgnoreCase("y")) {
                       
                           if(pi.name.equals(iName)) {
                              set.remove(pi);
                            //  break;
                           }
                        
                        set.add(new PhoneCompanyInfo(iName, iphoneN, iCompany));
                        System.out.println("덮어쓰기가 완료되었습니다.");
                     }
                     if(str.equalsIgnoreCase("n")) {
                        System.out.println("덮어쓰기에 실패했습니다.");
                     }
                  }      
            set.add(new PhoneCompanyInfo(iName, iphoneN, iCompany));
            
        }
         else {
            System.out.println("1,2,3 중 한개를 입력해주세요");
            
        }
         
    }
   
      catch (InputMismatchException e) {
         System.out.println("숫자만 입력 가능합니다.");
         e.printStackTrace();
      	}
   	}


   //데이터 검색
   public void dataSearch() {
      boolean isFind = false;//검색한 정보 확인을 위한 변수
      Scanner sc = new Scanner(System.in);
      System.out.println("데이터 검색을 시작합니다! 검색할 이름을 입력하세요.");      
      String searchN = sc.nextLine();
      System.out.println("검색할 이름:"+searchN);
      
      
      
      try {
         for(PhoneInfo phoneInfo:set) {
            //System.out.println("검색할 이름:"+searchN);
            
            if(searchN.equals(phoneInfo.name)) {
               phoneInfo.showPhoneInfo();
               System.out.println();
               System.out.println("데이터 검색이 완료되었습니다.");
               isFind = true;//찾는 정보가 있다면 true로변경
            }
            else if(isFind==false)
               System.out.println("일치하는 정보가 없습니다.");
         	}      
      	}//end of searchInfo
   
 
   catch (NullPointerException e) {
      System.out.println("검색결과가 없습니다.");
      e.printStackTrace();
      }//end of search
   }
   //데이터삭제
   public void dataDelete() {
      
	  Scanner sc = new Scanner(System.in);
      System.out.println("데이터 삭제를 시작합니다!");
      System.out.print("이름:");
      String name = sc.nextLine();
      
      //삭제 불가능할시 알림을 위해 설정
      boolean deleteFlag=false;
      
      Iterator<PhoneInfo> itr = set.iterator();
      while(itr.hasNext()) {
    	  PhoneInfo phoneInfo = itr.next();
         
         if(name.equals(phoneInfo.name)) {
            
        	set.remove(phoneInfo);
            System.out.println("데이터 삭제가 완료되었습니다.");
            deleteFlag = true;
            
         }
      }
      //검색 불가능할시
      if(deleteFlag==false) {
         System.out.println("삭제된 데이터가 없습니다.");
         
      }
      
   }//end of delete
   
   public void autoOption(AutoSaveT t) {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("저장옵션을 선택하세요.");
	   System.out.println("1.자동저장On 2.자동저장Off");
	   System.out.println("선택:");
	   int pn = sc.nextInt();
	   sc.nextLine();
   	
   
	   switch (pn) {
	   case 1: 
	   		if(t.getState()==Thread.State.NEW) {
	   			System.out.println("자동저장중입니다");
	   			t.start();//시작
	   		}
	   		else {
	   			System.out.println("이미 자동저장이 실행중입니다.");
	   		}
	   		break;
	   	case 2:
	   		System.out.println("자동저장OFF");
	   		t.interrupt();//중지
	   		
	   		break;
	   }
   
   }
   
   
   
   
   public void write() {
	      
	      try {
	         Iterator<PhoneInfo> ir = set.iterator();
	         PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
	         while(ir.hasNext()) {
	            PhoneInfo pi = ir.next();
	            if(pi instanceof PhoneSchoolInfo) {
	               out.printf("이름:%s, 전화번호:%s, 전공:%s, 학년:%d", pi.name, pi.phoneNumber, ((PhoneSchoolInfo) pi).major, ((PhoneSchoolInfo) pi).grade );
	            }
	            if(pi instanceof PhoneCompanyInfo) {
	               out.printf("이름:%s, 전화번호:%s, 회사:%s", pi.name, pi.phoneNumber, ((PhoneCompanyInfo) pi).company);
	            }
	            if(pi instanceof PhoneInfo) {
	               out.printf("이름:%s, 전화번호:%s", pi.name, pi.phoneNumber);
	            }
	         }
	         out.close();
	         
	      } catch (Exception e) {
	         //e.printStackTrace();
	      }

   }
      public void exitRead() {
          
//          try {
//             ObjectInputStream in =
//                   new ObjectInputStream(
//                      new FileInputStream("src/project1/ver08/PhoneBook.obj")
//                   );
//             
//                set = (HashSet<PhoneInfo>)in.readObject();
//                in.close();
//                
//          } catch (Exception e) {
//             System.out.println("복원시 예외발생");
//          }
//       
       }
       
       
       
       //친구정보를 파일로 저장하기
       public void exitSave(){
          
          try {
             
             //파일저장을 위한 스트림 생성
             ObjectOutputStream out =   
                   new ObjectOutputStream(
                         new FileOutputStream("src/project1/ver08/PhoneBook.obj")
                         );
             
             out.writeObject(set);
             out.close();
          }
          catch (Exception e) {
             System.out.println("파일저장시 예외발생");
          }   
       }

      
   public void dataAllShow() {
      System.out.println("==주소록을 출력함==");
	   
	   for(PhoneInfo phoneInfo:set) {
         
         phoneInfo.showPhoneInfo();
      }
   }//데이터 전체출력
   
   public static void printMenu() {
      
      System.out.println("=========메뉴를선택하세요==================");
      System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료 ");
      System.out.println("======================================");
    
      System.out.print("메뉴선택:");
      
   }
   
   
}//end of handler
