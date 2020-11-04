package project1.ver09;



public class InsertSQL extends IConnectImpl {

	
	String iName;
	String iphoneN;
	String ibDay;
	
	
	public InsertSQL(String iName, String iphoneN, String ibDay) {
		super(ORACLE_DRIVER, "kosmo", "1234");
		this.iName = iName;
		this.iphoneN = iphoneN;
		this.ibDay = ibDay;
		
		
	}
	
	@Override
	public void execute() {
		try {
			//1.쿼리문준비 : 값의 세팅이 필요한 부분을 ?(인파라미터)로 대체한다.
			String query = "INSERT INTO PHONEBOOK_TB VALUES (seq_phonebook.nextval,?,?,?)";
			
			//2.prepared객체생성 : 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);
		
			
			//4.인파라미터 설정 : ?의순서대로 설정하고 DB이므로 인덱스는 1부터시작
			/*
				인파라미터 설정시 사용하는 메소드
				자료형이
					숫자면 setInt()
					문자면 setString()
					날짜면 setDate() 를 사용한다.
				해당 setXXX()메소드를 사용하면 '(싱글쿼테이션)은 자동으로 삽입된다.
			 */
			psmt.setString(1, iName);
			psmt.setString(2, iphoneN);
			psmt.setString(3, ibDay);
			
			
			
			//5.쿼리실행을 위해prepared객체를 실행한다.
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close1();
		}
	}
	
	
	
	

}
