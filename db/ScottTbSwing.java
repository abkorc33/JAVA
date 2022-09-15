package db;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

// Scott schema에 있는 Table을 선택하여 데이터 보기

public class ScottTbSwing extends JFrame {
	
	Container contentPane;	// 작업영역
	JRadioButton[] radioTb = new JRadioButton[3];	// 테이블 선택 시 사용
	static String[] tbNames = {"EMP", "DEPT", "SALGRADE"};	// 테이블 목록
	static JTextArea tbView = new JTextArea(24, 100);	// 쿼리를 실행한 결과를 보여줄 영역
	static JLabel viewLabel;
	static JTextField sqlEdit;	// 쿼리를 직접 작성하는 영역
	
	// 생성자 작성
	ScottTbSwing() {
		setTitle("Scott Schema Table 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();	// 작업영역을 알아낸다
		
		tbView.setBackground(Color.ORANGE);
		tbView.setFont(new Font("Serif", Font.PLAIN,22));
		
		// 작업영역에 tbView Panel을 부착한다
		contentPane.add(new TbViewPanel(), BorderLayout.CENTER);
		
		setSize(1700, 800);
		setLocation(100, 100);
		setVisible(true);
	}
	// TbViewPanel : 내부클래스
	class TbViewPanel extends JPanel{
		
		JButton btnSQL;
		JPanel radioPanel = new JPanel();
		// 테이블을 선택하는 라디오버튼들, 쿼리문 입력, 쿼리 실행버튼
		JPanel viewPanel = new JPanel();	// Select한 결과를 보여주는 View
		
		//생성자
		TbViewPanel() {
			ButtonGroup tableGrp = new ButtonGroup();	// 버튼 그룹 객체 생성
			for(int i = 0; i < radioTb.length; i++) {
				radioTb[i] = new JRadioButton(tbNames[i]);	// 라디오 버튼 생성
				if(i == 0) radioTb[0].setSelected(true);  // 첫번째 라디오 버튼을 선택된 상태로 설정한다
				tableGrp.add(radioTb[i]);	// 버튼 그룹에 생성한 라디오 버튼을 장착한다
				radioPanel.add(radioTb[i]);	// 판넬에 버튼을 장착한다
			}
			
			sqlEdit = new JTextField(60);
			sqlEdit.setBackground(Color.PINK);
			sqlEdit.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,18));
			radioPanel.add(sqlEdit);
			
			btnSQL = new JButton("sql");
			
			// btnSQL버튼에 ActionListener를 등록한다
			btnSQL.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(radioTb[0].isSelected()) {	// Emp Table
						selectTable(0);
					} else if(radioTb[1].isSelected()) {	// Dept Table
						selectTable(1);
					} else if(radioTb[2].isSelected()) {	// Salgrade Table
						selectTable(2);
					}
					
				}
				
			});
			
			radioPanel.add(btnSQL);
			radioPanel.add(tbView);
			add(new JScrollPane(tbView));
			
			contentPane.add(radioPanel, BorderLayout.NORTH);
			
		}
	}
	
	public static void selectTable(int selectTb) {
		
		Connection conn = null;	// DB가 연결된 상태(세션)를 담을 객체
		PreparedStatement pstmt = null;	// sql 문을 담을 객체
		ResultSet rs = null;	// query문을 실행한 결과값을 담을 객체
		ResultSetMetaData rsmd = null;	// metadata를 담을 객체
		
		try {
			String sql = "";
			
			if(!sqlEdit.getText().equals("")) sql = sqlEdit.getText();	// 글자가 없지 않다 => 글자가 있다
			else sql = "SELECT * FROM " + tbNames[selectTb];
			
			conn = DBConnection.getConnection();	// db와 연결
			pstmt = conn.prepareStatement(sql);	// 연결된 곳에 쿼리를 준비한다
			rs = pstmt.executeQuery();	// 질의한 쿼리의 결과를 담는다
			rsmd = rs.getMetaData();	// rs에서 메타데이터를 가져온다
			
			int cols = rsmd.getColumnCount();	// select된 컬럼의 갯수를 알아낸다
			int spLength = 0;	// 컬럼 전체의 길이
			
			// 컬럼명 출력
			for(int i = 1; i <= cols; i++) {
				tbView.append("  " + rsmd.getColumnName(i) + "\t");
				// System.out.println(rsmd.getColumnDisplaySize(i));
				// rsmd.getColumnDisplaySize(i) : 컬럼의 길이
				spLength = spLength + rsmd.getColumnDisplaySize(i);
			}
			tbView.append("\n");
			
			spLength = spLength + 4 * (rsmd.getColumnCount() - 1);
			for(int i = 0; i < spLength; i++) {
				tbView.append("=");
			}
			tbView.append("\n");
			
			// 쿼리의 실행결과로 반환된 데이터를 출력
			while(rs.next()) {	// row
				for(int i = 1; i <= cols; i++) {	// column
					tbView.append("  " + rs.getString(i) + "\t");
				}
				tbView.append("\n");
			}
			
			for(int i = 0; i < spLength*1.7; i++) {
				tbView.append("-");
			}
			tbView.append("\n");
			
		}catch (SQLException sqle) {
			System.out.println("쿼리문을 실행하는 중에 예외가 발생했습니다.");
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			}catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}
	

	public static void main(String[] args) {
		
		new ScottTbSwing(); 

	}

}
