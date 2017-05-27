package jdbcdemos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MethodJdbc {

	public static void main(String[] args) throws Exception {
		//create();
		//insert();
		//delete();
		display();
		//retrive();
		
	/*	  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost/raghu","root","syamsiva");    
		java.sql.Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" ");  
		con.close();  
	
		
*/
		
	}
	public static void insert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");		
		Connection con = null;		
		con = DriverManager.getConnection("jdbc:mysql://localhost/raghu", "root", "syamsiva");	
		if(con != null){
			System.out.println("Connection is succesfull.");
		}
		Statement ps = con.createStatement();
		int count = ps.executeUpdate("insert into student values(3,'kiran')");
		System.out.println(count+" rows affected");		
		con.close();
		
	}
	public static void delete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");		
		Connection con = null;		
		con = DriverManager.getConnection("jdbc:mysql://localhost/raghu", "root", "syamsiva");	
		if(con != null){
			System.out.println("Connection is succesfull.");
		}
		Statement ps = con.createStatement();
		int count = ps.executeUpdate("delete from student where rnum=5");
		System.out.println(count+" rows affected");		
		con.close();				
	}
	
	public static List<Student> display() throws Exception{		
		List<Student> list = new ArrayList<Student>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu", "root", "syamsiva");
		if(con != null){
			System.out.println("Connection is succesfull");
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()){ // while(true)
			Student student = new Student();
			student.setSid(rs.getInt("rnum"));
			student.setSname(rs.getString("sname"));
			
			list.add(student);
			
			System.out.println(rs.getInt("rnum")+"  "+rs.getString("sname")+"  ");

		}
		con.close();
		return list;
	}
	public static void retrive() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu", "root", "syamsiva");
		java.sql.Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from student");
		while(rs.next()){
			System.out.println(rs.getString("sname")+" "+rs.getInt("rnum"));
		}
		con.close();
	}
	
	public static void create() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu", "root", "syamsiva");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("create table student(rnum INT , sname VARCHAR(20))");
		System.out.println("Table created");
		con.close();
		
	}
	
	

}
