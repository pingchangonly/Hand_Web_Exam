package cn.web.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.web.hand.entity.Film;
import cn.web.hand.service.IFilmService;
import cn.web.hand.service.impl.FilmServiceImpl;

public class AddFilmServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//获取表单数据
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int languageId = Integer.parseInt(req.getParameter("languageId"));
		//将获得的数据封装到Film中
		Film film = new Film();
		film.setLanguageId(languageId);
		film.setDescription(description);
		film.setTitle(title);
		//设置提醒信息
		String message = "";
		//将数据插入数据库中
		IFilmService fs = new FilmServiceImpl();
		try{
			fs.add(film);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
		}
		message = "添加成功";
		req.setAttribute("message", message);
		req.getRequestDispatcher("/showFilmListServlet").forward(req, res);
	}

	
}
