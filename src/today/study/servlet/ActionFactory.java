package today.study.servlet;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("paging")) {
			action = new PagingListAction(); //게시물 전체 보기(목록 보기)
		}else if(command.equals("scroll")) {
			action = new ScrollListAction(); //게시물 등록 폼 이동
		}else if(command == null){
			action = new PagingListAction(); //게시물 전체 보기(목록 보기)
		}
		
		return action;
	}

}
