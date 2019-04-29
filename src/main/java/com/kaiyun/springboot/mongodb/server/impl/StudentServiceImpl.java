/**
 * Project Name:springboot-mongodb
 * File Name:StudentServiceImpl.java
 * Package Name:com.kaiyun.springboot.mongodb.server.impl
 * Date:2019年4月26日下午4:26:38
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.kaiyun.springboot.mongodb.common.Page;
import com.kaiyun.springboot.mongodb.dao.StudentRepository;
import com.kaiyun.springboot.mongodb.dto.PageDTO;
import com.kaiyun.springboot.mongodb.model.Student;
import com.kaiyun.springboot.mongodb.server.StudentService;
import com.mongodb.client.result.UpdateResult;

/**
 * ClassName:StudentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月26日 下午4:26:38 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
    private StudentRepository studentRepository;
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
	@Override
	public Student add(Student student) {
		Student student1 = studentRepository.save(student);
        return student1;
	}

	@Override
	public UpdateResult update(Student student) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(student.getId()));
        
        Update update = new Update();
        update.set("name", student.getName());
        update.set("sex", student.getSex());
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        return result;
	}

	@Override
	public void delete(String id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student findByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> findBySex(String sex) {
		return studentRepository.findBySex(sex);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	@Override
	public long count() {
		return studentRepository.count();
	}

	@Override
	public Page<Student> findPage(PageDTO dto) {
		Integer currentPage = dto.getCurrentPage();
		Integer pageSize = dto.getPageSize();
		Page<Student> page = new Page<Student>();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
        // 总数 
		long count = this.count();
        page.setTotalCount((int) count);   
        
        Query query = new Query(Criteria.where("_id").exists(true));
        query.skip((currentPage - 1) * pageSize).limit(pageSize);  
        
        List<Student> rows = mongoTemplate.find(query, Student.class);
        page.build(rows);    
        
        return page;    
	}

}

