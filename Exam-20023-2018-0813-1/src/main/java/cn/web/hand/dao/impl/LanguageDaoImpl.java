package cn.web.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.web.hand.dao.ILanguageDao;
import cn.web.hand.db.DBConnection;

import cn.web.hand.entity.Language;

public class LanguageDaoImpl implements ILanguageDao {

	public List<Language> showLanguages() {
		
		List<Language> Languages = new ArrayList<Language>();

		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select Language_id,name from language ";
				
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				Language  lge= null;
				while (rs.next()) {
					lge = new Language();
					lge.setLanguageId(rs.getInt("language_id"));
					lge.setName(rs.getString("name"));
					Languages.add(lge);	
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}

		return Languages;
	}

}
