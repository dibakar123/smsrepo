package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Id:");
			int empId = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Employee Name:");
			String empName = sc.nextLine();
			System.out.println("Enter Employee Salary:");
			int salary = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Employee Designation:");
			String empDesignation = sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("insert into employee values (?, ?, ? ,?)");
			smt.setInt(1,empId);
			smt.setString(2, empName);
			smt.setInt(3,salary);
			smt.setString(4,empDesignation);
			int result = smt.executeUpdate();
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
				sc.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
