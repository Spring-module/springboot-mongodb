package com.kaiyun.springboot.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by fanya on 2017/4/10.
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swaggers {
	
	/**
	 * apiInfo:apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）. <br/>
	 *
	 * @return
	 * @since JDK 1.8
	 * @author kaiyun
	 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MongoDB测试项目")
                .description("MongoDB测试项目")
                .version("V1.0")
                .build();
    }
    
    /**
     * createRestApi:创建Docket的Bean. <br/>
     * 1、select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * 	本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
     *
     * @return
     * @since JDK 1.8
     * @author kaiyun
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kaiyun.springboot.mongodb.contrller"))
                .paths(PathSelectors.any())
                .build();
    }
    
}
