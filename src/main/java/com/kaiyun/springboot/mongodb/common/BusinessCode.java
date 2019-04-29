package com.kaiyun.springboot.mongodb.common;

/**
 * 业务码定义
 * 
 * @author TYT
 *
 */
public enum BusinessCode {
	
	SUCCESS(0, "成功"), 
	SYSTEM_ERROR(99999,"系统异常"),
	PARAMS_ERROR(3000, "参数校验不通过"),
	CONFIG_ERROR(3001,"账号以及相关信息配置错误"),
	RESULT_NULL(3002,"查询不到数据"),
	CITY_AREA_IS_NULL(3003,"当前账户未配置城市区域"),
	HEADER_PARAMS_IS_NULL(3004,"header参数为空"),
	;

	private ErrorCode errorCode;

	private BusinessCode(int code, String message) {
		this.errorCode = new ErrorCode(code, message);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMsg() {
		return errorCode.getMessage();
	}

}
