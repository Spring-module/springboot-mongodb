/**
 * Project Name:springboot-mongodb
 * File Name:StudentRepository.java
 * Package Name:com.kaiyun.springboot.mongodb.dao
 * Date:2019年4月26日下午4:24:05
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaiyun.springboot.mongodb.model.Student;

/**
 * ClassName:StudentRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月26日 下午4:24:05 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface StudentRepository extends MongoRepository<Student,String> {
	
	public Student findByName(String name);
	
    public List<Student> findBySex(String sex);
    
    public long count();
}

