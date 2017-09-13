package bercy.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bercy.db.DbClose;
import bercy.db.DbConn;
import bercy.entity.Goods;
import bercy.entity.SalesMan;

/**
 * provide query and print tools
 * 
 * @author Bercy
 *
 */
public final class QueryPrint {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/*
	 * query salesman use sname
	 */
	public ArrayList<SalesMan> querySalesMan(String sName) {

		ArrayList<SalesMan> salesManList = new ArrayList<SalesMan>();
		conn = DbConn.getConn();
		String sql = "select * from salesman where sname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int sId = rs.getInt("sid");
				String name = rs.getString(2);
				String password = rs.getString(3);
				SalesMan sm = new SalesMan(sId, name, password);
				salesManList.add(sm);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return salesManList;
	}

	/**
	 * 
	 * query product for showing the product info return gid . -1 is for error
	 */
	public static int query(String opr) {

		int gid = -1;
		String gName = ScannerChoice.ScannerInfoString();
		ArrayList<Goods> goodsList = new QueryPrint().queryGoods(gName);
		if (goodsList == null | goodsList.size() <= 0) {
			System.out.println("There is no product: " + gName);
			ScannerChoice.changedInfoNext(opr);
		} else {

			Goods goods = goodsList.get(0);
			System.out.println("\t\t\t\t\tProduct List!\n\n");
			System.out.println("\tID\t\tName\t\tPrice\t\tAmount\t\tComment\n");
			System.out.print("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t" + goods.getgPrice() + "\t\t"
					+ goods.getgNumber());

			if (goods.getgNumber() == 0) {
				System.out.println("This product is sold out!!");
			} else if (goods.getgNumber() < 10) {
				System.out.println("This item is less then 10!!");
			} else {
				System.out.println("-");
			}
			gid = goods.getgId();

		}

		return gid;

	}

	/**
	 * using gname to search goods
	 * 
	 * @param gName
	 * @return
	 */
	private ArrayList<Goods> queryGoods(String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getConn();
		String sql = "select * from goods where gname = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int gid = rs.getInt("gid");
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int num = rs.getInt(4);

				Goods goods = new Goods(gid, name, price, num);
				goodsList.add(goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return goodsList;
	}

}
