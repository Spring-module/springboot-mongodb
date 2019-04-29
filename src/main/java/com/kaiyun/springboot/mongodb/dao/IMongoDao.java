/**
 * Project Name:springboot-mongodb
 * File Name:IMongoDao.java
 * Package Name:com.kaiyun.springboot.mongodb.dao
 * Date:2019年4月29日上午10:51:08
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.kaiyun.springboot.mongodb.common.Page;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * ClassName:IMongoDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2019年4月29日 上午10:51:08 <br/>
 * 
 * @author kaiyun
 * @version
 * @since JDK 1.8
 * @see
 */
public interface IMongoDao<T> {
	/**
	 * find:根据条件查询. <br/>
	 *
	 * @param query
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public List<T> find(Query query);

	/**
	 * findOne:根据条件查询一个. <br/>
	 *
	 * @param query
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public T findOne(Query query);

	/**
	 * save:插入. <br/>
	 *
	 * @param entity
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public void save(T entity);

	/**
	 * update:根据条件更新. <br/>
	 *
	 * @param query
	 * @param update
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public UpdateResult update(Query query, Update update);

	/**
	 * findAll:获得所有该类型记录,并且指定了集合名(表的意思). <br/>
	 *
	 * @param collectionName
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public List<T> findAll(String collectionName);

	/**
	 * count:根据条件 获得总数. <br/>
	 *
	 * @param query
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public long count(Query query);

	/**
	 * remove:根据条件 删除. <br/>
	 *
	 * @param query
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public DeleteResult remove(Query query);

	/**
	 * findPage:分页查询. <br/>
	 *
	 * @param page
	 * @param query
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
	public Page<T> findPage(Page<T> page, Query query);
}