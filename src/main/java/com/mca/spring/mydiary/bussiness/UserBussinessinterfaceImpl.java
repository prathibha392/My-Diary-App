package com.mca.spring.mydiary.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mca.spring.mydiary.dao.UserDaointerface;
import com.mca.spring.mydiary.entities.User;

@Component
public class UserBussinessinterfaceImpl implements UserBussinessinterface {
	
	@Autowired
	private UserDaointerface userDaointerface;
	
	

	public UserDaointerface getUserDaointerface() {
		return userDaointerface;
	}

	public void setUserDaointerface(UserDaointerface userDaointerface) {
		this.userDaointerface = userDaointerface;
	}

	@Override
	public void save(User user) {
		userDaointerface.save(user);

	}

	@Override
	public void update(User user) {
		userDaointerface.update(user);

	}

	@Override
	public void delete(User user) {
		userDaointerface.delete(user);

	}

	@Override
	public User findById(int id) {
		return userDaointerface.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDaointerface.findAll();
	}

	@Override
	public User findByUsername(String username) {
		
		return userDaointerface.findByUsername(username);
	}

}
