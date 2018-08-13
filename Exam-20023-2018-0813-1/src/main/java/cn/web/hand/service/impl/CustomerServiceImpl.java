package cn.web.hand.service.impl;

import cn.web.hand.dao.ICustomerDao;
import cn.web.hand.dao.impl.CustomerDaoImpl;
import cn.web.hand.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	public boolean verify(String userName) {
		ICustomerDao cd = new CustomerDaoImpl();
		boolean flag = cd.verify(userName);
 		return flag;
	}

}
