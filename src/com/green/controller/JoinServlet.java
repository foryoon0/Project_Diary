package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

@WebServlet("/member/join.do")
public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 가입 폼으로 연결
		String url="member/join.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼으로 부터 읽어온 데이터를 데이터베이스에 저장
		request.setCharacterEncoding("UTF-8");
		
	
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String nickname = request.getParameter("nickname");

		
		MemberVO mVo = new MemberVO();
		
		mVo.setUserid(userid);
		mVo.setUserpwd(userpwd);
		mVo.setNickname(nickname);

		System.out.println("얻어온값:" + userid);
		System.out.println("얻어온값:"+ userpwd);
		System.out.println("얻어온값:" + nickname);
		
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.insertMember(mVo);
		
		if(result==1) {
			request.setAttribute("userid", userid);
			
		}else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
