package cn.web.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginControlFilter implements Filter {


	public void destroy() {

	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) arg0;
		if (req.getServletPath().equals("/loginServlet")) {
			arg2.doFilter(arg0, arg1);
		} else {
			HttpSession session = req.getSession();
			String userName = null;
			try {
				userName = (String) session.getAttribute("CURR_USER");
			} catch (Exception e) {
				// e.printStackTrace();
			}
			if (userName != null) {
				// xxxxreq
				// res.setContentType("text/html;charset=utf-8");
				arg2.doFilter(arg0, arg1);
				// xxxxres
			} else {
				System.out.println("ss");
				req.setAttribute("message", "请先登录");
				req.getRequestDispatcher("login.jsp").forward(arg0, arg1);
			}

		}

	}


	public void init(FilterConfig arg0) throws ServletException {

	}

}
