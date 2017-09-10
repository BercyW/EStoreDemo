package bercy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bercy.db.DbClose;
import bercy.db.DbConn;
import bercy.entity.SalesMan;

/**
 * database salesMan table handling
 * 
 * @author Bercy
 *
 */
public final class SalesManDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 1.font checkout page check if has the salesman or not
	 * 
	 * @param sName
	 * @return
	 */
	public ArrayList<SalesMan> checkstandLog(String sName) {
		ArrayList<SalesMan> salesManInfo = new ArrayList<SalesMan>();
		conn = DbConn.getConn();
		String sql = "select sid,spassword from salesman where sname=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String sPassword = rs.getString("spassword");
				int sId = rs.getInt("sid");
				SalesMan salesMan = new SalesMan(sId, sPassword);
				salesManInfo.add(salesMan);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return salesManInfo;
	}

	/**
	 * 2.add salesman
	 */

	public boolean addSalesman(SalesMan salesMan) {
		boolean bool = false;
		String sql = "insert into salesman(sname,password) values (?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, salesMan.getsName());
			pstmt.setString(2, salesMan.getsPassword());
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}

		return bool;
	}
	/**
	 * 3.change salesman
	 */
	public boolean updataSalesman(int key, SalesMan salesman) {
		boolean bool = false;
		conn = DbConn.getConn();
		switch (key) {
			case 1 :

				String sql = "update salesman set sName = ? where sid = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, salesman.getsName());
					pstmt.setInt(2, salesman.getsId());
				}

				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2 :

				break;
			default :
				break;
		}
		return bool;
	}

}
