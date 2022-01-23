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

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

/**
 * Servlet implementation class DiaryListServlet
 */
@WebServlet("/member/DLS")
public class DiaryListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		System.out.println("받아온 command : " + command);
		if(command == null) {
			command = "paging";
			System.out.println("여기안들어오니");
		}
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request,response);   // Action타입은 execute메서드를 강제로 발현하는 인터페이스
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
