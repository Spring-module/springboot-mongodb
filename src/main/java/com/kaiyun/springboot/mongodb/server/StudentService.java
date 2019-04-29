/**
 * Project Name:springboot-mongodb
 * File Name:StudentService.java
 * Package Name:com.kaiyun.springboot.mongodb.server
 * Date:2019年4月26日下午4:25:37
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.server;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.kaiyun.springboot.mongodb.common.Page;
import com.kaiyun.springboot.mongodb.dto.PageDTO;
import com.kaiyun.springboot.mongodb.model.Student;
import com.mongodb.client.result.UpdateResult;

/**
 * ClassName:StudentService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月26日 下午4:25:37 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface StudentService {
	
	public Student add (Student student);
	
    public UpdateResult update (Student student);
    
    public void delete(String id);
    
    public Student findByName(String name);
    
    public List<Student> findBySex(String sex);
    
    public List<Student> findAll();
    
    public long count();
    
    public Page<Student> findPage(PageDTO dto);
    
}

