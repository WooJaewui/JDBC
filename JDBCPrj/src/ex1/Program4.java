package ex1;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM NOTICE WHERE ID=?"; 
		
		int id = 274;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWTEST", "111111");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, id);
		
		
		System.out.println(st.executeUpdate());
		
		
		st.close();
		con.close();
		
	}
}
