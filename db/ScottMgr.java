package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

//-----------------------------------------------------------------------------------------------------------
// scott schema 테이블 관리 프로그램
//-----------------------------------------------------------------------------------------------------------
public class ScottMgr {
	
	static 	Scanner				keyboard	= new Scanner(System.in);
	static	Connection			conn		= null;	// DB에 연결된 상태(세션)을 담을 객체
	static	PreparedStatement	pstmt		= null;	// SQL문을 나타내는 객체
	static	ResultSet			rs			= null;	// 쿼리문을 실행한 것에 대한 반환 값을 담을 객체
	static	ResultSetMetaData	rsmd		= null;	// 테이블의 메타데이터를 가리키는 객체
	static	String				sql			= "";
	static	String[] FromTable = { "EMP", "DEPT", "SALGRADE" };

	//-----------------------------------------------------------------------------------------------------------
	// 메뉴 1 (테이블 선택)
	//-----------------------------------------------------------------------------------------------------------
	public static void showMenu1() {
		System.out.println("작업하고자 하는 테이블을 선택하십시오.");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. EMP		TABLE");
		System.out.println("2. DEPT		TABLE");
		System.out.println("3. SALGRADE	TABLE");
		System.out.print("선택 : ");
	} // End - public static void showMenu1()
	//-----------------------------------------------------------------------------------------------------------
	// 메뉴 2 (작업선택 : 조회, 입력, 수정, 삭제)
	//-----------------------------------------------------------------------------------------------------------
	public static void showMenu2() {
		System.out.println("하시고자 하는 작업을 선택하십시오.");
		System.out.println("0. 테이블 선택");
		System.out.println("1. 조회");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.print("선택 : ");
	}
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		int	choice1;	// 선택한 번호를 저장할 변수

