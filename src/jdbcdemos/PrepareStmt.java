package jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrepareStmt {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/raghu", "root", "syamsiva");
		return con;
	}

	public List<Student> getStudents() throws Exception {

		Connection con = getConnection();

		List<Student> list = new ArrayList<Student>();
		// 3. Create the Statement object
		String sql = "select * from student where rnum between ? AND ?";
		PreparedStatement ps = con.prepareStatement(sql);
		// Set the values first
		ps.setInt(1, 1);
		ps.setInt(2, 6);

		// 4. Execute the Statement object
		ResultSet rs = ps.executeQuery();

		// System.out.println("SID\tCOURSE\tSNAME");
		while (rs.next()) {
			Student s = new Student();
			int value = rs.getInt(1);
			String name = rs.getString(2);

			s.setSid(value);
			s.setSname(name);
			list.add(s);
			// student.setSid(rs.getInt("rnum"));
			// student.setSname(rs.getString("sname"));
			// list.add(student);
			// ");
			System.out.println(rs.getInt("rnum") + "  " + rs.getString("sname") + "  ");
		}
		return list;
	}

}
