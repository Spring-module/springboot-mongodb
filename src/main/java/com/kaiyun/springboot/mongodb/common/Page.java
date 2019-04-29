/**
 * Project Name:springboot-mongodb
 * File Name:Page.java
 * Package Name:com.kaiyun.springboot.mongodb.common
 * Date:2019年4月28日下午3:00:10
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.common;
/**
 * ClassName:Page <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月28日 下午3:00:10 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 每页显示个数
     */
    private int pageSize;
    /**
     * 当前页数
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 结果列表
     */
    private List<T> rows;

    public Page() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage <= 0 ? 1 : currentPage;
        this.pageSize = pageSize <= 0 ? 1 : pageSize;
    }

    /**
     * 设置结果 及总页数
     * 
     * @param list
     */
    public void build(List<T> rows) {
        this.setRows(rows);
        int count = this.getTotalCount();
        int divisor = count / this.getPageSize();
        int remainder = count % this.getPageSize();
        this.setTotalPage(remainder == 0 ? divisor == 0 ? 1 : divisor
                : divisor + 1);
    }
}