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
		
		if(salesManList.size()<=0) {
			System.out.println("\t!!No this person: "+sName);
			choiceSalesManNext("updateSalesManPage");
		}else {
			System.out.println("\t\t\tSalesman Information\n\n");
			System.out.println("\t\tID\t\tName\t\tPassword");
			
			SalesMan salesman = salesManList.get(0);
			System.out.println("\t"+salesman.getsId()+"\t\t\t"+salesman.getsName()()+"\t\t\t"+salesman.getsPassword());
			System.out.println();
			
			System.out.println("\n--------Which you want to change?\n");
			System.out.println("\t1.Change Name");
			System.out.println("\t2.Change password");
			
			do {
				String choice = ScannerInfoString();
				String regex = "[0-2]";
				if(choice.matches(regex)) {
					int info = Integer.parseInt(choice);
					switch(info) {
					case 0:
						MainPage.salesManManagementPage();
						break;
					case 1:
						
					break;
					case 2:
						break;
					default:
						break;
					}
				
				
				}
				
				
			}while(true);
			
		}
		
		
		
		
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
