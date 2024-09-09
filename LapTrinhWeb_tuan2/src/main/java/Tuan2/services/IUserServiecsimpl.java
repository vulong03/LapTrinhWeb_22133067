package Tuan2.services;

import Tuan2.models.userModels;

public interface IUserServiecsimpl {

		userModels login(String username , String password);
		userModels get(String username);
		
		void insert(userModels user);
		
		boolean register(String email, String password, String username, String
		fullname, String phone);
		
		boolean checkExistEmail(String email);
		
		boolean checkExistUsername(String username);
		
		boolean checkExistPhone(String phone);
		
	}

