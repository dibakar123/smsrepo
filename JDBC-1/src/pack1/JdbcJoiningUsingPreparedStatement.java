package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcJoiningUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Department Name to search:");
			String deptName = sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("select e.* , d.* from employee e inner join dept d where e.deptno = d.dno and d.dname=?");
			smt.setString(1, deptName);
			ResultSet result = smt.executeQuery();
			boolean flag = false;
			while( result.next()) {
				flag=true;
				int empId= result.getInt(1);
				String empName = result.getString(2);
				int empSalary = result.getInt(3);
				String empDesignation = result.getString(4);
				int deptNo = result.getInt(5);
				String dname = result.getString(7);
				String dloc = result.getString(8);
				System.out.println(empId +" "+ empName +" "+ empSalary + " " + empDesignation+" "+deptNo+ " " + dname+ " "+ dloc);
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
