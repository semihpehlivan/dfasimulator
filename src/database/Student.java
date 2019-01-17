package database;
import java.sql.Connection;
import java.sql.*;
//our concrete class for user
public class Student extends User {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public Student(String ID, int Password) {
		
		super(ID,Password);
	}
	
	public Student() {
		
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE360", "root", "");
			st=con.createStatement();
					
		}catch(Exception ex) {
			
			System.out.println("Error :"+ex);
		}
	}
	
	//login function
	public boolean Login(String ID,int password)throws SQLException  {
		
		String query ="Select * from student where username=? and password=? ";
		ps=con.prepareStatement(query);
		ps.setString(1,ID);	
		ps.setInt(2,password);
		rs=ps.executeQuery();
		
				return rs.next();
				
	}
	
	public void GetInfo() {
		try {
			rs = st.executeQuery("select * from student");
			while(rs.next())
			{
				String ID= rs.getString("User_name");
				int password= rs.getInt("User_password");
				
				
				//System.out.println("User name: "  + ID + " password: " + password );
		
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
	
}