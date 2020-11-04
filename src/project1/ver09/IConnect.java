package project1.ver09;

public interface IConnect {

	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	void connect(String user, String pass);//DB연결
	
	void dataSearch();
	void dateInput();
	void dateDelete();
	void execute();//쿼리실행

	void close1();//자원반납
	void close2();//자원반납
	
	//String scanValue(String title);
	
}
