package com.newlecture.app.service;

import java.sql.*;
import java.util.Date;
import java.util.*;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String id = "NEWTEST";
	private String pwd = "111111";

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		
		int start = 1+(page-1)*10;
		int end = 10*page;
		
		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writer_id = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date REGDATE = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				
				Notice notice = new Notice(id, title, writer_id, content, REGDATE, hit, files);
				
				list.add(notice);
				
			}
		
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	// Scalar : 단일값을 얻는 것.
	public int getCount() throws SQLException, ClassNotFoundException {
		
		int count =0;
		String sql = "SELECT COUNT(ID) count FROM NOTICE";
		

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) 
			count = rs.getInt("count");
			
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO NOTICE( "+
			"    TITLE,"+
			"    WRITER_ID,"+
			"    CONTENT,"+
			"    HIT,"+
			"    FILES"+
			") VALUES (?,?,?,?,?)";
		
		String title = notice.getTitle();
		String writerId = notice.getWriter_id();
		String Content = notice.getContent();
		String hit = notice.getHit();
		String files = notice.getFiles();
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pwd);
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, Content);
		st.setString(4, hit);
		st.setString(5, files);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE NOTICE " + 
				"SET TITLE=? ," + 
				"    WRITER_ID=? ," + 
				"    HIT=? ," + 
				"    FILES=? " + 
				"WHERE ID=?";
		
		String title = notice.getTitle();
		String writerId = notice.getWriter_id();
		String hit = notice.getHit();
		String files = notice.getFiles();
		int id = notice.getId();
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, this.id, pwd);
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, hit);
		st.setString(4, files);
		st.setInt(5, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM NOTICE WHERE ID=?"; 
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, this.id, pwd);
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}

	
	
}
