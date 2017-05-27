package jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteMethods {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu", "root", "syamsiva");

		if(con != null){
			System.out.println("Connection is succesfull");
		}

		Statement st = con.createStatement();
		//int eu=st.executeUpdate("select * from student");  //to count rows affected
		//ResultSet eq=st.executeQuery("select * from student");  //to get the entire table result set 
		boolean ex=st.execute("select * from student where rnum=1"); //
		
		if(ex){
			ResultSet rs= st.getResultSet();
			while (rs.next()){
				System.out.println("rnum is "+rs.getInt(1)+" sname is "+ rs.getString(2));
			}
		}else{
			int count=st.getUpdateCount();
			System.out.println("rows affected are "+count);
		}
		con.close();
		
	}

}
