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
		java.sql.Statement stmt = con.createStatement();		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your id: ");
		String id = scanner.nextLine();
		System.out.print("Enter your  name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your marks: ");
		String marks = scanner.nextLine();
		String sql = "insert into emp "+ " (id, name, marks)" + " values (?, ?, ?)";

		 stmt = con.prepareStatement(sql);

		// set param values
		((PreparedStatement) stmt).setString(1, id);
		((PreparedStatement) stmt).setString(2, name);
		((PreparedStatement) stmt).setString(3, marks);
		

		// 3. Execute SQL query
		ResultSet rs= stmt.executeQuery(sql);

	con.close();
		// TODO Auto-generated method stub

	}

}
