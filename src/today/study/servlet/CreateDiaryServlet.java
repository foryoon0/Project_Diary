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

@WebServlet("/member/CDS")
public class CreateDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		DiaryVO dVo = new DiaryVO();
		
		dVo.setUserid(userid);
		dVo.setTitle(title);
		dVo.setContent(content);
		
		DiaryDAO dao = DiaryDAO.getInstance();
		
		
		
		int result = dao.insertDiary(dVo);
		
		if(result==1) {
			request.setAttribute("message", "일기가 작성되었습니다.");
			
		}else {
			request.setAttribute("message", "일기 작성이 실패하였습니다.");
		}
		
		response.sendRedirect("DLS");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
