package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Teste 01: findById classe SellerDaoJDBC");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTeste 02: findByDepartment classe SellerDaoJDBC");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTeste 03: findAll classe SellerDaoJDBC");
		list = sellerDao.findAll();
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
	}
}