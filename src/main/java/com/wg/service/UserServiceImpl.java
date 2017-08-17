package com.wg.service;

import com.wg.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wg.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
  
    public User selectUserById(int userId) {
        User user = userDao.selectUserById(userId);
        return user;
          
    }  
}
