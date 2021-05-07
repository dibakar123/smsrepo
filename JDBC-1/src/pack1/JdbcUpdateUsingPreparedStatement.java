package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcUpdateUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Employee Id to update:");
			int empId = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter New Employee Name:");
			String empName = sc.nextLine();
			System.out.println("Enter New Employee Salary:");
			int salary = Integer.parseInt(sc.nextLine());
			System.out.println("Enter New Employee Designation:");
			String empDesignation = sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("update employee set ename=? , esal=? , designation=? where eno=?");
			smt.setString(1,empName);
			smt.setInt(2,salary);
			smt.setString(3, empDesignation);
			smt.setInt(4, empId);
			int result = smt.executeUpdate();
			
		    if(result==0)
		    	System.out.println("Sorry! There is no update.....");
		    else
		    	System.out.println("Record is successfully updated");
		
		    
		} catch (Exception e) {
			System.out.println("Data update error......");
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
