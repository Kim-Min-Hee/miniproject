package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberList extends HttpServlet{
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberSeachController>list = dao.selectAllMember();
		req.setAttribute("memberList", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("MemberList.jsp");
		dispatcher.forward(req, resp);
	}
	
//	private Connection conn;
//	
//	public List<MemberVO> selectAll(){
//		String sql = "select * from information";
//		PreparedStatement pstmt =null;
//		
//		ResultSet rs = null;
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				MemberVO memberVO = new MemberVO();
//				memberVO.setUSER_ID(rs.getString("id"));
//				memberVO.setUSER_PASSWORD("password");
//				memberVO.setUSER_NAME("name");
//				memberList.add(memberVO);
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null && !pstmt.isClosed()) 
//					pstmt.close();
//					if(rs != null && !rs.isClosed())
//						pstmt.close();
//				}catch(SQLException e){
//					e.printStackTrace();
//				}
//			}
//			return memberList;
//		}
}

