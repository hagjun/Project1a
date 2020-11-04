package project1.ver09;

import java.sql.SQLException;


public class SelectSQL extends IConnectImpl {

String searchName;
	
	
	public SelectSQL(String searchName) {
		super("kosmo", "1234");
		this.searchName = searchName;
		
	}
	
	@Override
	public void execute() {
		try 
		{
			
			String sql = "SELECT name, phone, birth FROM PHONEBOOK_TB WHERE name LIKE '%"+searchName+"%'";
				//+ " WHERE name LIKE '%?%'";// 에러발생:부적합한 열 인덱스

			stm = con.createStatement();
			
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String birth = rs.getString("birth");
				
				
				System.out.printf("이름: %s, 전화번호: %s, 생년월일:%s\n",name, phone, birth);
			}
				
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생!");
			e.printStackTrace();
		}
		finally {
			close2();//DB 자원반납
		}
	
	
	}
	
	
	

}
