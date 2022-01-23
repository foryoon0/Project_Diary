package today.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.green.vo.MemberVO;

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

public class ScrollListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiaryDAO dao = DiaryDAO.getInstance();
		
		HttpSession session = request.getSession();
		MemberVO mVo = new MemberVO();
		
		mVo = (MemberVO)session.getAttribute("loginUser");
		
		System.out.println("loginUser : " + mVo);
		
		//String userid = mVo.getUserid();
		
		
 		List<DiaryVO> dList = new ArrayList<>();
 		dList = dao.getDiary(mVo.getUserid());
 		
 		
 		Gson gson = new Gson();
		String mVoJson = gson.toJson(dList);
 		System.out.println(dList);
		
		request.setAttribute("dList", mVoJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("diary_main.jsp");
		dispatcher.forward(request, response);
		
	}

}
