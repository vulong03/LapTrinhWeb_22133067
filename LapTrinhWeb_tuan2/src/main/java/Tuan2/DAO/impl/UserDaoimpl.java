package Tuan2.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Tuan2.DAO.IUserDao;
import Tuan2.config.SQLServerConnection;
import Tuan2.models.userModels;
public class UserDaoimpl extends SQLServerConnection implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public List<userModels> findAll() {

		String sql = "select* from Username";
		
		List<userModels> list = new ArrayList<>();
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new userModels(rs.getInt("id"),rs.getString("email"),rs.getString("username"),rs.getString("fullname")
						,rs.getString("passWord"),rs.getString("avatar"),rs.getInt("roleid"), rs.getString("phone"),
						rs.getDate("createdday")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public userModels findById(int id) {
		return null;
	}

	@Override
	public void insert(userModels user) {
		String sql = "INSERT INTO [Username](email, username, fullname, password, avatar, roleid,phone,createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new SQLServerConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
@Override
public userModels findByUserName(String username) {
	String sql = "SELECT * FROM [Username] WHERE username = ? ";
	try {
		conn = super.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
			userModels user = new userModels();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("username"));
			user.setFullName(rs.getString("fullname"));
			user.setPassWord(rs.getString("password"));
			user.setAvatar(rs.getString("avatar"));
			user.setRoleid(Integer.parseInt(rs.getString("roleid")));
			user.setPhone(rs.getString("phone"));
			user.setCreatedDate(rs.getDate("createdDate"));
			return user;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@Override
public userModels get(String username) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean checkExistUsername(String username) {
	boolean duplicate = false;
	String query = "select * from [Username] where username = ?";
	try {
		conn = super.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
			duplicate = true;
		}
		ps.close();
		conn.close();
	} catch (Exception ex) {
	}
	return duplicate;
}

@Override
public boolean checkExistEmail(String email) {
	boolean duplicate = false;
	String query = "select * from [Username] where email = ?";
	try {
		conn = super.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
			duplicate = true;
		}
		ps.close();
		conn.close();
	} catch (Exception ex) {
	}
	return duplicate;
}

@Override
public boolean checkExistPhone(String phone) {
	// TODO Auto-generated method stub
	return false;
}
public static void main(String [] args) {
	UserDaoimpl userDao = new UserDaoimpl();
	
	List<userModels> list = userDao.findAll();
	for(userModels user : list)
	{
		System.out.println(user);
	}
	}

}
