package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDeleteUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Id for remove:::::::::");
			int empId = Integer.parseInt(sc.nextLine());
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("delete from  employee where eno=?");
			smt.setInt(1,empId);
			int result = smt.executeUpdate();
		    if(result==0) {
		    	System.out.println("Data Not Deleted");
		    }
		    else {
		    	System.out.println("Data is deleted successfully");
		    }
		    
		} catch (Exception e) {
			System.out.println("Data is not deleted successfully");
			e.printStackTrace();
		}
		finally {
			try {
				sc.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
