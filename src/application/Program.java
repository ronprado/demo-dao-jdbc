package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: SellerFindId ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: SellerFindDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE 3: SellerAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE 4 : Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(0), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Incerted! New id: " + newSeller.getId());
		
		
        System.out.println("\n=== TESTE 5: Seller Update ===");
	     seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        
        System.out.println("\n=== TESTE 6: Seller Delete ===");
        System.out.println("Enter id code for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        
        sc.close();
	    }	
	}
	







		
		
	


