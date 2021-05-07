package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoJdbcTransaction {

	public static void main(String[] args) {
		Connection con=null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Scource Account No:");
			int source = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Target Account No:");
			int target = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the amount:");
			int amount = Integer.parseInt(sc.nextLine());
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","dibakar");
			con.setAutoCommit(false);
			
			PreparedStatement smt1 = con.prepareStatement("update accounts set balance=balance-? where acno=?");
			smt1.setInt(1,amount);
			smt1.setInt(2,source);
			int result1 = smt1.executeUpdate();
			
			PreparedStatement smt2 = con.prepareStatement("update accounts set balance=balance+? where acno=?");
			smt2.setInt(1,amount);
			smt2.setInt(2,target);
			int result2 = smt2.executeUpdate();
			
		    if(result1!=0 && result2!=0) {
		    	con.commit();
		    	System.out.println("Money transfered");
		    }
		    else {
		    	con.rollback();
		    	System.out.println("Sorry! Transactions failed");
		    }
		    
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
