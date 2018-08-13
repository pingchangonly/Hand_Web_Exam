package cn.web.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.web.hand.entity.Language;
import cn.web.hand.service.ICustomerService;
import cn.web.hand.service.ILanguageService;
import cn.web.hand.service.impl.CustomerServiceImpl;
import cn.web.hand.service.impl.LanguageServiceImpl;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String userName = req.getParameter("userName");
		ICustomerService cs = new CustomerServiceImpl();
		boolean flag = cs.verify(userName);
		String message = null;
		if(flag){
			//设置登录成功标志
			HttpSession session = req.getSession();
			session.setAttribute("CURR_USER", userName);
			//将Language数据存入sesssion中
			ILanguageService ls = new LanguageServiceImpl();
			List<Language> languages = ls.showLanguages();
			session.setAttribute("Languages", languages);
			//转向系统主页
			req.getRequestDispatcher("/index.jsp").forward(req, res);
		}else{
			message = "登录失败";
			req.setAttribute("message", message);
			req.getRequestDispatcher("/login.jsp").forward(req, res);
		}
		
	}

	
}
