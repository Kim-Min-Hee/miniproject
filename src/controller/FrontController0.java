package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController0 extends HttpServlet {
	
	private MemberService service;
    public FrontController0(){
        service= new MemberService();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(request,response);
        System.out.println("doGet");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(request,response);
        System.out.println("doPost");
    }
    
    protected void doProc(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String contextPath = request.getContextPath();
        String reqUri = request.getRequestURI();

        if(reqUri.equals(contextPath + "/memberInsert.do"))
        {
            String id = request.getParameter("id");
            String pw = request.getParameter("password");
            if(service.login(id, pw)){
            	request.setAttribute("msg", "로그인 성공");
            	request.getSession().setAttribute("id", id);
            }
            else{
            	request.setAttribute("msg", "로그인 실패");
            }
            request.getRequestDispatcher("memberSeach.do").forward(request, response);
        }
        else if(reqUri.equals(contextPath + "/memberInsert.do"))   
        {
        	request.getRequestDispatcher("memberInsert.do").forward(request, response);
        }
        else if(reqUri.equals(contextPath + "/home.do")) 
        {
            if(request.getSession().getAttribute("id") == null)
            {
                
            	response.sendRedirect("memberInsert.do");
                
                    return;
            }
            
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }

            else if(reqUri.equals(contextPath + "/memberUpdate.do"))
            {
                
                String id = request.getParameter("id");
                //MemberVO memberVO = service.getMember("id");
                //req.setAttribute("member", memberVO);
                request.getRequestDispatcher("memberUpdateForm.jsp") 
                .forward(request, response);
            }

            else if(reqUri.equals(contextPath + "/memberUpdate.do"))
            {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
        
            service.update(id, pw, name);
            response.sendRedirect("main.do");
            return;
            }

            else if(reqUri.equals(contextPath + "/memberList.do"))
            {
            	request.setAttribute("memberList", service.getMemberList());
            	request.getRequestDispatcher("memberList.jsp")
                .forward(request, response);
            }

            else if(reqUri.equals(contextPath + "/joinForm.do"))
            {
            	request.getRequestDispatcher("joinForm.jsp")
                .forward(request, response);
            }
            

            
            else if(reqUri.equals(contextPath + "/join.do"))
            {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            service.join(id, pw, name);
            response.sendRedirect("loginForm.do");
            return;
            }
            
        }
        
    }


