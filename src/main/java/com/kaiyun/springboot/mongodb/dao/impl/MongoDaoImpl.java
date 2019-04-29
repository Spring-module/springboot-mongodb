/**
 * Project Name:springboot-mongodb
 * File Name:MongoDaoImpl.java
 * Package Name:com.kaiyun.springboot.mongodb.dao.impl
 * Date:2019年4月29日上午10:54:42
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.kaiyun.springboot.mongodb.common.Page;
import com.kaiyun.springboot.mongodb.dao.IMongoDao;
import com.kaiyun.springboot.mongodb.model.Student;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * ClassName:MongoDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月29日 上午10:54:42 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Repository
public class MongoDaoImpl implements IMongoDao<Student> {

	@Resource
    private MongoTemplate template;

    @Override
    public List<Student> find(Query query) {
        List<Student> userList = template.find(query, Student.class);
        return userList;
    }

    @Override
    public Student findOne(Query query) {
        Student Student = template.findOne(query, Student.class);
        return Student;
    }

    @Override
    public void save(Student entity) {
        template.save(entity);
    }

    @Override
    public UpdateResult update(Query query, Update update) {
         if (update==null) {    
                return null;    
            }   
         UpdateResult updateResult = template.updateMulti(query, update, Student.class);
        return updateResult;
    }

    @Override
    public List<Student> findAll(String collectionName) {
        return template.findAll(Student.class, collectionName);
    }

    @Override
    public long count(Query query) {
        long count = template.count(query, "Student");
        return count;
    }

    @Override
    public DeleteResult remove(Query query) {
        Query query1 = new Query(Criteria.where("name").is("土豆丁233"));
        DeleteResult remove = template.remove(query1, "Student");
        return remove;
    }

    @Override
    public Page<Student> findPage(Page<Student> page, Query query) {
         query=query==null?new Query(Criteria.where("_id").exists(true)):query;    
            long count = this.count(query);    
            // 总数    
            page.setTotalCount((int) count);    
            int currentPage = page.getCurrentPage();    
            int pageSize = page.getPageSize();    
            query.skip((currentPage - 1) * pageSize).limit(pageSize);    
            List<Student> rows = this.find(query);    
            page.build(rows);    
            return page;    

    }
}

