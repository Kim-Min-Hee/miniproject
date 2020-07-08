package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSeachController implements Controller {

	private static String USER_ID = null;
	private static String USER_PASSWORD = null;
	private static String USER_NAME = null;
	private Connection conn;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from member where id = ?";
		
		PreparedStatement pstmt = null;
		MemberVO memberVO = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, USER_ID);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setUSER_ID(rs.getString("id"));
				memberVO.setUSER_PASSWORD(rs.getString("password"));
				memberVO.setUSER_NAME(rs.getString("name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if(rs != null && !rs.isClosed())
					pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			return;
	}
	
		
	}


