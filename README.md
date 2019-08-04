# tpl(模版)

> 一个基于Spring Boot & Mybatis-Plus & JWT 的模板项目

## 特性

[☑️] spring boot的便捷开发模式    
[☑️] 支持mybatis-plus一键生成controller,service,mapper,model          
[☑️] 权限认证和授权，JWT令牌颁发  
[☑️] mybatis-plus 逻辑删除、自定义分页（从0开始）   
[☑️] 自定义方便的validator  
[☑️] 统一异常处理，统一返回结果规范  
[☑️] fastjson的消息转换，结果转换  
[☑️] druid mysql 连接池  
[☑️] and more ......  

## 目录结构

```bash
├── common  //基础类库
│   ├── exception  //异常相关
│   ├── interceptor  //拦截器
│   ├── mybatis  // mybatis相关
│   ├── result // 返回结果
│   ├── token  // 令牌
│   └── validator // 校验器
├── configure // 配置
│   ├── CommonConfig.java
│   └── WebConfig.java
└── v1 // v1 api 相关
    ├── controller
    ├── mapper
    ├── model
    └── service
        └── impl
```
