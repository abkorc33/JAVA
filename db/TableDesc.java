package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//-----------------------------------------------------------------------------------------------------------
// 테이블의 구조를 알아내는 클래스
//-----------------------------------------------------------------------------------------------------------
public class TableDesc {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		BufferedReader		br		= new BufferedReader(new InputStreamReader(System.in));
		Connection			conn	= null;	// DB에 연결된 상태(세션)을 담을 객체
		Statement			stmt	= null;	// SQL문을 나타내는 객체
		ResultSet			rs		= null;	// 쿼리문을 실행한 결과를 담을 객체
		ResultSetMetaData	rsmd	= null;
		
		/*	ResultSetMetaData
		 * 
		 * meta-data ?
		 * 데이터의 데이터라고 할 수 있다.
		 * 즉, 우리가 사용하는 데이터베이스 내의 데이터를 구성하는 주변 정보들을 말한다.
		 * 예를들어 컬러명, 컬럼타입, 컬럼 카운트 등등을 메타 데이터라고 할 수 있다.
		 * 
		 * ResultSet 자체가 쿼리문의 결과를 가져오는 것이고,
		 * ResultSetMetaData 역시 쿼리문의 결과를 가져온 ResultSet에 대한 메타 데이터를 가져오는 것이다. 
		 * 
		 * ResultSetMetaData는 아래와 같은 메서드들을 가지고 있다.
		 * int		getColumnCount()			: 컬럼의 갯수를 리턴.
		 * String	getColumnLabel(int index)	: index의 컬럼명(Select ename AS EN 같은 경우는 EN을 의미한다.)
		 * String	getColumnName(int index)	: index의 컬럼명(Select ename AS EN 같은 경우는 ename을 의미한다.)
		 * int		getColumnType(int index)	: index의 컬럼타입의 정수형(ex, VARCHAR는 12이다.)
		 * String	getColumnTypeName(int index): index의 컬럼타입을 직접적인 문자로 리턴한다.
		 * int		getColumnDisplaySize(int index)	: index의 컬럼에 지정된 데이터의 길이를 리턴한다.
		 */
		
		try {
			conn	= DBConnection.getConnection();	// DB 접속
			
			String	fromTable;
			String	sql;
			
			System.out.print("보시고자하는 테이블의 이름을 입력하십시오 : ");
			fromTable = br.readLine();
			
			sql		= "SELECT * FROM " + fromTable;
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			rsmd	= rs.getMetaData();
			
			int cols	= rsmd.getColumnCount();	// 컬럼의 갯수
			System.out.println("컬럼명\t타입\t타입명\t폭");
			System.out.println("======================================================================================");
			for(int i = 1; i <= cols; i++) {
				System.out.print(rsmd.getColumnName(i)		+ "\t");
				System.out.print(rsmd.getColumnType(i)		+ "\t");
				System.out.print(rsmd.getColumnTypeName(i)	+ "\t");
				System.out.print(rsmd.getPrecision(i)		+ "\t");
				System.out.println();
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

} // End - public class TableDesc




