package today.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

/**
 * Servlet implementation class UpdateDiaryServlet
 */
@WebServlet("/member/UDS")
public class UpdateDiaryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int diaryCode = Integer.parseInt(request.getParameter("diaryCode"));
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		DiaryVO dVo = new DiaryVO();
		dVo.setDiaryCode(diaryCode);
		dVo.setContent(content);
		dVo.setTitle(title);
		
		DiaryDAO dao = DiaryDAO.getInstance();
		
		dao.updateDiary(dVo);
		
		response.sendRedirect("DLS");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int diaryCode = Integer.parseInt(request.getParameter("diaryCode"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String diaryDate = request.getParameter("diaryDate");
		String userid = request.getParameter("userid");
		
		System.out.println("diaryCode : " + diaryCode);
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("diaryDate : " + diaryDate);
		System.out.println("userid : " + userid);
		
		DiaryVO dVo = new DiaryVO();
		dVo.setContent(content);
		dVo.setDiaryCode(diaryCode);
		dVo.setDiaryDate(diaryDate);
		dVo.setTitle(title);
		dVo.setUserid(userid);
		
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.updateDiary(dVo);
		
		response.sendRedirect("DLS");
		
		
	}

}
