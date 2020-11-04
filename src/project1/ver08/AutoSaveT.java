package project1.ver08;

public class AutoSaveT extends Thread {
	
	PhoneBookManager pbm;
	
	public AutoSaveT(PhoneBookManager pbm) {
		this.pbm = pbm;
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
					pbm.write();
					Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				
				System.out.println("\n 자동저장OFF");
				return;
			}
			System.err.println("주소록이 텍스트로 자동저장되었습니다.");
		}
	}	
}