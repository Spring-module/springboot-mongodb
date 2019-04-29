/**
 * Project Name:springboot-mongodb
 * File Name:PageDTO.java
 * Package Name:com.kaiyun.springboot.mongodb.dto
 * Date:2019年4月29日上午11:36:16
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName:PageDTO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月29日 上午11:36:16 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@ApiModel
@Data
public class PageDTO {
	
	/** 当前页 */
	@ApiModelProperty(required=true, value="当前页", example="1")
	@Min(value=1, message = "当前页必须大于等于1")
	private Integer currentPage;
	/** 每页条数 */
	@ApiModelProperty(required=true, value="每页条数", example="2")
	@Min(value=1, message = "每页条数必须大于等于1")
	private Integer pageSize;

}

