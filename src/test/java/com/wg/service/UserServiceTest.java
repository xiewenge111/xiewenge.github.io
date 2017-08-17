package com.wg.service;

import com.wg.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;  
import com.wg.baseTest.SpringTestCase;

public class UserServiceTest extends SpringTestCase {
	
	@Autowired  
    private UserService userService;
	
	@Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(1);
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  
}
