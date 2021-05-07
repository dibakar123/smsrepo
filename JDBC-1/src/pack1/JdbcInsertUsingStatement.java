package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertUsingStatement {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			Statement smt = con.createStatement();
			int result = smt.executeUpdate("insert into employee values (100,'Raja Dey',12000, 'Genc')");
		    if(result==0)
		    	System.out.println("Data Not Added");
		    else
		    	System.out.println("Data is added successfully");
		    
		} catch (Exception e) {
			System.out.println("Data is added successfully");
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
