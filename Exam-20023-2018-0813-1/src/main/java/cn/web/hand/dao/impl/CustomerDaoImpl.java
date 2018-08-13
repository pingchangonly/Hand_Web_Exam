package cn.web.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.web.hand.dao.ICustomerDao;
import cn.web.hand.db.DBConnection;

public class CustomerDaoImpl implements ICustomerDao {

	public boolean verify(String name) {
		Boolean flag = false;
		DBConnection dbConn = DBConnection.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select customer_id  from customer where first_name = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs != null && rs.next() != false) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
}
