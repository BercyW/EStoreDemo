package bercy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bercy.db.DbClose;
import bercy.db.DbConn;
import bercy.entity.Gsales;

/**
 * database management
 * 
 * @author Bercy
 *
 */
public class GsalesDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * sold products today, include total single items
	 * 
	 * @return
	 */
	public ArrayList<Gsales> dailyGsales() {
		ArrayList<Gsales> gSalesList = new ArrayList<Gsales>();
		conn = DbConn.getConn();
		String sql = "select gname,gprice,gnum,allSum from goods,(select gid as soldid,sum(snum) as allSum from gsales where data_format(now(),'%M,%D,%Y')=data_format(sda,'%M,%D,%Y') group by gid) as allSum where gid = soldid";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String gName = rs.getString(1);
				double gPrice = rs.getDouble(2);
				int gNum = rs.getInt(3);
				int allSum = rs.getInt("allSum");

				Gsales gSales = new Gsales(gName, gPrice, gNum, allSum);
				gSalesList.add(gSales);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return gSalesList;
	}
}
