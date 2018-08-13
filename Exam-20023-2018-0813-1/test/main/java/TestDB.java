import java.util.List;

import cn.web.hand.dao.IFilmDao;
import cn.web.hand.dao.impl.FilmDaoImpl;
import cn.web.hand.entity.Film;


public class TestDB {

	public static void main(String[] args) {
		/*DBConnection conn = DBConnection.getInstance();
		System.out.println(conn);*/
		
		/*ICustomerDao cd = new CustomerDaoImpl();
		boolean vorify = cd.vorify("MARY");
		System.out.println(vorify);*/
		IFilmDao fd = new FilmDaoImpl();
		/*List<Film> films = fd.showFilms();
		for (Film film : films) {
			
			System.out.println(film.getFilmId()+"---->"+film.getLanguageName());
		}*/
		fd.deleteFilm(1003);
	}
}
