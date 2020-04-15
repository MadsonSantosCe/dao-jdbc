package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Teste 01: findById da classe SellerDaoJDBC");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTeste 02: findByDepartment da classe SellerDaoJDBC");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTeste 03: findAll da classe SellerDaoJDBC");
		list = sellerDao.findAll();
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTeste 04: insert da classe SellerDaoJDBC");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}
}