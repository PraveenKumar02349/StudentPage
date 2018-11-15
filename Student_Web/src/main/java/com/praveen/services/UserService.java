package com.praveen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.praveen.modal.User;
import com.praveen.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository )
	{
		this.userRepository=userRepository;
	}
	public void saveMyUser(User user) {
		
		userRepository.save(user);
	}
	public List<User>showAllUsers()
	{
		List<User>users=new ArrayList<User>();
		for(User user:userRepository.findAll()) {
			  users.add(user);
		}
		return users;
	}
	
	
	
	public void deleteMyUser(int id)
	{
		userRepository.deleteById(id);
	}
	public User editUser(int id)
	{
		User usr = userRepository.findById(id).get();
		User updusr = userRepository.save(usr);
		return updusr;
		
	
	}
	public User findByUsernameAndPassword(String username,String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
