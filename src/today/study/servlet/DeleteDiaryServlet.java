package today.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import today.study.dao.DiaryDAO;

@WebServlet("/member/DDS")
public class DeleteDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int diaryCode = Integer.parseInt(request.getParameter("code"));
		
		System.out.println(diaryCode);
		
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.deleteDiaryByCode(diaryCode);
		
		System.out.println("삭제완료");
		
		response.sendRedirect("DLS");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
