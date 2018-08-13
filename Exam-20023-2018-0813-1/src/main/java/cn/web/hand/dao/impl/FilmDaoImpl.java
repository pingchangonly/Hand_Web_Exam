package cn.web.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.web.hand.dao.IFilmDao;
import cn.web.hand.db.DBConnection;
import cn.web.hand.entity.Film;

public class FilmDaoImpl implements IFilmDao {

	public List<Film> showFilms() {
		List<Film> films = new ArrayList<Film>();

		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select film_id,title,description,l.name from film f ,"
				+ "language l  where f.language_id = l.language_id order by film_id desc ";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				Film film = null;
				while (rs.next()) {
					film = new Film();
					film.setFilmId(rs.getInt("film_id"));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setLanguageName(rs.getString("name"));
					films.add(film);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}

		return films;
	}

	public void addFilm(Film film) {
		List<Film> films = new ArrayList<Film>();

		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =" insert into film (title,description,language_id) values(?,?,?)";
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguageId());
			
			int row = ps.executeUpdate();
			System.out.println(row+"成功");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}

	}

	public void deleteFilm(int id) {
		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =" delete from film where film_id = ? ";
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			System.out.println(row+"成功");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}

	}

	public void UpdateFilm(Film film) {
		List<Film> films = new ArrayList<Film>();

		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =" update film set title=?,description=?,language_id=? where film_id=? ";
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguageId());
			ps.setInt(4, film.getFilmId());
			
			int row = ps.executeUpdate();
			System.out.println(row+"成功");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}


	}

	public Film findById(int id) {
		
		Film film = new Film();
		DBConnection dbConn = DBConnection.getInstance();

		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select film_id,title,description,l.name from film f ,"
				+ "language l  where f.language_id = l.language_id and film_id=? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs != null) {
				
				while (rs.next()) {
					
					film.setFilmId(rs.getInt("film_id"));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setLanguageName(rs.getString("name"));
		
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbConn.close(conn, ps, rs);
		}

		return film;
	}

}
