package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//-----------------------------------------------------------------------------------------------------------
// 데이터 방향 이동
//-----------------------------------------------------------------------------------------------------------
public class RowsDisplay {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Connection		conn	= null;
		Statement		stmt	= null;
		ResultSet		rs		= null;
		String			sql		= "";
		
		try {
			conn	= DBConnection.getConnection();	// DB 접속
			
			/* 기본은 순방향만 검색 가능
			 * 순방향과 역방향 모두 검색 가능
			 * TYPE_SCROLL_SENSITIVE		: 변경 내용이 바로 반영
			 * TYPE_SCROLL_INSENSITIVE		: 변경 내용이 바로 반영이 안됨
			 * CONCUR_READ_ONLY				: 읽기만 가능
			 * CONCUR_UPDATABLE				: 읽기 및 수정 가능
			 */
			sql		= "SELECT * FROM emp ORDER BY empno ";
			stmt	= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs		= stmt.executeQuery(sql);
			
			char ch;	// 키보드로 부터 입력한 값을 저장할 변수
			
			while(true) {
				do {
					System.out.print("1.처음  2.이전  3.다음  4.마지막  5.종료");
					// read()는 한 문자만을 입력받으므로, 버퍼로 인해서 예상치 못한 경우가 발생할 수 있다.
					ch = (char)System.in.read();
					
					
				} while(ch < '1' || ch > '5');
			}
			
		} catch (SQLException sqle) {
			System.out.println("SELECT 문에서 예외가 발생하였습니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			// DB 연결을 종료하기 전에 열려진 자원을 닫는다.
			try {
				if(rs	!= null)	{	rs.close();		}
				if(stmt	!= null)	{	stmt.close();	}
				if(conn	!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}



	} // End - public static void main(String[] args)

} // End - public class RowsDisplay












