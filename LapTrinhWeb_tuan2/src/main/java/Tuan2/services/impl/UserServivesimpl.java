package Tuan2.services.impl;

import Tuan2.models.userModels;
import Tuan2.services.IUserServiecsimpl;
import Tuan2.DAO.*;
import Tuan2.DAO.impl.UserDaoimpl;
public class UserServivesimpl implements IUserServiecsimpl {
	IUserDao userDao = new UserDaoimpl();
	@Override
	public userModels login(String username, String password) {
		
		userModels user = userDao.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
		return user;
		}
		return null;
		
	}

	@Override
	public userModels get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(userModels user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new userModels(email, username, fullname,password,null,5,phone,date));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

}
