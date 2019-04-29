package com.kaiyun.springboot.mongodb.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 通用rest外部响应对象
 *
 * @author lucas on 2019/4/18 17:29
 */
@ApiModel
@Data
@Builderpublic class CommonResp<T> {
	@ApiModelProperty(required=true, value="返回JSON对象")
	private T data;
	@ApiModelProperty(required=true, value="返回状态(0:成功，非0失败)", example="0")
	private int result;
	@ApiModelProperty(required=true, value="返回消息", example="成功")
	private String message;
	
	
	@Override
	public String toString() {
		return String.format("BaseResult [data=%s, result=%s, message=%s]", data, result, message);
	}
}
