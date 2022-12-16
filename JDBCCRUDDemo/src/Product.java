import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product {

	public class product{
		
	}
	/*public void insertProduct(String name, float price, int quantity, String category) {
		try {
			//Loading /registering of driver...
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establishing connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshoppydb","root","poonam");
			
			//Statement creation
			PreparedStatement pstmt = con.prepareStatement("insert into product(p_name,p_price,p_qty,p_category) values(?,?,?,?) ");
			pstmt.setString(1, name);
			pstmt.setFloat(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, category);
			int rs = pstmt.executeUpdate();
			if(rs>0)
				System.out.println("product added successfully");
			else
				System.out.println("product failed to added");
			
			//Connection closing
			//con.close();
				
			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}*/
	public void viewProducts() {
		try {
			//Loading /registering of driver...
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshoppydb","root","poonam");
			//Statement creation
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select* from product");
			
			while(rs.next()) {
				int pid = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				int qty = rs.getInt(4);
				String category = rs.getString(5);
				System.out.println(pid+" "+name+" "+price+" "+qty+" "+category);
			}
			
			
			
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}

	public static void main(String[] args) {
		/*Scanner s=new Scanner(System.in);
		System.out.println("Enter product name:");
		String pName = s.nextLine();
		System.out.println("Enter product price:");
		float pPrice = s.nextFloat();
		System.out.println("Enter product quantity:");
		int pQuantity = s.nextInt();
		s.nextLine();
		System.out.println("Enter product category:");
		String pCategory = s.nextLine();*/
		
		Product prodObj = new Product();
		//prodObj.insertProduct(pName,pPrice,pQuantity,pCategory);
		
		
		prodObj.viewProducts();
	}
}

