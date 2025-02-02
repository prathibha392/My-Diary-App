package com.mca.spring.mydiary.bussiness;

import java.util.List;

import com.mca.spring.mydiary.entities.User;

public interface UserBussinessinterface {

	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(int id);
	public List<User> findAll();
	public User findByUsername(String username);
}
