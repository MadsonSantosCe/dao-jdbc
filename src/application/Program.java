package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			st = conn.createStatement();
			
			Department obj = new Department(1, "books");
			Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);
			SellerDao sellerDao = DaoFactory.createSellerDao();
			
			System.out.println(seller);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}