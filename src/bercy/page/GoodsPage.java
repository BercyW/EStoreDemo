package bercy.page;

import java.util.ArrayList;

import bercy.dao.GoodsDao;
import bercy.dao.SalesManDao;
import bercy.entity.Goods;
import bercy.entity.SalesMan;
import bercy.tools.QueryPrint;
import bercy.tools.ScannerChoice;

public class GoodsPage extends ScannerChoice {

	/**
	 * 1.add products
	 */
	public static void addGoodsPage() {

		System.out.println("\tAdding Products!\n");
		System.out.println("\nEnter product ---Name");
		String goodsName = ScannerInfoString();
		System.out.println("\nEnter product ---Price");
		double goodsPrice = ScannerInfoDouble();
		System.out.println("\nEnter product ---Amount");
		int goodsAmount = ScannerNum();

		Goods goods = new Goods(goodsName, goodsPrice, goodsAmount);
		boolean bool = new GoodsDao().addGoods(goods);
		if (bool) {
			System.out.println("\n\t!Products has been added to database!!");
		} else {
			System.out.println("\n\t!Failed to add products");
		}
		changedInfoNext("addGoodsPage");

	}
	/*
	 * update goods
	 */

	public static void updateGoodsPage() {
		System.out.println("\tUpdating products!!\n");
		System.out.println("Enter products' name");

		int gid = QueryPrint.query("updateGoodsPage");

		System.out.println("\n--------Which you want to change?\n");
		System.out.println("\t1.Change Name");
		System.out.println("\t2.Change Price");
		System.out.println("\t3.Change Amount");
		System.out.println("Please choose, or press 0 to go back!!");
		do {
			String choice = ScannerInfoString();
			String regex = "[0-3]";
			if (choice.matches(regex)) {
				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					MainPage.maintenancePage();
					break;
				case 1:
					System.out.println("Enter----New Name");
					String sNewName = ScannerInfoString();
					Goods newGoodsName = new Goods(gid, sNewName);

					// parameter 1 is the case value, 1 for change name, 2 for
					// price
					boolean boolName = new GoodsDao().updateGoods(1, newGoodsName);

					if (boolName) {
						System.out.println("\n\t!!SUCCESS!!!\n");
					} else {
						System.out.println("\n\t!!FAILED!!\n");
					}

					changedInfoNext("updateGoodsPage");
					break;
				case 2:
					System.out.println("Enter----New Price");
					double newPrice = ScannerInfoDouble();
					Goods newGoodsPrice = new Goods(gid, newPrice);
					boolean boolPrice = new GoodsDao().updateGoods(2, newGoodsPrice);
					if (boolPrice) {
						System.out.println("\n\t!!SUCCESS!!!\n");
					} else {
						System.out.println("\n\t!!FAILED!!\n");
					}
					changedInfoNext("updateGoodsPage");
					break;
				case 3:
					System.out.println("Enter----New Price");
					int newNum = ScannerNum();
					Goods newGoodsNum = new Goods(gid, newNum);
					boolean boolNum = new GoodsDao().updateGoods(3, newGoodsNum);
					if (boolNum) {
						System.out.println("\n\t!!SUCCESS!!!\n");
					} else {
						System.out.println("\n\t!!FAILED!!\n");
					}
					changedInfoNext("updateGoodsPage");
					break;
				default:
					break;
				}
			}
			System.out.println("\tError!!!");
			System.out.println("\tChoose one,or 0 go back!!");
		} while (true);

	}

	/**
	 * delete goods
	 */
	public static void deleteGoodsPage() {
		System.out.println("\tDeleting Goods Info!!\n");
		System.out.println("\nPlease Enter Goods Name");

		int gid = QueryPrint.query("deleteGoodsPage");
		do {
			System.out.println("Are you sure to delete this Item:Y/N");
			String choice = ScannerInfoString();
			if ("y".equals(choice) || "Y".equals(choice)) {
				boolean boolDeleteGoods = new GoodsDao().deleteGoods(gid);
				if (boolDeleteGoods) {
					System.out.println("Delete succeed!!");
				} else {
					System.out.println("Delete Failed!!");
				}
				changedInfoNext("deleteGoodsPage");

			} else if ("N".equals(choice) || "n".equals(choice)) {
				MainPage.maintenancePage();
			}
			System.out.println("!!Error!!");
		} while (true);
	}

	/**
	 * query the products
	 */
	public static void queryGoodsPage() {
		System.out.println("\t\t  Searching products\n");
		System.out.println("\t\t1.Sort of Amount");
		System.out.println("\t\t2.Sort of Price");
		System.out.println("\t\t3.Search use key word");
		System.out.println("\nOr enter 0 to go back!");

		do {
			String info = ScannerInfoString();
			String regex = "[0-3]";
			if (info.matches(regex)) {
				int choice = Integer.parseInt(info);
				if (choice == 0) {
					MainPage.maintenancePage();
				} else if (choice == 3) {
					System.out.println("\t\tSearching the key word!!");
					System.out.println("Enter item's name: ");

				}
				ArrayList<Goods> goodsList = new GoodsDao().queryGoods(choice);
				if (goodsList.size() <= 0 || goodsList == null) {

					System.err.println("---Database is empty!!---");
					queryGoodsPage();
				}else {
					if(choice == 1) {
						 System.out.println("\t\t\t\t\tProducts sort of amount\n\n");
					}else if(choice == 2) {
						 System.out.println("\t\t\t\t\tProducts sort of price\n\n");				
					}
					System.out.println("\tID\t\tName\t\tPrice\t\tAmount\t\tComment\n");
				for (Goods goods : goodsList) {
					System.out.print("\t"+goods.getgId()+"\t\t"+goods.getgName()+"\t\t"+goods.getgPrice()+"\t\t"+goods.getgNumber());
					if(goods.getgNumber()==0) {
						System.out.println("This item is sold out!");
						
					}else if(goods.getgNumber()<10) {
						System.out.println("This item is less than 10.");
					}else {
						System.out.println("\t\t-");
					}				
				}
					System.out.println("---------------------");
					do {
						System.out.println("Enter 0 to go back!");
						String choiceNext = ScannerInfoString();
						if("0".equals(choiceNext)) {
							MainPage.maintenancePage();
						}
						System.out.println("Wrong number!");
						
					}while(true);
				}

			}
		} while (true);

	}

	public static void displayGoodsPage() {
		// TODO Auto-generated method stub

	}
}
