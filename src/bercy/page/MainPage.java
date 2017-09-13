package bercy.page;

import java.util.ArrayList;

import bercy.dao.SalesManDao;
import bercy.entity.SalesMan;
import bercy.tools.*;

/**
 * shop main page
 * 
 * @author Bercy
 *
 */

public class MainPage extends ScannerChoice {

	public static void main(String[] args) {
		MainPage.mainPage();
	}

	public static void mainPage() {
		System.out.println("***************************\n");
		System.out.println("\t 1.Products Maintance\n");
		System.out.println("\t 2.Checkout\n");
		System.out.println("\t 3.Products Management\n");
		System.out.println("***************************");

		System.out.println("\nType number for continue, or 0 exit");

		do {

			String choice = ScannerInfoString();
			String regex = "[0-3]";

			if (choice.matches(regex)) {

				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					System.out.println("-----------------------");
					System.out.println("You have exit");
					System.exit(1);
					break;
				case 1:
					maintenancePage();
					break;
				case 2:
					checkstandLogPage();
					break;
				case 3:
					commodityManagementPage();
					break;
				default:
					break;

				}
			}
			System.out.println("Wrong number");
			System.out.println("Try Again or 0 exit");

		} while (true);
	}

	/**
	 * 1.products maintenancePage
	 */
	public static void maintenancePage() {
		System.out.println("************************************\n");
		System.out.println("\t 1.Add products\n");
		System.out.println("\t 2.Change products\n");
		System.out.println("\t 3.Delete products\n");
		System.out.println("\t 4.Search products\n");
		System.out.println("\t 5.Show all products\n");
		System.out.println("************************************\n");

		System.out.println("\nType number for continue, or 0 exit");

		do {

			String choice = ScannerInfoString();
			String regex = "[0-5]";

			if (choice.matches(regex)) {

				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					mainPage();
					break;
				case 1:
					GoodsPage.addGoodsPage();
					break;
				case 2:
					GoodsPage.updateGoodsPage();
					break;
				case 3:
					GoodsPage.deleteGoodsPage();
					break;
				case 4:
					GoodsPage.queryGoodsPage();
					break;
				case 5:
					GoodsPage.displayGoodsPage();
					break;
				default:
					break;

				}
			}
			System.out.println("Wrong number");
			System.out.println("Try Again or 0 exit");

		} while (true);

	}

	/**
	 * 2.font checkout page
	 */
	public static void checkstandLogPage() {
		System.out.println("\n*******Welcome to checkout page*******\n");
		System.out.println("\t 1.Login\n");
		System.out.println("\t 2.exit\n");
		System.out.println("-----------------------------");
		System.out.println("\nType number for continue, or 0 exit");

		do {

			String choice = ScannerInfoString();
			String regex = "[0-2]";

			if (choice.matches(regex)) {

				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					mainPage();
					break;
				case 1:
					int loginTimes = 3;
					while (loginTimes != 0) {
						loginTimes--;
						System.out.println("----User Name----");
						String userName = ScannerInfoString();
						System.out.println("----Password----");
						String password = ScannerInfoString();

						ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(userName);

						if (salesManInfo == null || salesManInfo.size() == 0) {
							System.out.println("\t!!Wrong user name!!\n");
							System.out.println("\n!!Left login times:" + loginTimes);
						} else {
							SalesMan salesMan = salesManInfo.get(0);
							if (password.equals(salesMan.getsPassword())) { // password
																			// success
								System.out.println("\t---Login Sucess---");
								shoppingSettlementPage(salesMan.getsId());
							} else {
								System.out.println("\t!!Wrong Password!!\n");
								System.out.println("\n!!Left login times:" + loginTimes);
							}

						}
					}
					System.out.println("---------------------------------------");
					System.out.println("\t!!You have been kicked out!!");
					System.exit(1);
					break;
				case 2:
					System.out.println("---------------------------------------");
					System.out.println("\t!!You have exited!!");
					System.exit(-1);
					break;

				default:
					break;

				}
			}
			System.out.println("Wrong number");
			System.out.println("Try Again or 0 exit");

		} while (true);

	}

	/**
	 * 3.products management page
	 */
	public static void commodityManagementPage() {
		System.out.println("***************************\n");
		System.out.println("\t 1.SalsMan Management!\n");
		System.out.println("\t 2.Show all products sold today!\n");
		System.out.println("***************************");

		System.out.println("\nType number for continue, or 0 exit");
		do {

			String choice = ScannerInfoString();
			String regex = "[0-2]";

			if (choice.matches(regex)) {

				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					mainPage();
					break;
				case 1:
					salesManManagementPage();
					break;
				case 2:
					GsalesPage.dailySaleGoodsPage();
					break;

				default:
					break;

				}
			}
			System.out.println("Wrong number");
			System.out.println("Try Again or 0 exit");

		} while (true);

	}

	/**
	 * checkout Page
	 * 
	 * @param getsId
	 */
	private static void shoppingSettlementPage(int getsId) {
		
	}

	/**
	 *SalsMan Management
	 */
	public static void salesManManagementPage() {
		System.out.println("***************************\n");
		System.out.println("\t 1.Add Salesman\n");
		System.out.println("\t 2.Update Salesman\n");
		System.out.println("\t 3.Delete Salesman\n");
		System.out.println("\t 4.Query Salesman\n");
		System.out.println("\t 5.Show all SalesMan\n");
		System.out.println("***************************");

		System.out.println("\nPlease choose one, or 0 go back");

		do {
			String choice = ScannerInfoString();
			String regex = "[0-5]";
			if (choice.matches(regex)) {
				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					commodityManagementPage();
					break;
				case 1:					
					SalesManPage.addSalesmanPage();
					break;
				case 2:
					SalesManPage.updateSalesManPage();
					break;
				case 3:
					SalesManPage.deleteSalesManPage();
					break;
				case 4:
					SalesManPage.querySalesManPage();
					break;
				case 5:
					SalesManPage.displaySalesManPage();
					break;
				default:
					break;

				}

			}
			System.out.println("Wrong number");
			System.out.println("Try Again or 0 exit");
		} while (true);

	}
}
