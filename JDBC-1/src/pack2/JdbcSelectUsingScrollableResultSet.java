package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectUsingScrollableResultSet {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			PreparedStatement smt = con.prepareStatement("select * from employee", ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
			ResultSet result = smt.executeQuery();
			
			result.absolute(2);
			int empId= result.getInt(1);
			String empName = result.getString("ename");
			int empSalary = result.getInt("esal");
			String empDesignation = result.getString(4);
			System.out.println("2nd Row: "+ empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			
			result.relative(2);
			empId= result.getInt(1);
			empName = result.getString("ename");
			empSalary = result.getInt("esal");
			empDesignation = result.getString(4);
			System.out.println("4th Row: "+ empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			
			result.relative(-1);
			empId= result.getInt(1);
			empName = result.getString("ename");
			empSalary = result.getInt("esal");
			empDesignation = result.getString(4);
			System.out.println("3rd Row: "+ empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			
			
			result.last();
			empId= result.getInt(1);
			empName = result.getString("ename");
			empSalary = result.getInt("esal");
			empDesignation = result.getString(4);
			System.out.println("Last Row: "+ empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			
			result.first();
			empId= result.getInt(1);
			empName = result.getString("ename");
			empSalary = result.getInt("esal");
			empDesignation = result.getString(4);
			System.out.println("1st Row: "+ empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			
			
			
		    
		} catch (Exception e) {
			System.out.println("Data read error......");
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
