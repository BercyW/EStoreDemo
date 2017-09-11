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
		// change name;
		case 1:
			String sqlName = "update salesman set sName = ? where sid = ?";
			try {
				pstmt = conn.prepareStatement(sqlName);
				pstmt.setString(1, salesman.getsName());
				pstmt.setInt(2, salesman.getsId());
				int value = pstmt.executeUpdate();

				if (value > 0) {
					bool = true;
				}
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbClose.addClose(pstmt, conn);
			}

			break;
		// change password
		case 2:
			String sqlPW = "update salesman set password = ? where sid = ?";
			try {
				pstmt = conn.prepareStatement(sqlPW);
				pstmt.setString(1, salesman.getsPassword());
				pstmt.setInt(2, salesman.getsId());
				int value = pstmt.executeUpdate();
				if (value > 0) {
					bool = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbClose.addClose(pstmt, conn);
			}

			break;
		default:
			break;
		}
		return bool;
	}

	/**
	 * delete salesman
	 * 
	 * @param sName
	 * @return
	 */
	public boolean deleteSalesMan(String sName) {
		boolean bool = false;
		conn = DbConn.getConn();
		String sql = "delete from salesman where sname = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			int value = pstmt.executeUpdate();

			if (value > 0) {
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
	 * display all salesman
	 */

	public ArrayList<SalesMan> displaySalesman() {
		ArrayList<SalesMan> salesmanList = new ArrayList<SalesMan>();
		conn = DbConn.getConn();
		String sql = "select * from salesman";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sId = rs.getInt(1);
				String sName = rs.getString(2);
				String sPassword = rs.getString(3);

				SalesMan sm = new SalesMan(sId, sName, sPassword);
				salesmanList.add(sm);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}

		return salesmanList;
	}

}
