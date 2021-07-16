package ex1;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO NOTICE( "+
			"    TITLE,"+
			"    WRITER_ID,"+
			"    CONTENT,"+
			"    HIT,"+
			"    FILES"+
			") VALUES (?,?,?,?,?)";
		
		String title = "TEST";
		String writerId = "Kim";
		String Content = "555";
		String hit = "200";
		String files = "CSS";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWTEST", "111111");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, Content);
		st.setString(4, hit);
		st.setString(5, files);
		
		System.out.println(st.executeUpdate());
		
		
		st.close();
		con.close();

	}
}
