package ex1;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "select * from notice where hit>=10";
		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWTEST", "111111");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);


		while(rs.next()) {
				String id = rs.getString("ID");
				String title = rs.getString("TITLE");
				String writer_id = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date REGDATE = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				
				System.out.printf("id=%s, title=%s, Writer_id=%s, content=%s, regdate=%s, hit=%s, files=%s",
						id,title,writer_id,content,REGDATE,hit,files);
				System.out.println();
			}
		
		rs.close();
		st.close();
		con.close();

	}
}
