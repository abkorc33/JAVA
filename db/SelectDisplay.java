package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자가 입력한 select query를 실행하는 클래스
public class SelectDisplay {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		Scanner query = new Scanner(System.in);
		
		try {
			String sql = "";
			int cols = 0;
			
			System.out.println("SELECT 쿼리문을 작성하십시오.");
			System.out.println("끝에 세미콜론(;)을 붙이지 마십시오.");
			System.out.println("SQL > ");
			
			sql = query.nextLine();	// 쿼리문을 입력한다.
			
			conn = DBConnection.getConnection();	//db에 접속한다
			stmt = conn.createStatement();	// 접속한 곳에 쿼리문을 사용할 준비를 한다
			rs = stmt.executeQuery(sql);	// 쿼리를 실행한다
			rsmd = rs.getMetaData();	// 메타데이터를 가져온다
			
			cols = rsmd.getColumnCount();	// 컬럼의 갯수를 알아낸다
			System.out.println("\n\t");
			for(int i = 1; i <= cols; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			System.out.println("======================================================================");
			System.out.println();
			
			while(rs.next()) {	// rs.next를 하는 이유 => 데이터가 있으면 아래로 한건씩 이동
				System.out.print("\t");
				for(int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			
		} catch (SQLException sqle) {
			System.out.println("쿼리문을 실행하는 중에 예외가 발생했습니다.");
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(stmt != null) { stmt.close(); }
				if(conn != null) { conn.close(); }
			}catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		
	}

}
