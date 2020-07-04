package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	private static final long serialVersionID = 1L;
	
	String charset = null;
	HashMap<String,Controller>list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		
		list = new HashMap<String,Controller>();
		list.put("/front.do",new MemberInsertController());
		list.put("/memberSeach.do",new MemberSeachController());
		list.put("/memberUpdate.do",new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}
	
//	@Override
//	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		request.setCharacterEncoding(charset);
//		
//		String url = request.getRequestURI();
//		String contextPath= request.getContextPath();
//		String path= url.substring(contextPath.length());
//		
//		Controller subController = list.get(path);
//		subController.execute(request,response);
//	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
	  System.out.println("doGet");
        doProc(request,response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	System.out.println("doPost");
        doProc(request,response);
    }
    
    protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding(charset);
    	String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		
		Controller subController = list.get(path);
		subController.execute(request,response);


    }
	 
}