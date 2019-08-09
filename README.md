# tpl(模版)

> 一个基于Spring Boot & Mybatis-Plus & JWT 的模板项目

## 特性

[x️] spring boot的便捷开发模式    
[x️] 支持mybatis-plus一键生成controller,service,mapper,model          
[x️] 权限认证和授权，JWT令牌颁发  
[x️] mybatis-plus 逻辑删除、自定义分页（从0开始）   
[x️] 自定义方便的validator  
[x️] 统一异常处理，统一返回结果规范  
[x️] fastjson的消息转换，结果转换  
[x️] druid mysql 连接池  
[x️] 自定义logback配置    
[x️] 自定义骚气banner   
[x️] 多环境配置文件    
[ ] and more ......   

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

## 使用


### 导入数据

数据库推荐使用`mysql`，如需使用其它数据库，请根据pom依赖和配置酌情更改，在mysql中新建 `tutorial`数据库，
运行 `src/main/resources/data.sql` 数据脚本新建`user`表，方便 v1 测试。

### 运行

更改`application-dev.properties`的数据库配置，符合你使用的数据库。

直接运行 `TplApplication.java` 即可。

```bash
////////////////////////////////////////////////////////////////////
                    ______        _
                    | ___ \      | |
                    | |_/ /__  __| |_ __ ___
                    |  __/ _ \/ _` | '__/ _ \
                    | | |  __/ (_| | | | (_) |
                    \_|  \___|\__,_|_|  \___/

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//            佛祖保佑       永不宕机     永无BUG                    //
////////////////////////////////////////////////////////////////////


2019-08-09 14:45:30.244  INFO 13295 --- [           main] com.pedro.tpl.TplApplication             : Starting TplApplication on pedrodeMacBook-Pro.local with PID 13295 (/Users/pedro/projects/java/tpl/target/classes started by pedro in /Users/pedro/projects/java/tpl)
2019-08-09 14:45:30.248  INFO 13295 --- [           main] com.pedro.tpl.TplApplication             : The following profiles are active: dev
2019-08-09 14:45:31.567  INFO 13295 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 5000 (http)
2019-08-09 14:45:31.583  INFO 13295 --- [           main] o.a.coyote.http11.Http11NioProtocol      : Initializing ProtocolHandler ["http-nio-5000"]
2019-08-09 14:45:31.592  INFO 13295 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-08-09 14:45:31.592  INFO 13295 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.21]
2019-08-09 14:45:31.693  INFO 13295 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-08-09 14:45:31.693 DEBUG 13295 --- [           main] o.s.web.context.ContextLoader            : Published root WebApplicationContext as ServletContext attribute with name [org.springframework.web.context.WebApplicationContext.ROOT]
2019-08-09 14:45:31.693  INFO 13295 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1375 ms
2019-08-09 14:45:31.732 DEBUG 13295 --- [           main] o.s.b.w.s.ServletContextInitializerBeans : Mapping filters: filterRegistrationBean urls=[/*], characterEncodingFilter urls=[/*], hiddenHttpMethodFilter urls=[/*], formContentFilter urls=[/*], requestContextFilter urls=[/*]
2019-08-09 14:45:31.732 DEBUG 13295 --- [           main] o.s.b.w.s.ServletContextInitializerBeans : Mapping servlets: dispatcherServlet urls=[/], statViewServlet urls=[/druid/*]
2019-08-09 14:45:31.946  INFO 13295 --- [           main] c.a.d.s.b.a.DruidDataSourceAutoConfigure : Init DruidDataSource
2019-08-09 14:45:32.067  INFO 13295 --- [           main] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
2019-08-09 14:45:32.612 DEBUG 13295 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Patterns [/**/favicon.ico] in 'faviconHandlerMapping'
2019-08-09 14:45:32.785  INFO 13295 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-08-09 14:45:32.797 DEBUG 13295 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : ControllerAdvice beans: 0 @ModelAttribute, 0 @InitBinder, 1 RequestBodyAdvice, 1 ResponseBodyAdvice
2019-08-09 14:45:32.850 DEBUG 13295 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : 4 mappings in 'requestMappingHandlerMapping'
2019-08-09 14:45:32.858 DEBUG 13295 --- [           main] o.s.w.s.c.annotation.WebMvcConfigurer    : Default resource handling disabled
2019-08-09 14:45:32.859 DEBUG 13295 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Patterns [/assets/**] in 'resourceHandlerMapping'
2019-08-09 14:45:32.979  INFO 13295 --- [           main] o.a.coyote.http11.Http11NioProtocol      : Starting ProtocolHandler ["http-nio-5000"]
2019-08-09 14:45:33.014  INFO 13295 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 5000 (http) with context path ''
2019-08-09 14:45:33.017  INFO 13295 --- [           main] com.pedro.tpl.TplApplication             : Started TplApplication in 3.55 seconds (JVM running for 4.21)
```