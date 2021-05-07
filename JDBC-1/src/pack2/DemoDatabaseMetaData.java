package pack2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;




public class DemoDatabaseMetaData {

	public static void main(String[] args) {
		Connection con=null;
		
		try {
						
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			con.setAutoCommit(false);
			
			DatabaseMetaData dbMetaData = con.getMetaData();
			System.out.println("DB Product Name:"+dbMetaData.getDatabaseProductName());
			System.out.println("Driver Name :"+dbMetaData.getDriverName());
			System.out.println("DB Prodcut version :"+dbMetaData.getDatabaseProductVersion());
			System.out.println("DB User Name :"+dbMetaData.getUserName());
			System.out.println("JDBC URL :"+dbMetaData.getURL());
         } catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	}

}
