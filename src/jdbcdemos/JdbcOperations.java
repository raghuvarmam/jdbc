package jdbcdemos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JdbcOperations {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu","root","syamsiva");
		java.sql.Statement stmt = con.createStatement();
		
		
//		
//		int rs = stmt.executeUpdate("create table employee(id INT , name VARCHAR(20), sal INT)");
//		System.out.println("Table created");
//		
//		int count = stmt.executeUpdate("INSERT INTO employee VALUES(1, 'sri', 1000) ");
//		System.out.println(count + "row inserted");
//		int count1 = stmt.executeUpdate("INSERT INTO employee VALUES(2, 'rag', 5000) ");
//		System.out.println(count1 + "row inserted");
//		ResultSet rs1 = stmt.executeQuery("select * from employee");
//		while(rs1.next()){
//			System.out.println(rs1.getInt(1)+" " + rs1.getString(2)+" "+rs1.getInt(3));
//		}
		int count2 = stmt.executeUpdate("UPDATE employee SET sal=4000 WHERE id = 2");
		System.out.println(count2 + "row updated");
		ResultSet rs2 = stmt.executeQuery("select * from employee");
		while(rs2.next()){
			System.out.println(rs2.getInt(1)+" " + rs2.getString(2)+" "+rs2.getInt(3));
		}
		int count3 = stmt.executeUpdate("DELETE FROM employee  WHERE id = 1");
		System.out.println(count3 + "row deleted");
		ResultSet rs3 = stmt.executeQuery("select * from employee");
		while(rs3.next()){
			System.out.println(rs3.getInt(1)+" " + rs3.getString(2)+" "+rs3.getInt(3));
		}
		int count4 = stmt.executeUpdate("ALTER TABLE employee  ADD rank int");
		System.out.println(count4 + "column added");
		ResultSet rs4 = stmt.executeQuery("select * from employee");
		while(rs4.next()){
			System.out.println(rs4.getInt(1)+" " + rs4.getString(2)+" "+rs4.getInt(3));
		}
		int count5 = stmt.executeUpdate("UPDATE employee SET rank = 1 WHERE id = 2");
		System.out.println(count5 + "row updated");
		ResultSet rs5 = stmt.executeQuery("select * from employee");
		while(rs5.next()){
			System.out.println(rs5.getInt(1)+" " + rs5.getString(2)+" "+rs5.getInt(3)+"   "+rs5.getInt(4));
		}
		con.close();

	}

}
