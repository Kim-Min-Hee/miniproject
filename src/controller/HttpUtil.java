package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String string) {
		// TODO Auto-generated method stub
				
		RequestDispatcher rd = request.getRequestDispatcher(string);
			
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	

}
