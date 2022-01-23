package today.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import today.study.dao.DiaryDAO;
import today.study.vo.DiaryVO;

public class PagingListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리가 된 게시물 리스트 가져오기
		String url = "diary_main.jsp";
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		System.out.println("section : " + _section);
		System.out.println("pageNum : " + _pageNum);
		
		int section = Integer.parseInt((_section==null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum==null)?"1":_pageNum);
		
		DiaryDAO dao = DiaryDAO.getInstance();
		
		int totalCnt = dao.selectAllNumBoard();
		List<DiaryVO> dList = dao.selectTargetBoard(section, pageNum);
		
		request.setAttribute("totalCnt", totalCnt );
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dList", dList);

		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
