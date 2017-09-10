package bercy.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bercy.db.DbClose;
import bercy.db.DbConn;
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
				SalesMan sm = new SalesMan(sId,name,password);
				salesManList.add(sm);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return salesManList;
	}

}
