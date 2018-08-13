package cn.web.hand.service.impl;

import java.util.List;

import cn.web.hand.dao.IFilmDao;
import cn.web.hand.dao.impl.FilmDaoImpl;
import cn.web.hand.entity.Film;
import cn.web.hand.service.IFilmService;

public class FilmServiceImpl implements IFilmService {

	public List<Film> showFilmList() {
		
		IFilmDao fd = new FilmDaoImpl();
		List<Film> filmList = fd.showFilms();
		return filmList;
	}

	public void add(Film film) {
		IFilmDao fd = new FilmDaoImpl();
		fd.addFilm(film);	
	}

	public void update(Film film) {
		IFilmDao fd = new FilmDaoImpl();
		fd.UpdateFilm(film);
	}

	public Film findById(int id) {
		IFilmDao fd = new FilmDaoImpl();
		Film film = fd.findById(id);
		return film;
	}

	public void deleteFilm(int id) {
		IFilmDao fd = new FilmDaoImpl();
		fd.deleteFilm(id);
		
	}

}
