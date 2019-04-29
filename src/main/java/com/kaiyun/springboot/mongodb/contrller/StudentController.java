/**
 * Project Name:springboot-mongodb
 * File Name:StudentController.java
 * Package Name:com.kaiyun.springboot.mongodb.contrller
 * Date:2019年4月26日下午4:29:35
 * Copyright (c) 2019, kaiyun@qk365.com All Rights Reserved.
 *
*/

package com.kaiyun.springboot.mongodb.contrller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaiyun.springboot.mongodb.common.BusinessCode;
import com.kaiyun.springboot.mongodb.common.CommonResp;
import com.kaiyun.springboot.mongodb.common.Page;
import com.kaiyun.springboot.mongodb.common.RespUtil;
import com.kaiyun.springboot.mongodb.dto.PageDTO;
import com.kaiyun.springboot.mongodb.model.Student;
import com.kaiyun.springboot.mongodb.server.StudentService;
import com.mongodb.client.result.UpdateResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName:StudentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2019年4月26日 下午4:29:35 <br/>
 * @author   kaiyun
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value = "MongoDB测试项目", tags = "V1.0")
@RestController
public class StudentController {
	
	@Autowired
    private StudentService studentService;
	
	@ApiOperation(value = "add Student", notes = "add Student")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResp<?> add(@RequestBody @Valid Student student, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<Student>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
		Student stu = studentService.add(student);
        return  RespUtil.buildVo(stu, BusinessCode.SUCCESS.getErrorCode());
    }
    
	@ApiOperation(value = "update Student", notes = "update Student")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResp<?> update(@RequestBody @Valid Student student, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<Object>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
		UpdateResult updateResult = studentService.update(student);
        return RespUtil.buildVo(updateResult, BusinessCode.SUCCESS.getErrorCode());
    }
 
	@ApiOperation(value = "根据name查Student", notes = "根据name查Student")
    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public CommonResp<?> findByName(@RequestBody @Valid String name, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<Student>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
		Student student = studentService.findByName(name);
        return RespUtil.buildVo(student, BusinessCode.SUCCESS.getErrorCode());
    }
    
	@ApiOperation(value = "根据sex查Student", notes = "根据sex查Student")
    @RequestMapping(value = "/findBySex", method = RequestMethod.POST)
    public CommonResp<?> findBySex(@RequestBody @Valid String sex, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<List<Student>>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
		List<Student> studentList =  studentService.findBySex(sex);
        return RespUtil.buildVo(studentList, BusinessCode.SUCCESS.getErrorCode());
    }
	
	@ApiOperation(value = "查所有Student", notes = "查所有Student")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public CommonResp<?> findAll(){
		List<Student> studentList =  studentService.findAll();
        return RespUtil.buildVo(studentList, BusinessCode.SUCCESS.getErrorCode());
    }
	
	@ApiOperation(value = "分页查Student", notes = "分页查Student")
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST)
    public CommonResp<?> findByPage(@RequestBody @Valid PageDTO dto, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<Page<Student>>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
		Page<Student> page =  studentService.findPage(dto);
        return RespUtil.buildVo(page, BusinessCode.SUCCESS.getErrorCode());
    }
	
	@ApiOperation(value = "查所有Student的数量", notes = "查所有Student的数量")
    @RequestMapping(value = "/findCount", method = RequestMethod.POST)
    public CommonResp<?> count(){
		long count =  studentService.count();
        return RespUtil.buildVo(count, BusinessCode.SUCCESS.getErrorCode());
    }
 
	@ApiOperation(value = "delete Student", notes = "delete Student")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResp<?> delete(@RequestBody @Valid String id, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return CommonResp.<Integer>builder().result(BusinessCode.PARAMS_ERROR.getErrorCode().getCode())
                    .message(bindingResult.getFieldError().getDefaultMessage()).data(null).build();
        }
        studentService.delete(id);
        return RespUtil.buildErrorVo(BusinessCode.SUCCESS.getErrorCode());
    }
}

