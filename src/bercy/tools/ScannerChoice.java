package bercy.tools;

import java.util.Scanner;

import bercy.page.GoodsPage;
import bercy.page.MainPage;
import bercy.page.SalesManPage;


public class ScannerChoice {

	/**
	 * get String from keyboard
	 * 
	 * @return
	 */
	public static String ScannerInfoString() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter:");
		return sc.next();
	}

	/**
	 * get double from keyboard
	 */
	public static double ScannerInfoDouble() {
		double num = 0.00;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Keep two decimal:");
			String info = sc.next();

			String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|([0]\\.([0-9]{2}))";
			if (info.matches(regex)) {

				num = Double.parseDouble(info);

			} else {
				System.err.println("----Error----");
				continue;
			}

			break;
		} while (true);
		return num;
	}

	/**
	 * get amount from keyboard
	 *
	 */
	public static int ScannerNum() {
		int num = 0;
		String regex = "([1-9])|([1-9][0-9]+)";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter amount: ");
			String nums = sc.next();
			
			if(nums.matches(regex)) {
				
				num = Integer.parseInt(nums);
				
			}else {
				System.err.println("----Error----");
				continue;
			}
			
			
			break;
		} while (true);

		return num;
	}
	
	/**
	 * next step for add/change/delete/query/ on goods relate pages
	 */
	public static void changedInfoNext(String oper) {
		do {
		System.out.println("Continue:(Y/N)");
		String choice = ScannerChoice.ScannerInfoString();
		
		if("y".equals(choice)||"Y".equals(choice)) {
			if("upateGoodsPage".equals(oper)) {
				 GoodsPage.updateGoodsPage();
			}else if("addGoodsPage".equals(oper)) {
				GoodsPage.addGoodsPage();
			}else if("deleteGoodsPage".equals(oper)) {
				GoodsPage.deleteGoodsPage();
			}
		}else if ("n".equals(choice)||"N".equals(choice)) {
			MainPage.maintenancePage();
		}
		
		System.out.println("Error!!!!");
		}while(true);
	}
	
	
	/**
	 * the the next step for add/change/delete/query/ on salesman relate pages
	 * 
	 * @param oper
	 */
	public static void choiceSalesManNext(String oper) {
		do {
			System.out.println("Continue or Stop:(Y/N)");
			String choice = ScannerInfoString();
			if ("y".equals(choice) || "Y".equals(choice)) {
				// based on different oper choice different page to go next
				if ("addSalesManPage".equals(oper)) {
					SalesManPage.addSalesmanPage();
				} else if ("updateSalesManPage".equals(oper)) {
					SalesManPage.updateSalesManPage();
				} else if ("deleteSalesManPage".equals(oper)) {
					SalesManPage.deleteSalesManPage();
				} else if ("querySalesManPage".equals(oper)) {
					SalesManPage.querySalesManPage();
				} else if ("displaySalesManPage".equals(oper)) {
					SalesManPage.displaySalesManPage();
				}

			} else if ("N".equals(choice) || "n".equals(choice)) {
				MainPage.salesManManagementPage();
			}
			System.out.println("\tWrong operation");
		} while (true);
	}
}
