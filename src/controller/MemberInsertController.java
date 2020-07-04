package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertController implements Controller {

	private static String USER_ID = null;
	private static String USER_PASSWORD = null;
	private static String USER_NAME = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("~~~~");
		USER_ID = request.getParameter("USER_ID");
		USER_PASSWORD = request.getParameter("USER_PASSWORD");
		USER_NAME = request.getParameter("USER_NAME");
		
		if (USER_ID.isEmpty() || USER_PASSWORD.isEmpty() || USER_NAME.isEmpty()) {
			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			System.out.println("99999");
			return;
		}
		
		
		
		MemberVO member = new MemberVO();
		member.setUSER_ID(USER_ID);
		member.setUSER_PASSWORD(USER_PASSWORD);
		member.setUSER_NAME(USER_NAME);
		
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		request.setAttribute("USER_ID", USER_ID);
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
		System.out.println("22222");

	}

}
