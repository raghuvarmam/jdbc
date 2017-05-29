package jdbcdemos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableEx {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con= getConnection();
		
		CallableStatement cs= con.prepareCall("{call insertstudent(?,?)}");
		cs.setInt(1, 11);
		cs.setString(2,"pawan");
		boolean b= cs.execute("select * from student");
		System.out.println("getting details");
		if(b){
			ResultSet rs= cs.getResultSet();
			while (rs.next()){
				System.out.println("rnum is "+rs.getInt(1)+" sname is "+ rs.getString(2));
			}
		}else{
			int count=cs.getUpdateCount();
			System.out.println("rows affected are "+count);
		}		
		
		con.close();

	}
	
	public static Connection getConnection()  throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raghu", "root", "syamsiva");
		
		return con;
	}

}
