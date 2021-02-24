import java.sql.Connection;
import java.util.Scanner;
import java.util.Scanner;
import java.sql.SQLException;

public class SQLMain {
	
Scanner input = new Scanner(System.in);

	Role r = new Role();
	User admin = new User(1, "Alba", "Merdani", "femer", "alba@example.com", "069 xxxx xxx", "Elbasan", "albamerdani", "admin", r);
	
	CompanyDAO compDAO = new CompanyDAO();
	DepartmentDAO depDAO = new DepartmentDAO();
	SectorDAO sectDAO = new SectorDAO();
	ShopDAO shopDAO = new ShopDAO();
	BrandDAO brandDAO = new BrandDAO();
	UserDAO userDAO = new UserDAO();
	RoleDAO roleDAO = new RoleDAO();
	CountryDAO countryDAO = new CountryDAO();
	
	
	
	public void menu(String choose) throws SQLException{

		switch(choose) {
		case "1":
			compDAO.insertCompany();			//funksionon
			break;
			
		case "2":
			System.out.println("\nPut a number for the id of the company that you want to edit data: ");
			int idComp = input.nextInt();
			compDAO.editCompany(idComp);		//funksionon
			break;
			
		case "3":
			compDAO.showCompany();
			break;
			
		case "4":
			compDAO.deleteCompany();			//funksionon
			break;
			
		case "5":
			compDAO.listCompany();				//funksionon
			break;
			
		case "6":
			depDAO.insertDep();			//funksionon  ?
			break;
			
		case "7":
			System.out.println("\nPut a number for the id of the  department that you want to edit:");
			int idDep = input.nextInt();
			depDAO.editDep(idDep);				//funksionon
			break;
			
		case "8":
			depDAO.deleteDep();					//funksionon
			break;
			
		case "9":
			depDAO.listDep();					//funksionon
			break;
			
		case "0":
			depDAO.showDep();
			break;
			
		case "a":
			sectDAO.insertSector();			//funksionon  ?
			break;
			
		case "b":
			System.out.println("\nPut a number for the id of the sector that you want to edit:");
			int idSector = input.nextInt();
			sectDAO.editSector(idSector);		//funksionon
			break;
			
		case "c":
			sectDAO.listSector();				//funksionon
			break;
			
		case "d":
			sectDAO.showSector();
			break;
			
		case "e":
			sectDAO.deleteSector();				//funksionon
			break;
			
		case "f":
			shopDAO.insertShop();			//funksionon  ?
			break;
		
		case "g":
			System.out.println("\nPut a number for the id of the shop that you want to edit:");
			int idShop = input.nextInt();
			shopDAO.editShop(idShop);			//funksionon
			break;
			
		case "h":
			shopDAO.listShop();					//funksionon
			break;
			
		case "i":
			shopDAO.showShop();
			break;
			
		case "j":
			shopDAO.deleteShop();				//funksionon
			break;
			
		case "k":
			brandDAO.insertBrand();			//funksionon  ?
			break;
			
		case "l":
			System.out.println("\nPut a number for the id of the brand that you want to edit:");
			int idBrand = input.nextInt();
			brandDAO.editBrand(idBrand);		//funksionon
			break;
			
		case "m":
			brandDAO.listBrand();				//funksionon
			break;
			
		case "n":
			brandDAO.showBrand();
			break;
			
		case "o":
			brandDAO.deleteBrand();				//funksionon
			break;
			
		case "p":
			userDAO.insertUser();
			break;
			
		case "q":
			System.out.println("\nPut a number for the id of the user that you want to edit");
			int idUser = input.nextInt();
			userDAO.editUser(idUser);			//funksionon
			break;
			
		case "r":
			userDAO.deleteUser();				//funksionon
			break;
			
		case "s":
			userDAO.listUser();
			break;
			
		case "t":
			userDAO.showUser();		
			break;
			
		case "u":
			roleDAO.insertRole();				//funksionon
			break;
			
		case "v":
			roleDAO.listRole();					//funksionon
			break;
			
		case "y":
			countryDAO.insertCountry();			//funksionon
			break;
			
		case "z":
			countryDAO.listCountry();			//funksionon
			break;
		
		case "x":
			System.out.println("\n\nYou closed the program system! GOOD BYE!!");
			System.exit(0);
			break;
			
		default: 
			System.out.println("\nThis is not an option to choose! Please choose a correct option: ");
			choose = input.next();
			menu(choose);
			break;
		}
	}
		
		
	public void chooseAgain(String again) throws SQLException{
		if(again.equals("y") || again.equals("Y")) {
			System.out.println("\nChoose an option from the menu: ");
			String option = input.next();
			menu(option);
		}
		else if(again.equals("n") || again.equals("N")) {
			System.out.println("\nYou have not choosed any option again. Good BYE!");
			System.exit(0);
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			System.out.println("\nDo you want to choose again another option? Type 'y/Y' for Yes or 'n/N' for No: ");
			again = input.next();
			
			chooseAgain(again);
		}
	}
		

	public static void main(String[] args) throws SQLException{

		Scanner in = new Scanner(System.in);
	
		ConnectionDB con = new ConnectionDB();
		Connection lidhje = con.connect();
		
		System.out.println("Welcome\n");
		System.out.println("\tMenu");
		System.out.println("Press:");

		System.out.println(" 1 - to add a company in the list.");
		System.out.println(" 2 - to edit data of a company.");
		System.out.println(" 3 - to show the details of the company.");
		System.out.println(" 4 - to delete a company from the list.");
		System.out.println(" 5 - to list companies.");
		System.out.println(" 6 - to add a department in the list.");
		System.out.println(" 7 - to edit data of a department");
		System.out.println(" 8 - to delete a department from the list of a company.");
		System.out.println(" 9 - to list departments.");
		System.out.println(" 0 - to show the details of a department.");
		System.out.println(" a - to add a sector in the list.");
		System.out.println(" b - to edit data of a sector");
		System.out.println(" c - to list sectors.");
		System.out.println(" d - to show the details of a sector.");
		System.out.println(" e - to delete a sector from the list of a department.");
		System.out.println(" f - to add a shop in the list.");
		System.out.println(" g - to edit data of a shop");
		System.out.println(" h - to list shops.");
		System.out.println(" i - to show the details of a shop.");
		System.out.println(" j - to delete a shop from the list of a sector.");
		System.out.println(" k - to add a brand in the list.");
		System.out.println(" l - to edit data of a brand");
		System.out.println(" m - to list brands.");
		System.out.println(" n - to show the details of a brand.");
		System.out.println(" o - to delete a brand from the list of a shop.");
		System.out.println(" p - to add an user.");
		System.out.println(" q - to edit an user.");
		System.out.println(" r - to delete an user.");
		System.out.println(" s - to list details of all users.");
		System.out.println(" t - to show data of an user.");
		System.out.println(" u - to add a role.");
		System.out.println(" v - to list roles.");
		System.out.println(" y - to add a country.");
		System.out.println(" z - to list countries.");
		System.out.println(" x - to close the program and to exit.");
		
		SQLMain menu = new SQLMain();
		
		System.out.println("\n\tChoose an option from the menu: ");
		String choose = in.next();
		
		menu.menu(choose);
		
		while(true) {
			System.out.println("\nDo you want to choose another option from the menu? Type 'y/Y' for Yes or 'n/N' for No: ");
			String again = in.next();
		
			menu.chooseAgain(again);
		}
	}

}
