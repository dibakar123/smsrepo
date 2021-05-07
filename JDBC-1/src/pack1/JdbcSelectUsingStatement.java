package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectUsingStatement {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			Statement smt = con.createStatement();
			ResultSet result = smt.executeQuery("select * from employee");
			boolean flag = false;
			//while( result.next()) {
				flag=true;
				int empId= result.getInt(1);
				String empName = result.getString("ename");
				int empSalary = result.getInt("esal");
				String empDesignation = result.getString(4);
				System.out.println(empId +" "+ empName +" "+ empSalary + " " + empDesignation);
			//}
		    if(flag==false)
		    	System.out.println("Sorry! There is no data.....");
		
		    
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
