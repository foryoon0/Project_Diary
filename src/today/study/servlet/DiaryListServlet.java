package today.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.vo.MemberVO;

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

/**
 * Servlet implementation class DiaryListServlet
 */
@WebServlet("/member/DLS")
public class DiaryListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiaryDAO dao = DiaryDAO.getInstance();
		
		HttpSession session = request.getSession();
		MemberVO mVo = new MemberVO();
		
		mVo = (MemberVO)session.getAttribute("loginUser");
		
		System.out.println("loginUser : " + mVo);
		
		//String userid = mVo.getUserid();
		
		
 		List<DiaryVO> dList = new ArrayList<>();
 		dList = dao.getDiary(mVo.getUserid());
		
		request.setAttribute("dList", dList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("diary_main.jsp");
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
