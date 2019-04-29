/**
 * Project Name:springboot-mongodb
 * File Name:ErrorCode.java
 * Package Name:com.kaiyun.springboot.mongodb.common
 * Date:2019年4月26日下午4:42:41
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.common;
/**
 * ClassName:ErrorCode <br/>
 * Function: 错误码. <br/>
 * Date:     2019年4月26日 下午4:42:41 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ErrorCode {

	private int code;

	private String message;
	
	public ErrorCode(){
		
	}

	public ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	

	public void setErrCode(int code) {
		this.code = code;
	}

	public void setErrMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errCode
	 */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorCode other = (ErrorCode) obj;
		if (code != other.code)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	public String toString() {
		return code + "-" + message;
	}
}


