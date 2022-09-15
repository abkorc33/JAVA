package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//---------------------------------------------------------------------------------------------
// DB 접속 클래스
//---------------------------------------------------------------------------------------------
public class DBConnection {

	//---------------------------------------------------------------------------------------------
	// public static Connection getConnection()
	//---------------------------------------------------------------------------------------------
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			String	user	= "scott";
			String	pass	= "abkorc33";
			// String	url		= "jdbc:oracle:thin:@접속할 곳의 ip주소:포트번호:SID";
			// String	url		= "jdbc:oracle:thin:@localhost:1521:XE";
			String	url		= "jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul&useSSL=false";
			
			/*
			Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
			com.mysql.jdbc.Driver가 옛날 버전이기 때문에
			최선버전인 com.mysql.cj.jdbc.Driver로 바꿔서 사용하라는 메시지입니다.
			 */
			
			// 1. Driver를 Loading한다.
			// Class.forName("com.mysql.jdbc.Driver");	// MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");	// MySQL
			// Class.forName("oracle.jdbc.driver.OracleDriver");	// Oracle
			
			// 2. DB에 접속한다.
			conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Database에 연결이 되었습니다.");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB Driver Loading Faild : " + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unknown Error.....");
			e.printStackTrace();
		}
		
		// 접속되 정보를 반환한다.
		return conn;
		
	} // End - public static Connection getConnection()

} // End - public class DBConnection






