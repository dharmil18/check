package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public App() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/dcode", "system", "Tat1$pet");
			st = con.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getEmployees() {
		try {
			rs = st.executeQuery("SELECT * FROM emp_new");
//			rs = st.executeQuery("SELECT employee_id, first_name FROM hr.employees");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
