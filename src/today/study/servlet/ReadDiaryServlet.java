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
 * Servlet implementation class ReadDiaryServlet
 */
@WebServlet("/member/RDS")
public class ReadDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		int diaryCode = Integer.parseInt(request.getParameter("diaryCode"));
		
		DiaryDAO dao = DiaryDAO.getInstance();
		DiaryVO dVo = dao.selectDiaryByCode(diaryCode);
		
		request.setAttribute("dVo", dVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("read_diary.jsp");
		dispatcher.forward(request, response);
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
