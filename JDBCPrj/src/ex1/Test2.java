package ex1;

import java.sql.*;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "Delete from notice where id=?";
		
		int id = 273;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"NEWTEST","111111");
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		System.out.println("성공");
		
		ps.close();
		con.close();

	}

}
