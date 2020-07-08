package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDeleteController implements Controller {
	
	private static final long serialVersionUIL = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		int num = (request.getParameter("num")!= null)?Integer.parseInt(request.getParameter("num")):-1;
		
		if(num<0) {
			System.out.println("잘못된 접근");
			response.sendRedirect(con);
			
		}
	}

}
