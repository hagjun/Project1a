package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {
   
    public static void main(String[] args) {
       
       
    PhoneInfo info = new PhoneInfo("성낙현","010-7906-3600","751130");    
    PhoneInfo inf = new PhoneInfo("류상미","010-7669-4120",null);
   
    info.showPhoneInfo();
    System.out.println();
    inf.showPhoneInfo();
   
       
       
    }
}