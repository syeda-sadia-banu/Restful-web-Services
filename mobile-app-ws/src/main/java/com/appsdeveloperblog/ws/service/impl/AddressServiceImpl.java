package com.appsdeveloperblog.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.ws.io.entity.AddressEntity;
import com.appsdeveloperblog.ws.io.entity.UserEntity;
import com.appsdeveloperblog.ws.io.repository.AddressRepository;
import com.appsdeveloperblog.ws.io.repository.UserRepository;
import com.appsdeveloperblog.ws.service.AddressService;
import com.appsdeveloperblog.ws.shared.dto.AddressDto;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<AddressDto> getAddresses(String userId) {

		List<AddressDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null) return returnValue;
		
		Iterable<AddressEntity> addresses=addressRepository.findAllByUserDetails(userEntity);
		for(AddressEntity addressEntity:addresses) {
			returnValue.add(modelMapper.map(addressEntity,AddressDto.class));
		}

			return returnValue;
	}

}
