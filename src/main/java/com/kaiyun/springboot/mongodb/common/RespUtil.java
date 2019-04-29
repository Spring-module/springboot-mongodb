package com.kaiyun.springboot.mongodb.common;

public class RespUtil {

	/**
	 * 封装响应信息
	 * 
	 * @param args
	 */
	public static <T> CommonResp<T> buildSuccessVo() {
		return buildVo(null, BusinessCode.SUCCESS.getErrorCode());
	}
	
	/**
	 * 封装错误响应信息
	 * 
	 * @param args
	 */
	public static <T> CommonResp<T> buildErrorVo(ErrorCode errorCode) {
		return buildVo(null,errorCode);
	}
	
	/**
	 * 封装错误响应信息
	 * 
	 * @param args
	 */
	public static <T> CommonResp<T> buildErrorVo(int errCode, String errMessage) {
		return buildVo(null,new ErrorCode(errCode, errMessage) );
	}

	/**
	 * 封装响应信息
	 * 
	 * @param args
	 */
	public static <T> CommonResp<T> buildVo(T obj, ErrorCode errorCode) {
		CommonResp<T> responseVo = CommonResp.<T>builder().build();
		if (errorCode != null) {
			responseVo.setData(obj);
			responseVo.setResult(errorCode.getCode());
			responseVo.setMessage(errorCode.getMessage());
		} else {
			responseVo.setData(obj);
			ErrorCode successCode = BusinessCode.SUCCESS.getErrorCode();
			responseVo.setResult(successCode.getCode());
			responseVo.setMessage("成功");
		}
		return responseVo;
	}
}