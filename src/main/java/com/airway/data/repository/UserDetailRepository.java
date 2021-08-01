package com.airway.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airway.data.model.UserDetail;

/**
 * @author shyam
 * 31-Jul-2021 11:12:14 pm
 */

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{

	/**
	 * @param userName
	 * @return
	 */
	Optional<UserDetail> findByUserNameIgnoreCase(String userName);

}
