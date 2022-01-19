package today.study.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import today.study.vo.DiaryVO;

public class DiaryDAO {
	//싱글톤 패턴
	private DiaryDAO() {}
	
	private static DiaryDAO dao = new DiaryDAO();
	public static DiaryDAO getInstance() {
		return dao;
	}
	
	//연결 객체를 얻어오기 위한 메서드
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 일기장 작성 메서드
	public int insertDiary(DiaryVO dVo) {
		int result =-1;
		
		String sql = "INSERT INTO DIARY_BOARD VALUES ( DIARY_SEQ.NEXTVAL , ? , ? , ? , SYSDATE)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dVo.getUserid());
			psmt.setString(2, dVo.getTitle());
			psmt.setString(3, dVo.getContent());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
		}finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return result;
	}
	
	// 아이디를 통해서 일기장 목록 읽어오는 메서드
	public List<DiaryVO> getDiary(String userid) {
		
		DiaryVO dVo = null;
		String sql = "SELECT * FROM DIARY_BOARD WHERE USERID=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<DiaryVO> dList = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dVo = new DiaryVO();
				
				dVo.setDiaryCode(rs.getInt("diaryCode"));
				dVo.setUserid(rs.getString("userid"));
				dVo.setTitle(rs.getString("title"));
				dVo.setContent(rs.getString("content"));
				dVo.setDiaryDate(rs.getDate("diaryDate").toString());
				
				dList.add(dVo);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null ) rs.close();
				if(psmt != null ) psmt.close();
				if(conn != null ) conn.close();
			}catch(Exception e) {}
		}
		
		return dList;
	}
	
	
	public void updateDiary(DiaryVO dVo) {
		
		String sql = "UPDATE DIARY_BOARD SET TITLE = ? , CONTENT = ? WHERE DIARYCODE = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			System.out.println("update try문 시작");
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dVo.getTitle());
			psmt.setString(2, dVo.getContent());
			psmt.setInt(3, dVo.getDiaryCode());
			
			psmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public DiaryVO selectDiaryByCode(int diaryCode) {
		DiaryVO dVo = null;
		
		String sql = "SELECT * FROM DIARY_BOARD WHERE DIARYCODE = ?";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, diaryCode);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dVo = new DiaryVO();
				
				dVo.setDiaryCode(rs.getInt("diaryCode"));
				dVo.setUserid(rs.getString("userid"));
				dVo.setTitle(rs.getString("title"));
				dVo.setContent(rs.getString("content"));
				dVo.setDiaryDate(rs.getDate("diaryDate").toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		return dVo;
	}
	
	public void deleteDiaryByCode(int diaryCode) {
		
		String sql = "DELETE FROM DIARY_BOARD WHERE DIARYCODE = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			System.out.println("delete try문 시작");
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, diaryCode);
			
			psmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
		
		


}
