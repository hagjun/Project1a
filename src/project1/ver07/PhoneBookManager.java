package project1.ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{
   
   HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
   public int numOfpInfo;//한명 정보 추가시 1씩 증가
   
   
   //생성자-인자로 전달되는 num크기의 객체배열 생성
   public PhoneBookManager (int num) {
//      pInfo = new PhoneInfo[num];      
      numOfpInfo = 0;
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
         
        if(choice1==NORMAL) {
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
         else if(choice1==SCHOOL_FRIEND) {
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
         else if(choice1==COM_FRIEND) {
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
            System.out.println("성공");
            
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
            if(isFind==false)
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
   public void dataAllShow() {
      System.out.println("==주소록을 출력함==");
	   
	   for(PhoneInfo phoneInfo:set) {
         
        phoneInfo.showPhoneInfo();
    }
}//데이터 전체출력
   
   public static void printMenu() {
      
      System.out.println("메뉴를 선택하세요!");
      System.out.println("1.데이터 입력");
      System.out.println("2.데이터 검색");
      System.out.println("3.데이터 삭제");
      System.out.println("4.주소록 출력");
      System.out.println("5.프로그램 종료");
      System.out.print("선택:");
      
   	}
   
   
}//end of handler
