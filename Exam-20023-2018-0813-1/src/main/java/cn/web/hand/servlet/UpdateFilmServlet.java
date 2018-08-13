package cn.web.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.web.hand.entity.Film;
import cn.web.hand.service.IFilmService;
import cn.web.hand.service.impl.FilmServiceImpl;

public class UpdateFilmServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 获取表单数据
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int languageId = Integer.parseInt(req.getParameter("languageId"));
		int filmId = Integer.parseInt(req.getParameter("filmId"));
		// 将获得的数据封装到Film中
		Film film = new Film();
		film.setFilmId(filmId);
		film.setLanguageId(languageId);
		film.setDescription(description);
		film.setTitle(title);
		// 设置提醒信息
		String message = "";
		//更新该电影信息
		IFilmService fs = new FilmServiceImpl();
		try{
			fs.update(film);
		}catch(Exception e){
			e.printStackTrace();
		}
		message = "更新成功";
		req.setAttribute("message", message);
		//转向显示电影列表servlet
		req.getRequestDispatcher("/showFilmListServlet").forward(req, res);
	}

}