		while(true) {
			showMenu1();					// 테이블을 선택할 수 있게 메뉴를 보여준다.
			choice1	= keyboard.nextInt();	// 사용자가 메뉴를 선택한다.
			keyboard.nextLine();
			
			switch(choice1) {
				case 1:	subMenu(1); 
						break;
				case 2:	subMenu(2); 
						break;
				case 3:	subMenu(3); 
						break;
				case 0:	System.out.println("프로그램을 종료합니다."); 
						return;
				default:System.out.println("번호를 정확하게 입력하십시오.");
						break;
			}
			
		} // End - while(true)
	} // End - public static void main(String[] args)

	//-----------------------------------------------------------------------------------------------------------
	// 테이블을 선택한 후 할 작업을 보여주는 메뉴화면
	//-----------------------------------------------------------------------------------------------------------
	public static void subMenu(int choice1) {
		int	choice2;	// 조회, 입력, 수정, 삭제를 선택한 값을 저장할 변수
		
		while(true) {
			showMenu2();
			choice2 = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(choice2) {
				case 0:	System.out.println("이전 작업으로 돌아갑니다.");
						return;
				case 1:	selectTable(choice1);	// 조회
						break;
				case 2: insertTable(choice1);	// 입력
						break;
				case 3: updateTable(choice1);	// 수정
						break;
				case 4:	deleteTable(choice1);	// 삭제
						break;
						
				default:System.out.println("작업할 번호를 정확하게 입력하십시오.");
						break;
			}
		}
		
	} // End - public static void subMenu2(int choice1)
	
	//-----------------------------------------------------------------------------------------------------------
	// SELECT : 선택한 테이블의 모든 정보를 보여주자.
	//-----------------------------------------------------------------------------------------------------------
	public static void selectTable(int selectTb) {
		System.out.println("선택한 테이블 : " + FromTable[selectTb-1]);
		
		try {
			sql = "";
			sql	= "SELECT * FROM " + FromTable[selectTb-1];
			
			conn 	= DBConnection.getConnection();
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			rsmd	= rs.getMetaData();	// 컬럼명들을 가져온다.
			
			System.out.println("=====================================================================================================");
			System.out.println(FromTable[selectTb-1]);
			System.out.println("=====================================================================================================");

			int cols = rsmd.getColumnCount(); 	// 테이블의 컬럼 갯수
			for(int i = 1; i <= cols; i++) {	// 컬럼명을 보여준다.
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			System.out.println("=====================================================================================================");

			// 데이터를 화면에 출력한다.
			while(rs.next()) {
				for(int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println(); // 1건의 데이터를 화면에 출력하면 줄바꿈을 한다.
			} // End - while(rs.next())
			System.out.println("=====================================================================================================");
			
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외가 발생하였습니다.");
			sqle.printStackTrace();
		} finally {
			try {
				// DB 연결을 종료한다. 열려진 자원을 닫는다.
				if(rs		!= null)	{	rs.close();		}
				if(pstmt	!= null)	{	pstmt.close();	}
				if(conn		!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // End - public static void selectTable(int selectTb)
	
	//-----------------------------------------------------------------------------------------------------------
	// 테이블의 데이터를 등록하자.
	//-----------------------------------------------------------------------------------------------------------
	public static void insertTable(int selectTb) {

		System.out.println("선택한 테이블 : " + FromTable[selectTb-1]);
		
		try {
			if(selectTb == 1) {
				System.out.print("EMPNO : ");
				int empno = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("ENAME : ");
				String ename = keyboard.nextLine();
				System.out.print("JOB : ");
				String job = keyboard.nextLine();
				System.out.print("MGR : ");
				int mgr = keyboard.nextInt();
				keyboard.nextLine();

				System.out.print("SAL : ");
				int sal = keyboard.nextInt();
				keyboard.nextLine();

				System.out.print("COMM : ");
				int comm = keyboard.nextInt();

				System.out.print("DEPTNO : ");
				int deptno = keyboard.nextInt();
				keyboard.nextLine();

				sql	= "";
				sql = "INSERT INTO " + FromTable[selectTb-1] + " VALUES(?,?,?,?,now(),?,?,?)";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setInt	(1, empno);
				pstmt.setString	(2, ename);
				pstmt.setString	(3, job);
				pstmt.setInt	(4, mgr);
				pstmt.setInt	(5, sal);
				pstmt.setInt	(6, comm);
				pstmt.setInt	(7, deptno);
				
			} else if(selectTb == 2) {	// 부서 테이블
				System.out.print("DEPTNO : ");
				int deptno = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("DNAME : ");
				String dname = keyboard.nextLine();
				
				System.out.print("LOC : ");
				String loc = keyboard.nextLine();

				sql	= "";
				sql = "INSERT INTO " + FromTable[selectTb-1] + " VALUES(?,?,?)";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setInt	(1, deptno);
				pstmt.setString	(2, dname);
				pstmt.setString	(3, loc);
				
			} else if(selectTb ==  3) {
				System.out.print("GRADE : ");
				int	grade	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("LOSAL : ");
				int	losal	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("HISAL : ");
				int	hisal	= keyboard.nextInt();
				keyboard.nextLine();
				
				sql	= "";
				sql	= "INSERT INTO " + FromTable[selectTb-1] + " VALUES (?, ?, ?)";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setInt(1, grade);
				pstmt.setInt(2, losal);
				pstmt.setInt(3, hisal);
			}
			
			// 입력 쿼리문을 실행한다.
			int rtnVal = pstmt.executeUpdate();	// 입력,수정,삭제는 결과값으로 실행된 건수를 반환한다.
			if(rtnVal > 0) {
				System.out.println(rtnVal + "건 입력이 되었습니다.");
			} else {
				System.out.println("데이터 입력 실패.....");
			}
			
		} catch (SQLException sqle) {
			System.out.println("INSERT문에서 예외가 발생하였습니다.");
			sqle.printStackTrace();
		} finally {
			try {
				// DB 연경을 종료한다. 열려진 자원을 닫는다.
				if(rs		!= null)	{	rs.close();		}
				if(pstmt	!= null)	{	pstmt.close();	}
				if(conn		!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // End - public static void insertTable(int selectTb)
	
	//-----------------------------------------------------------------------------------------------------------
	// 테이블의 데이터를 수정하자.
	//-----------------------------------------------------------------------------------------------------------
	public static void updateTable(int selectTb) {
		
		System.out.println("선택한 테이블 : " + FromTable[selectTb-1]);
		
		try {
			if(selectTb == 1) {	// EMP Table
				// 사원번호에 해당하는 이름을 바꾸자.
				System.out.print("EMPNO : ");
				int		empno	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("ENAME : ");
				String 	ename	= keyboard.nextLine();
				
				// sql	= "update 테이블명 set 컬럼=값, 컬럼=값 where 컬럼 = ?";
				sql	= "";
				sql = "UPDATE " + FromTable[selectTb-1] + " SET ename=? WHERE empno=?";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setString	(1, ename);
				pstmt.setInt	(2, empno);
				
			} else if(selectTb == 2) {	// DEPT Table
				// 입력한 부서번호(deptno)에 해당하는 부서의 이름(dname)을 바꾸자.
				System.out.print("DEPTNO : ");
				int		deptno	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("DNAME : ");
				String 	dname	= keyboard.nextLine();
				
				// sql	= "update 테이블명 set 컬럼=값, 컬럼=값 where 컬럼 = ?";
				sql	= "";
				sql = "UPDATE " + FromTable[selectTb-1] + " SET dname=? WHERE deptno=?";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setString	(1, dname);
				pstmt.setInt	(2, deptno);
				
			} else if(selectTb == 3) {	// SALGRADE Table
				// 월급등급(grade)에 해당하는 최저급여(losal)와 최대급여(hisal)을 바꾸자.
				System.out.print("GRADE : ");
				int		grade	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("최저임금 : ");
				int		losal	= keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("최대임금 : ");
				int		hisal	= keyboard.nextInt();
				keyboard.nextLine();
				
				
				// sql	= "update 테이블명 set 컬럼=값, 컬럼=값 where 컬럼 = ?";
				sql	= "";
				sql = "UPDATE " + FromTable[selectTb-1] + " SET losal = ?, hisal = ? WHERE grade = ?";
				
				// 드라이버를 로딩하고, DB에 접속한다.
				conn = DBConnection.getConnection();
				
				// 커넥션을 맺은 곳에 질문할 준비를 한다.
				pstmt = conn.prepareStatement(sql);
				
				// ?에 해당하는 데이터를 준비한다.
				pstmt.setInt	(1, losal);
				pstmt.setInt	(2, hisal);
				pstmt.setInt	(3, grade);
				
			}
			
			// 수정 쿼리문을 실행한다.
			int rtnVal = pstmt.executeUpdate();	// 입력,수정,삭제는 결과값으로 실행된 건수를 반환한다.
			if(rtnVal > 0) {
				System.out.println(rtnVal + "건이 수정 되었습니다.");
			} else {
				System.out.println("데이터 수정 실패.....");
			}
			

		} catch (SQLException sqle) {
			System.out.println("UPDATE문에서 예외가 발생하였습니다.");
			sqle.printStackTrace();
		} finally {
			try {
				// DB 연결을 종료한다. 열려진 자원을 닫는다.
				if(rs		!= null)	{	rs.close();		}
				if(pstmt	!= null)	{	pstmt.close();	}
				if(conn		!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	} // End - public static void updateTable(int selectTb)
	
	//-----------------------------------------------------------------------------------------------------------
	// 테이블의 데이터를 삭제하자.
	//-----------------------------------------------------------------------------------------------------------
	public static void deleteTable(int selectTb ) {

		System.out.println("선택한 테이블 : " + FromTable[selectTb-1]);

		try {
			// DELETE FROM 테이블명 WHERE 컬럼 = ?
			if(selectTb == 1) {	// EMP Table
				// 사원번호(empno)에 해당하는 자료를 삭제하자.
				System.out.print("사원번호 : ");
				int		empno	= keyboard.nextInt();
				keyboard.nextLine();
				
				sql		= "";
				sql		= "DELETE FROM emp WHERE empno = ?";
				conn	= DBConnection.getConnection();
				pstmt	= conn.prepareStatement(sql);
				
				pstmt.setInt(1, empno);
				
			} else if(selectTb == 2) {	// DEPT Table
				// 부서번호(deptno)에 해당하는 자료를 삭제하자.
				System.out.print("부서번호 : ");
				int		deptno	= keyboard.nextInt();
				keyboard.nextLine();
				
				sql		= "";
				sql		= "DELETE FROM dept WHERE deptno = ?";
				conn	= DBConnection.getConnection();
				pstmt	= conn.prepareStatement(sql);
				
				pstmt.setInt(1, deptno);
				
			} else if(selectTb == 3) {	// SALGRADE Table
				// 월급등급(grade)에 해당하는 자료를 삭제하자.
				System.out.print("월급의 등급 : ");
				int		grade	= keyboard.nextInt();
				keyboard.nextLine();
				
				sql		= "";
				sql		= "DELETE FROM salgrade WHERE grade = ?";
				conn	= DBConnection.getConnection();
				pstmt	= conn.prepareStatement(sql);
				
				pstmt.setInt(1, grade);
				
			}
			
			// 삭제 쿼리문을 실행한다.
			int rtnVal = pstmt.executeUpdate();	// 입력,수정,삭제는 결과값으로 실행된 건수를 반환한다.
			if(rtnVal > 0) {
				System.out.println(rtnVal + "건이 삭제 되었습니다.");
			} else {
				System.out.println("데이터 삭제 실패.....");
			}

		} catch (SQLException sqle) {
			System.out.println("UPDATE문에서 예외가 발생하였습니다.");
			sqle.printStackTrace();
		} finally {
			try {
				// DB 연결을 종료한다. 열려진 자원을 닫는다.
				if(rs		!= null)	{	rs.close();		}
				if(pstmt	!= null)	{	pstmt.close();	}
				if(conn		!= null)	{	conn.close();	}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	} // End - public static void deleteTable(int selectTb )
	
} // End - public class ScottMgr

















