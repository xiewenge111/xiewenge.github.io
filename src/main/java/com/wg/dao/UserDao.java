package com.wg.dao;

import com.wg.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	/**
	 * @param userId
	 * @return User
	 */
	public User selectUserById(Integer userId);

}
