package ex1;

import java.sql.*;


public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"NEWTEST","111111");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
	
		while(rs.next()) {
			String id = rs.getString("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String CONTENT = rs.getString("CONTENT");
			String HIT = rs.getString("HIT");
			
			System.out.printf("id=%s, title=%s, wirter_id=%s, content=%s, hit=%s",
					id,title,writer_id,CONTENT,HIT);
			System.out.println();
		}
		
		
		
		
		
		
	}
}
