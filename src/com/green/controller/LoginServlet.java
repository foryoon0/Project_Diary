package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;


@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="login.jsp";
		

		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url="main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = "login.jsp"; 
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		// 로그인 인증 처리
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid, userpwd);
		
		if(result == 1) {
			MemberVO mVo = dao.getMember(userid);
			HttpSession session = request.getSession();  
			
			session.setAttribute("loginUser", mVo);
			
			url = "DLS";  
		}else if(result == 0) { //비밀번호가 틀린 경우
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {// 아이디가 없는 경우
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
