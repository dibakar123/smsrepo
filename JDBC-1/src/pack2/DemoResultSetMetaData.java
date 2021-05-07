package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;




public class DemoResultSetMetaData {

	public static void main(String[] args) {
		Connection con=null;
		
		try {
						
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			con.setAutoCommit(false);
			
			PreparedStatement smt = con.prepareStatement("select * from accounts");
			ResultSet results =  smt.executeQuery();
			
			ResultSetMetaData rsMetaData = results.getMetaData();
			System.out.println("Table Name:"+rsMetaData.getTableName(1));
			
			int totalColoumns = rsMetaData.getColumnCount();
			System.out.println("Total Columns :"+totalColoumns);
			
			for(int i=1; i<=totalColoumns ; i++) {
				System.out.println("Column:"+i+"  Name:"+rsMetaData.getColumnName(i) +"  Type:"+rsMetaData.getColumnType(i) +" TypeName:"+ rsMetaData.getColumnTypeName(i));
			}
			
			
		    
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
