package bercy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bercy.db.DbClose;
import bercy.db.DbConn;
import bercy.entity.Goods;

/**
 * goods database management
 * 
 * @author Bercy
 *
 */
public class GoodsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * add product
	 * 
	 * @param goods
	 * @return
	 */
	public boolean addGoods(Goods goods) {
		boolean bool = false;
		conn = DbConn.getConn();

		String sql = "Insert into Goods(gname,gprice,gnum) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getgName());
			pstmt.setDouble(2, goods.getgPrice());
			pstmt.setInt(3, goods.getgNumber());

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
	 * 2.update product based on the key to determine which need to be change
	 */
	public boolean updateGoods(int key, Goods goods) {
		boolean bool = false;
		conn = DbConn.getConn();
		switch (key) {
		case 1: // change name
			String sqlName = "update goods set gname = ? where gid = ?";

			try {
				pstmt = conn.prepareStatement(sqlName);
				pstmt.setString(1, goods.getgName());
				pstmt.setInt(2, goods.getgId());
				int val = pstmt.executeUpdate();

				if (val > 0) {
					bool = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbClose.queryClose(pstmt, rs, conn);
			}

			break;
		case 2:// change price

			String sqlPrice = "update goods set gprice = ? where gid = ?";

			try {
				pstmt = conn.prepareStatement(sqlPrice);
				pstmt.setDouble(1, goods.getgPrice());
				pstmt.setInt(2, goods.getgId());
				int val = pstmt.executeUpdate();

				if (val > 0) {
					bool = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbClose.queryClose(pstmt, rs, conn);
			}

			break;
		case 3:

			String sqlNum = "update goods set gnum = ? where gid = ?";

			try {
				pstmt = conn.prepareStatement(sqlNum);
				pstmt.setInt(1, goods.getgNumber());
				pstmt.setInt(2, goods.getgId());
				int val = pstmt.executeUpdate();

				if (val > 0) {
					bool = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbClose.queryClose(pstmt, rs, conn);
			}

			break;

		}

		return bool;
	}

	public boolean deleteGoods(int gid) {
		boolean bool = false;

		conn = DbConn.getConn();

		String sql = "delete from goods where gid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);

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

}
