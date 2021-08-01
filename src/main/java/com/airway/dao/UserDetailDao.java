package com.airway.dao;
/**
 * @author shyam
 * 31-Jul-2021 11:12:56 pm
 */

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.airway.data.model.UserDetail;

@Service
public interface UserDetailDao {

	UserDetail save(UserDetail userDetail);

	/**
	 * @param userName
	 * @return
	 */
	Optional<UserDetail> userByUserName(String userName);
}
