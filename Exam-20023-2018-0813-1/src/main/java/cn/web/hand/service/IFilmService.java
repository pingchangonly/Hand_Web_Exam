package cn.web.hand.service;

import java.util.List;

import cn.web.hand.entity.Film;

public interface IFilmService {
	/***
	 * 所有电影列表
	 */
	List<Film>showFilmList();
	/**
	 * 添加一部电影
	 */
	void add(Film film);
	/**
	 * 编辑电影信息
	 */
	void update(Film film);
	/**
	 * 根据id获取电影信息
	 */
	Film findById(int id);
	/**
	 * 根据ID删除电影信息
	 */
	void deleteFilm(int id);
}
