package MySQL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://3.88.236.96:3306/ecommerce", "root", "root");
		
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}
		
		System.out.println("==========================Insert================================");
		
		stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Television', 1500.00, now())");
		result = stmt.executeQuery("select * from eproduct");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}
		
		System.out.println("================ Delete ==================================");
		
		stmt.executeUpdate("delete from eproduct where name='Television';");
		
		result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}
		System.out.println("================ Update ==================================");
		
		stmt.executeUpdate("update eproduct set price=6000.00 where name='Mobile'");
		
		result = stmt.executeQuery("select * from eproduct;");
		
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}
		con.close();
	}
}
