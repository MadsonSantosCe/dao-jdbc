package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();		
		
		//FINDBYID DEPARTMENT
		Department department = departmentDao.findById(3);	
		System.out.println(department);
		System.out.println("");
		
		//DELETE DEPARTMENT
		departmentDao.deleteById(7);
		System.out.println("Departamento deletado com sucesso");
		System.out.println("");
		
		//UPDATE DEPARTMENT
		department.setName("Toys");
		departmentDao.update(department);
		System.out.println("Departamento atualizado com sucesso");
		System.out.println("");
				
		//INSERT DEPARTMENT
		department = new Department(null, "Tools");
		departmentDao.insert(department);
		System.out.println("Departamento inserido com sucesso");
		System.out.println("");
				
		//FINDALL DEPARTMENT
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		
		for(Department dep: list) {
			System.out.println(dep);
		}		
		System.out.println("");
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//FINDBYID SELLER
		System.out.println("Teste 01: findById da classe SellerDaoJDBC");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		//FINDBYDEPARTMENT SELLER
		System.out.println("\nTeste 02: findByDepartment da classe SellerDaoJDBC");
		List<Seller> listSeller = sellerDao.findByDepartment(new Department(2, null));
		
		for (Seller obj: listSeller) {
			System.out.println(obj);
		}
		
		//FINDALL SELLER
		System.out.println("\nTeste 03: findAll da classe SellerDaoJDBC");
		listSeller = sellerDao.findAll();
		
		for (Seller obj: listSeller) {
			System.out.println(obj);
		}
		
		//INSERT SELLER
		System.out.println("\nTeste 04: insert da classe SellerDaoJDBC");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		//UPDATE SELLER
		System.out.println("\nTeste 05: update da classe SellerDaoJDBC");
		seller = sellerDao.findById(1);
		seller.setName("Martha White");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		//DELETE SELLER
		System.out.println("\nTeste 06: delete da classe SellerDaoJDBC");
		sellerDao.deleteById(22);
		System.out.println("Delete completed");
	}
}