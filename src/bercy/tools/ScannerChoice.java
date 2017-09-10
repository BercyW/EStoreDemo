package bercy.tools;

import java.util.Scanner;

import bercy.page.SalesManPage;

public class ScannerChoice {

	/**
	 * get keyboard type in number
	 * 
	 * @return
	 */
	public static String ScannerInfoString() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter:");
		return sc.next();
	}

	/**
	 * the the next step for add/change/delete/query/
	 * 
	 * @param oper
	 */
	public static void choiceSalesManNext(String oper) {
		do {
			System.out.println("Continue or Stop:(Y/N)");
			String choice = ScannerInfoString();
			if("y".equals(choice)||"Y".equals(choice)) {
				//based on different oper choice different page to go next
				if("addSalesManPage".equals(oper)) {
					SalesManPage.addSalesmanPage();
				}else if ("updateSalesManPage".equals(oper)) {
					SalesManPage.updateSalesManPage();
				}
				
				
				
			}
			
			
			

		} while (true);
	}
}
