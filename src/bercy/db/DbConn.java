package bercy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConn {
	public static Connection getConn() {
		Connection conn = null;

		String url = "jdbc:mysql://127.0.0.1:3306/abc?autoReconnect=true&useSSL=false";
		String user = "root";
		String passwd = "bersy1989";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
}
