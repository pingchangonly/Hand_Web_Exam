package cn.web.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.web.hand.entity.Film;
import cn.web.hand.service.IFilmService;
import cn.web.hand.service.impl.FilmServiceImpl;

public class ShowFilmListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//显示电影列表
		IFilmService fs = new FilmServiceImpl();
		List<Film> filmList = fs.showFilmList();
		//将电影列表放入请求中
		req.setAttribute("filmList", filmList);
		req.getRequestDispatcher("/showFilmList.jsp").forward(req, res);
		
	}
	
}
