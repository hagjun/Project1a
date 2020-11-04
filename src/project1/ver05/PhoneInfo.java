package project1.ver05;



public class PhoneInfo {


    String name;
    String phoneNumber;

      
    public PhoneInfo(String name, String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        
    }
    public PhoneInfo() {
    	  
    	this.name = name;
    	this.phoneNumber = phoneNumber;
    	
    }



    public void dataput() {
    	  
    	System.out.println("이름:"+name);
    	System.out.println("전화번호:"+phoneNumber);
    	
    	  
    }
    public void showPhoneInfo() {
         
        System.out.println("이름:"+name);
        System.out.println("전화번호:"+phoneNumber);
        
       
         
         
         
    }
}
