package bercy.page;

import bercy.dao.SalesManDao;
import bercy.entity.SalesMan;
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

	}

	/**
	 * 3.delete salesman
	 */

	public static void deleteSalesManPage() {

	}

	/**
	 * 4.query salesman
	 */
	public static void querySalesManPage() {

	}

	/**
	 * 5.show all
	 */
	public static void displaySalesManPage() {

	}

}
