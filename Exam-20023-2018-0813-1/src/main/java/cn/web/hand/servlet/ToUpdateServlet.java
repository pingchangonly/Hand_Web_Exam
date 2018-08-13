package cn.web.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.web.hand.entity.Film;
import cn.web.hand.service.IFilmService;
import cn.web.hand.service.impl.FilmServiceImpl;

public class ToUpdateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//获取要要编辑的电影ID
		int filmId = Integer.parseInt(req.getParameter("filmId"));
		//根据id 返回该部电影的详细信息
		IFilmService fs = new FilmServiceImpl();
		Film film = fs.findById(filmId);
		//将数据保存到请求中
		req.setAttribute("film", film);
		//转向编辑电影信息页面
		req.getRequestDispatcher("/updateFilm.jsp").forward(req, res);
	}

	
}
