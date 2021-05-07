package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessUsingStatement {

	public static void main(String[] args) {
		Connection con=null;
		int result[]=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			Statement smt = con.createStatement();
			smt.addBatch("insert into employee values (22,'Raja Dey',12000, 'Genc',10)");
			smt.addBatch("insert into employee values (22,'Raja Dey',12000, 'Genc',10)");
			smt.addBatch("insert into employee values (32,'Raja Dey',12000, 'Genc',20)");
			smt.addBatch("insert into employee values (42,'Raja Dey',12000, 'Genc',20)");
			result = smt.executeBatch();
			
		    
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
