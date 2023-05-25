package com.example.demo;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTestCase {

@Autowired
   StudentRepo repo;
   Student s=null;
   Scanner sc=null;
@Before
public void init() {
	s=new Student();
	sc=new Scanner(System.in);	
}
	@Test
	public void test() {
		System.out.println("Enter the Name:?");
		s.setName(sc.next());
		System.out.println("Enter the Email:?");
		s.setEmail(sc.next());
	 	assertNotNull(repo.save(s));
	 	System.out.println(s);
	 	System.out.println("Details entered successfully");
	}
	@Test
	public void getbynameTest() {
		System.out.println("Enter the name you want to search in the database table");
		String name=sc.next();
		assertNotNull(repo.findbyname(name));
		System.out.println("Output for the testcase :" +repo.findbyname(name));
	}
@After
public void deinit() {
	s=null;
}

}
