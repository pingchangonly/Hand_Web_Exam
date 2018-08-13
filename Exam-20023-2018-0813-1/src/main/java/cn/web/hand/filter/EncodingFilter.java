package cn.web.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}


	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg1.setContentType("text/html;charset=UTF-8");// 1
		// arg0.setAttribute(arg0, arg1);
		HttpServletRequest req = (HttpServletRequest)arg0;
		MyRequestWrapper myReq = new MyRequestWrapper(req);
		arg2.doFilter(myReq, arg1);

	}


	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	private class MyRequestWrapper extends HttpServletRequestWrapper {
		public MyRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {
			// 根据参数名称，获取旧值ֵ
			String value = super.getParameter(name);
			// 将旧值转码
			if (value != null) {
				try {
					byte[] bytes = value.getBytes("iso-8859-1");
					value = new String(bytes, "UTF-8");
				} catch (Exception e) {
				}
			}
			// 返回新值ֵ
			return value;
		}

	}

}
