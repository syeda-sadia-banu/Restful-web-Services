package com.appsdeveloperblog.ws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.ws.UserRepository;
import com.appsdeveloperblog.ws.io.entity.UserEntity;
import com.appsdeveloperblog.ws.service.UserService;
import com.appsdeveloperblog.ws.shared.Utils;
import com.appsdeveloperblog.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils utils;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record already exist");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));

		String publicUserId = utils.generatedUserId(30);
		userEntity.setUserId(publicUserId);

		UserEntity sharedvalue = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(sharedvalue, returnValue);

		return returnValue;
	}


	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity=userRepository.findByEmail(email);
		if(userEntity==null)throw new UsernameNotFoundException(email);
		
		UserDto returnValue=new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userRepository.findByEmail(username);
		if(userEntity==null) throw new UsernameNotFoundException(username);
		return new User(username, userEntity.getEncryptedPassword(), new ArrayList<>());
	}

}
