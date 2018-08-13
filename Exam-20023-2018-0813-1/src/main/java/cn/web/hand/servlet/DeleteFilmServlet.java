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

public class DeleteFilmServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 获取要删除的电影id
		String[] strs = req.getParameterValues("case");
		// 根据ID删除该电影信息
		IFilmService fs = new FilmServiceImpl();

		int filmId = 0;
		for (String str : strs) {
			filmId = Integer.parseInt(str);
			try{
			fs.deleteFilm(filmId);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ddd");
			}
			
		}
		//重新拉取电影列表信息
		List<Film> filmList = fs.showFilmList();
		req.setAttribute("filmList", filmList);
		// 刷新电影列表信息
		req.getRequestDispatcher("/filmList.jsp").forward(req, res);

	}

}
