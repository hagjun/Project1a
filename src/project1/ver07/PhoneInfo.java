package project1.ver07;



public class PhoneInfo {


    String name;
    String phoneNumber;
     
    
    public PhoneInfo(String name, String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public void showPhoneInfo() {
    	
    	System.out.println("이름:"+name);
    	System.out.println("전화번호:"+phoneNumber);
    	
    	
    }


//	public void dataput() {
//    	  
//    	System.out.println("이름:"+name);
//    	System.out.println("전화번호:"+phoneNumber);
//    	
//    	  
//    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		PhoneInfo other = (PhoneInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
