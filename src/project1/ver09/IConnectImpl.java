package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class IConnectImpl implements IConnect {

	//동적쿼리 처리를 위한 객체
		public Connection con;
		public PreparedStatement psmt;
		public ResultSet rs;
		public Statement stm;
		
		
		public IConnectImpl() {
			System.out.println("IConnectImpl 기본생성자 호출");
		}
		//인자생성자(매개변수2개)
		public IConnectImpl(String user, String pass) {
			System.out.println("IConnecttImpl 인자생성자 호출");
			try {
				Class.forName(ORACLE_DRIVER);
				connect(user, pass);
			}
			catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패");
				e.printStackTrace();
			}
		}
		//인자생성자(매개변수3개) - 오버로딩 처리됨
		public IConnectImpl(String driver,String user, String pass) {
			System.out.println("IConnecttImpl 인자생성자 호출");
			try {
				//드라이버로드
				Class.forName(driver);
				//DB연결
				connect(user, pass);
			}
			catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패");
				e.printStackTrace();
			}
		}
		//오라클 DB에 연결
		@Override
		public void connect(String user, String pass) {
			try {
				con = DriverManager.getConnection(ORACLE_URL, user, pass);
			}
			catch(SQLException e) {
				System.out.println("데이터베이스 연결 오류");
				e.printStackTrace();
			}
		}
		
		@Override
		public void execute() {
			//하는일 없음
		}
		//입력, 삭제 자원해제
		@Override
		public void close1() {
			try {
				if(con!=null) con.close();
				if(psmt!=null) psmt.close();
				System.out.println("자원 반납 완료");
				
			}
			
			catch(Exception e) {
				System.out.println("자원 반납시 오류발생");
				e.printStackTrace();
			}
		}
		
		//검색용
		public void close2() {
			try {
				if(con!=null) con.close();
				if(stm!=null) stm.close();
				if(rs!=null) rs.close();
				System.out.println("자원 반납 완료");
				
			}
			
			catch(Exception e) {
				System.out.println("자원 반납시 오류발생");
				e.printStackTrace();
			}
		}
		
//		@Override
//		public String scanValue(String title) {
//			
//			Scanner scan =new Scanner(System.in);
//			System.out.println(title +"을(를) 입력(exit->종료):");
//			String inputStr = scan.nextLine();
//			
//			
//			/*
//			equalsIgnoreCase()
//				: equal() 메소드와 동일하게 문자열이 같은지 비교하는 메소드로
//				다른점은 대소문자를 구분하지 않는다.
//			 */
//			if("EXIT".equalsIgnoreCase(inputStr)) {
//				System.out.println("프로그램을 종료합니다.");
//				close();//자원해제
//				System.exit(0);//프로그램 자체가 즉시 종료
//			}
//			
//			return inputStr;//입력받은 문자열을 반환
//		}
		@Override
		public void dataSearch() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void dateInput() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void dateDelete() {
			// TODO Auto-generated method stub
			
		}
		

}
