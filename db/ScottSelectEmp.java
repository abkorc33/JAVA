package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//---------------------------------------------------------------------------------------------
// Scott Schema에 있는 Emp테이블의 정보를 가져오는 클래스
//---------------------------------------------------------------------------------------------
public class ScottSelectEmp {

	//---------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//---------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Connection			conn	= null;	// DB에 연결된 상태(세션)을 담을 객체
		PreparedStatement	pstmt	= null;	// SQL문을 나타내는 객체
		ResultSet			rs		= null;	// 쿼리문을 실행한 결과를 담을 객체
		
		try {
			// SQL 문장을 만들고 만약에 문자의 질의어(SELECT)라면
			// 그 결과를 담을 ResultSet 객체를 준비한 후에 실행한다.
			
			// 사원테이블(emp)에서 모든 정보를 사원번호 순으로 추출하자!
			String	sql = "SELECT * FROM emp ORDER BY empno ";
			
			// 드라이버를 로딩하고, DB에 접속한다.
			conn = DBConnection.getConnection();
			
			// 커넥션을 맺은 곳에 질문할 준비를 한다.
			pstmt = conn.prepareStatement(sql);
			
			// 준비한 질문을 실행시키고, 결과값을 ResultSet에 넣는다.
			rs = pstmt.executeQuery();
			
			// 찾아온 데이터를 화면에 보여주자.
			System.out.println("EMPNO\t\tENAME\t\tJOB\t\tMGR\tHIREDATE\t\tSAL\tCOMM\tDEPTNO");
			System.out.println("=========================================================================================");
			
			while(rs.next()) {
				int		empno		= rs.getInt("empno");
				String	ename		= rs.getString(2);
				String	job			= rs.getString("job");
				int		mgr			= rs.getInt(4);
				Date	hiredate	= rs.getDate(5);	// hiredate => java.sql.Date
				int		sal			= rs.getInt(6);
				int		comm		= rs.getInt(7);
				int		deptno		= rs.getInt(8);
				
				String	result = empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno;
				System.out.println(result);
			}
			
		} catch (SQLException sqle) {
			System.out.println("SELECT 문에서 예외가 발생하였습니다.");
		} finally {
			// DB 연결을 종료하기 전에 열려진 자원을 닫는다.
			try {
				if(rs		!= null)	{	rs.close();		}
				if(pstmt	!= null)	{	pstmt.close();	}
				if(conn		!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	} // End - public static void main(String[] args)

} // End - public class ScottSelectEmp






