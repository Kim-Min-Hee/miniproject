package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
	
	private static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance== null)
			instance = new MemberDAO();
		return instance;
	}
	private Connection conn;
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String USER_NAME = "mini";
	private static String USER_PASSWORD = "12345";
	private MemberDAO() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test",USER_NAME,USER_PASSWORD);
			if(conn != null) {
				System.out.println("DB접속 성공!!!!");
			}
		}catch(ClassNotFoundException e) {
			System.out.println("오류발생: "+e);
			System.out.println("오류!!!!");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DB 접속 실패");
		}
	}
		
	public void memberInsert(MemberVO memberVO) {
		String sql="insert into information (user_id,user_password,user_name) values (?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt= conn.prepareStatement(sql.toString());
			System.out.println("MemberDAO get User_ID : "+memberVO.getUSER_ID());
			pstmt.setString(1, memberVO.getUSER_ID());
			pstmt.setString(2, memberVO.getUSER_PASSWORD());
			pstmt.setString(3, memberVO.getUSER_NAME());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public MemberVO memberSearch(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

		

		


}
