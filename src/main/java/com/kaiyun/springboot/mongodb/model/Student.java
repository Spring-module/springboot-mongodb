/**
 * Project Name:springboot-mongodb
 * File Name:Student.java
 * Package Name:com.kaiyun.springboot.mongodb.model
 * Date:2019年4月26日下午4:22:12
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName:Student <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月26日 下午4:22:12 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Document(collection="student")
@Data
public class Student {
	/**
     * id
     */
    @Id
    private String id;
    
    /**
     * 姓名
     */
    @ApiModelProperty(required=true, position=0, value="张三", example="张三")
    @NotBlank(message = "姓名不能为空")
    private String name;
    
    /**
     * 性别
     */
    @ApiModelProperty(required=true, position=1, value="男", example="张三")
    @NotBlank(message = "性别不能为空")
    private String sex;
    
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

