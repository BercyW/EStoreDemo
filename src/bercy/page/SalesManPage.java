package bercy.page;

import java.util.ArrayList;

import bercy.dao.SalesManDao;
import bercy.entity.SalesMan;
import bercy.tools.QueryPrint;
import bercy.tools.ScannerChoice;

/**
 * salesman managerment page
 * 
 * @author Bercy
 *
 */
public final class SalesManPage extends ScannerChoice {
	/**
	 * 1.add salesman
	 */
	public static void addSalesmanPage() {
		System.out.println("\tOperating insert salesman\n");
		System.out.println("\n Add Salesman -- Name");
		String sName = ScannerInfoString();

		System.out.println("\n Add Salesman -- Password");
		String sPassword = ScannerInfoString();

		SalesMan salesman = new SalesMan(sName, sPassword);
		boolean bool = new SalesManDao().addSalesman(salesman);
		if (bool) {
			System.out.println("\n\t!Succeed!!");
		} else {
			System.out.println("Failed");
		}
		choiceSalesManNext("addSalesManPage");
	}

	/**
	 * 2.update salesman
	 */
	public static void updateSalesManPage() {

		System.out.println("\tUpdating salesman!!\n");
		System.out.println("Enter salesman's name");
		String sName = ScannerInfoString();
		ArrayList<SalesMan> salesManList = new QueryPrint().querySalesMan(sName);

		if (salesManList.size() <= 0) {
			System.out.println("\t!!No this person: " + sName);
			choiceSalesManNext("updateSalesManPage");
		} else {
			System.out.println("\t\t\tSalesman Information\n\n");
			System.out.println("\t\tID\t\tName\t\tPassword");

			SalesMan salesman = salesManList.get(0);
			System.out.println(
					"\t" + salesman.getsId() + "\t\t\t" + salesman.getsName() + "\t\t\t" + salesman.getsPassword());
			System.out.println();

			System.out.println("\n--------Which you want to change?\n");
			System.out.println("\t1.Change Name");
			System.out.println("\t2.Change password");

			do {
				String choice = ScannerInfoString();
				String regex = "[0-2]";
				if (choice.matches(regex)) {
					int info = Integer.parseInt(choice);
					switch (info) {
					case 0:
						MainPage.salesManManagementPage();
						break;
					case 1:
						System.out.println("Enter----New Name");
						String sNewName = ScannerInfoString();
						SalesMan salemanName = new SalesMan(salesman.getsId(), sNewName, null);
						boolean boolName = new SalesManDao().updataSalesman(1, salemanName);
						if (boolName) {
							System.out.println("\n\t!!SUCCESS!!!\n");
						} else {
							System.out.println("\n\t!!FAILED!!\n");
						}

						choiceSalesManNext("updateSalesMan");
						break;
					case 2:
						System.out.println("Enter----New Password");
						String newPassword = ScannerInfoString();
						SalesMan salemanPassword = new SalesMan(salesman.getsId(), null, newPassword);
						boolean boolPassword = new SalesManDao().updataSalesman(2, salemanPassword);
						if (boolPassword) {
							System.out.println("\n\t!!SUCCESS!!!\n");
						} else {
							System.out.println("\n\t!!FAILED!!\n");
						}
						choiceSalesManNext("updateSalesMan");
						break;
					default:
						break;
					}
				}
				System.out.println("\tError!!!");
				System.out.println("\tChoose one,or 0 go back!!");
			} while (true);
		}
	}

	/**
	 * 3.delete salesman
	 */

	public static void deleteSalesManPage() {
		System.out.println("\tDeleting Salesman Info!!\n");
		System.out.println("Enter Salesman Name:");
		String sName = ScannerInfoString();

		ArrayList<SalesMan> salesmanList = new QueryPrint().querySalesMan(sName);
		if (salesmanList.size() <= 0) {
			System.out.println("\t!!Can not find person name: " + sName);
			choiceSalesManNext("deleteSalesMan");
		} else {
			System.out.println("\t\t\tSalesman Info!n\n");
			System.out.println("\t\tID\t\tName\t\tPassword");
			SalesMan deleteSalesman = salesmanList.get(0);
			System.out.println("\t" + deleteSalesman.getsId() + "\t\t\t" + deleteSalesman.getsName() + "\t\t\t"
					+ deleteSalesman.getsPassword());
			System.out.println();
		}
		do {
			System.out.println("\nConfirm to delete：Y/N");
			String choice = ScannerInfoString();
			if ("y".equals(choice) || "Y".equals(choice)) {
				boolean bool = new SalesManDao().deleteSalesMan(sName);
				if (bool) {
					System.out.println("\t!!Delete succeed!!");
				} else {
					System.out.println("\t!!Delete Failed!!");
				}
				choiceSalesManNext("deleteSalesManPage");
			} else if ("n".equals(choice) || "N".equals(choice)) {
				MainPage.salesManManagementPage();
			}
			System.out.println("Error!!Enter again!!");
		} while (true);

	}

	/**
	 * 4.query salesman
	 */
	public static void querySalesManPage() {
		System.out.println("\tSearching salesman!!\n");
		System.out.println("Enter salesman's name");
		String sName = ScannerInfoString();
		ArrayList<SalesMan> salesManList = new QueryPrint().querySalesMan(sName);

		if (salesManList.size() <= 0) {
			System.out.println("\t!!No this person: " + sName);
			choiceSalesManNext("querySalesManPage");
		} else {
			System.out.println("\t\t\tSalesman Information\n\n");
			System.out.println("\t\tID\t\tName\t\tPassword");

			SalesMan salesman = salesManList.get(0);
			System.out.println(
					"\t" + salesman.getsId() + "\t\t\t" + salesman.getsName() + "\t\t\t" + salesman.getsPassword());
			System.out.println();
		}
		choiceSalesManNext("querySalesMan");
	}

	/**
	 * 5.show all
	 */
	public static void displaySalesManPage() {

		ArrayList<SalesMan> salesManList = new SalesManDao().displaySalesman();

		if (salesManList.size() <= 0) {
			System.out.println("\t!!Empty!!");
			MainPage.salesManManagementPage();
		} else {
			System.out.println("\t\t\tAll Salesman\n\n");
			System.out.println("\tID\t\tName\t\tPassword");
			int size = salesManList.size();
			for (int i = 0; i < size; i++) {
				SalesMan sm = salesManList.get(i);
				System.out.println("\t" + sm.getsId() + "\t\t\t" + sm.getsName() + "\t\t\t" + sm.getsPassword());
				System.out.println();
			}

		}
		do {
			System.out.println("\n\nEnter 0 to go back!!");
			String choice = ScannerInfoString();

			if ("0".equals(choice)) {
				MainPage.salesManManagementPage();
			}
			System.err.print("\tError！");
		} while (true);

	}

}
