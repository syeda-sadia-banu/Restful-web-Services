package com.appsdeveloperblog.ws;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloperblog.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);

	void delete(UserEntity userEntity);

	UserEntity save(UserEntity userEntity);

}
