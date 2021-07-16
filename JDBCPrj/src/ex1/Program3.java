package ex1;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE " + 
				"SET TITLE=? ," + 
				"    WRITER_ID=? ," + 
				"    HIT=? ," + 
				"    FILES=? " + 
				"WHERE ID=?";
		
		String title = "TEST3";
		String writerId = "HAHAHA3";
		String hit = "500";
		String files = "PHP";
		int id = 274;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWTEST", "111111");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, hit);
		st.setString(4, files);
		st.setInt(5, id);
		
		System.out.println(st.executeUpdate());
		
		
		st.close();
		con.close();
		
	}
}
