package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.UserRepository;
import com.ats.ATS.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
public List<User> getUsers(){
	return userRepository.findAll();
}

public User findbyUsername(String email){
	return userRepository.finduserbymail(email);
}

public User createUser(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	return userRepository.save(user);
}


public void deleteUser(int id) {
	userRepository.deleteById(id);
	

}

public void updateuser(String id, String designation, String department) {
	userRepository.updateuser(id,designation,department);
	
}



}
