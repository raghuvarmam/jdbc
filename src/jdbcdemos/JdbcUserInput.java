package jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUserInput {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu","root","syamsiva");
		//java.sql.Statement stmt = con.createStatement();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your id: ");
		String id = scanner.nextLine();
		System.out.print("Enter your  name: ");
		String name = scanner.nextLine();
//		System.out.print("Enter your marks: ");
//		String marks = scanner.nextLine();
		String sql = "insert into student "+ " (id, name)" + " values (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		((PreparedStatement)stmt).setString(1, id);
		((PreparedStatement)stmt).setString(2, name);
		
		int c=stmt.executeUpdate();
		System.out.println("rows affected "+c );
		con.close();
	}
}
