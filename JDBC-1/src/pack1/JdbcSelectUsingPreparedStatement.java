package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcSelectUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Maximum Salary limit:");
			int max = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Mininum Salary limit:");
			int min = Integer.parseInt(sc.nextLine());
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("select * from employee where esal >=? and esal<=?");
			smt.setInt(1, min);
			smt.setInt(2,max);
			ResultSet result = smt.executeQuery();
			boolean flag = false;
			while( result.next()) {
				flag=true;
				int empId= result.getInt(1);
				String empName = result.getString("ename");
				int empSalary = result.getInt("esal");
				String empDesignation = result.getString(4);
				System.out.println(empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			}
		    if(flag==false)
		    	System.out.println("Sorry! There is no data.....");
		
		    
		} catch (Exception e) {
			System.out.println("Data read error......");
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
