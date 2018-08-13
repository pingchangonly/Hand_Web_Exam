package cn.web.hand.dao;

public interface ICustomerDao {
	/**
	 * 验证登录
	 * @return
	 */
	boolean verify(String name);
}
