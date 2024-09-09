package Tuan2.DAO;

import java.util.List;

import Tuan2.models.userModels;

public interface IUserDao {
 
	List<userModels> findAll();
	
	userModels findById(int id);
	
	void insert(userModels user);
	
	userModels findByUserName(String username);
	
	userModels get(String username);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);
}
