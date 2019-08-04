package com.pedro.tpl.configure;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.pedro.tpl.common.exception.ExceptionHandler;
import com.pedro.tpl.common.interceptor.AuthInterceptor;
import com.pedro.tpl.common.interceptor.RequestLogInterceptor;
import com.pedro.tpl.common.token.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Value("${tpl.token-secret}")
    private String tokenSecret = "";

    @Value("${tpl.token-access-expire}")
    private Long tokenAccessExpire = 3600L;

    @Value("${tpl.token-refresh-expire}")
    private Long tokenRefreshExpire = 2592000L;

    /**
     * 记录请求日志
     */
    @Bean
    public RequestLogInterceptor requestLogInterceptor() {
        return new RequestLogInterceptor();
    }

    /**
     * mybatis-plus 分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 支持 delete_time 逻辑删除
     */
    // @Bean
    // public LogicInterceptor logicInterceptor() {
    //     return new LogicInterceptor();
    // }

    /**
     * 支持逻辑删除
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector();
    }

    /**
     * 权限校验
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }


    /**
     * 全局异常处理
     */
    @Bean
    public ExceptionHandler exceptionHandler() {
        return new ExceptionHandler();
    }

    /**
     * JWT
     */
    @Bean
    public JWT jwter() {
        String secret = tokenSecret;
        Long accessExpire = tokenAccessExpire;
        Long refreshExpire = tokenRefreshExpire;
        if (accessExpire == null) {
            accessExpire = 60 * 60L;
        }
        if (refreshExpire == null) {
            refreshExpire = 60 * 60 * 24 * 30L;
        }
        return new JWT(secret, accessExpire, refreshExpire);
    }

    /**
     * 接口中，自动转换的有：驼峰转换为下划线，空值输出null
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
            jacksonObjectMapperBuilder.failOnUnknownProperties(false);
            jacksonObjectMapperBuilder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        };
    }
}
