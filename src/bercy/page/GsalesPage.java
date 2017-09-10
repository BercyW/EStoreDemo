package bercy.page;

import java.util.ArrayList;

import bercy.dao.GsalesDao;
import bercy.entity.Gsales;
import bercy.tools.ScannerChoice;

/**
 * show products sold on today
 * 
 * @author Bercy
 *
 */
public final class GsalesPage {

	public static void dailySaleGoodsPage() {
		System.out.println("\tSearching the databases \n");
		ArrayList<Gsales> gSalesList = new GsalesDao().dailyGsales();
		int gSalesListSize = gSalesList.size();
		if (gSalesList.size() <= 0) {
			System.out.println("------Nothing sold today------");
			MainPage.commodityManagementPage();
		} else {
			System.out.println("\t\t\t\tProducts sold today\n");
			System.out.println("\tItem Name\t\tItem Price\t\tItem Amount\t\tSold\t\tComment\n");
			for (int i = 0; i < gSalesListSize; i++) {
				Gsales gSales = gSalesList.get(i);
				System.out.print("\t"+gSales.getgName()+"\t\t"+gSales.getgPrice()+" $\t\t"+gSales.getgNum()+"\t\t"+gSales.getAllSnum());
				
				int gLeft = gSales.getgNum();
				if(gLeft == 0) {
					System.out.println("\t\tItem has sold out");
				}else if(gLeft<=10) {
					System.out.println("\t\tItems are less than 10");
				} else {
					System.out.println("\t\t-");
				}
				  System.out.println("\t");
			}
			do {
				System.out.println("\n\nType 0 to go back last page");
				String choice = ScannerChoice.ScannerInfoString();
				if("0".equals(choice)) {
					MainPage.commodityManagementPage();
				}
				MainPage.commodityManagementPage();
			}while(true);
		}

	}
}
