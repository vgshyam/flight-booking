package com.airway.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airway.dao.UserDetailDao;
import com.airway.data.model.UserDetail;
import com.airway.data.repository.UserDetailRepository;

/**
 * @author shyam
 * 31-Jul-2021 11:13:52 pm
 */

@Component
public class UserDetailDaoImpl implements UserDetailDao{

	@Autowired private UserDetailRepository userRepo;
	@Override
	public UserDetail save(UserDetail userDetail) {
		return userRepo.save(userDetail);
	}
	@Override
	public Optional<UserDetail> userByUserName(String userName) {
		return userRepo.findByUserNameIgnoreCase(userName);
	}

}
