package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.repo.*;
import com.example.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserRepo userRepo;
	
	@Test
	public void contextLoads() {
		
		for(User u : userRepo.findAll()){
			System.out.println("**************" + u.getUsername());
		}
		
	}

}
