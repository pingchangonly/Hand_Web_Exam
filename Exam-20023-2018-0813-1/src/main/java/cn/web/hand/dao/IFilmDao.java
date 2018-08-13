package cn.web.hand.dao;

import java.util.List;

import cn.web.hand.entity.Film;

public interface IFilmDao {
	/**
	 * 显示所有电影列表
	 * @return
	 */
	List<Film> showFilms();
	/**
	 * 添加一部电影
	 * @param film
	 */
	void addFilm(Film film);
	/**
	 * 删除该部电影
	 * @param id
	 */
	void deleteFilm(int id);
	/**
	 *更新电影信息
	 * @param id
	 */
	void UpdateFilm(Film film);
	/**
	 * 根据ID查找电影
	 */
	Film findById(int id);
}
