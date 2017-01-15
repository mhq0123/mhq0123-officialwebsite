# mhq0123-officialwebsite
个人官网展示

## 个人作品说明

|系统|说明|
|:---|:---|
|mhq0123-assistant|个人助理|
|mhq0123-forum|论坛系统|
|mhq0123-ranking|榜单系统|
|mhq0123-microviedo|小视频网|
|mhq0123-scheduler|调度平台|
|mhq0123-balance|对账系统|
|mhq0123-blog|个人博客|
|mhq0123-springleaf|春叶开发平台|

## 模块说明

|模块||说明|
|:---|:---|:---|
|mhq0123-officialwebsite-web-client||web客户端|
|mhq0123-officialwebsite-service-gateway||服务路由网关|
|mhq0123-officialwebsite-service-registry||服务注册中心|
|mhq0123-officialwebsite-edge-service||边界服务|
|mhq0123-officialwebsite-micro-service||微服务集|
| |mhq0123-officialwebsite-microservice-customer|客户服务|
| |mhq0123-officialwebsite-microservice-customer-invoker|客户服务调用器|
| |mhq0123-officialwebsite-microservice-sms|短讯服务|
| |mhq0123-officialwebsite-microservice-sms-invoker|短讯服务调用器|
|mhq0123-officialwebsite-config-server||配置服务|
|mhq0123-officialwebsite-config-repository||配置仓库|

## 数据表说明

|数据表|说明|
|:---|:---|
|customer_account|客户--账号表|
|customer_account_history |客户--账号变更历史表|
|customer_extra_information |客户--扩展信息表|
|customer_settings |客户--设置表|
|customer_login |客户--当前登陆表|
|customer_login_history |客户--登陆历史表|

## 开发规范
```Java
mhq0123-officialwebsite
|---doc
|   |---sql
|   |   |---*.sql   数据库文件
|   |---api
|   |   |---*.api   接口说明
|   |---chm
|   |   |---*.chm   说明手册
|---mhq0123-officialwebsite-config-repository
|   |---local
|   |   |---xxx
|   |   |   |---*.yml   本地配置
|   |---git
|   |   |---xxx
|   |   |   |---*.yml   git配置
|---mhq0123-officialwebsite-config-server
|   |---src
|   |   |---lib
|   |   |   |---*.jar   依赖的本地jar
|   |   |---main
|   |   |   |---java
|   |   |   |   |---com.mhq0123.officialwebsite.configserver
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   业务逻辑
|   |   |   |   |   |---ConfigServerApplication.java   程序入口:开启自动配置、开启服务发现、开启配置对外服务
|   |   |   |   |---org.mhq0123.officialwebsite.configserver
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   辅助工具
|   |   |   |   |   |---ConfigServerConstant.java   常量
|   |   |   |---resources
|   |   |   |   |---application.yml   端口、程序名称、配置仓库、rabbitMq、注册中心配置、日志配置、环境配置
|   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |---test
|   |   |   |---java
|   |   |   |   |---xxx
|   |   |   |   |   |---*Test.java   业务测试
|   |---target   编译目录
|   |---pom.xml   引入spring-cloud-config-server等依赖，spring-boot-maven-plugin等插件
|---mhq0123-officialwebsite-edge-service
|   |---src
|   |   |---lib
|   |   |   |---*.jar   依赖的本地jar
|   |   |---main
|   |   |   |---java
|   |   |   |   |---com.mhq0123.officialwebsite.edgeservice
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*XxxPath.java   业务逻辑请求映射路径
|   |   |   |   |   |   |---*XxxRestful.java   业务逻辑rest服务：合法性校验、业务逻辑校验、微服务调用
|   |   |   |   |   |---EdgeServiceApplication.java   程序入口:开启自动配置、服务发现、Feign客户端、ComponentScan、ServletComponentScan、Import配置、缓存等
|   |   |   |   |---org.mhq0123.officialwebsite.edgeservice
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   辅助工具
|   |   |   |   |   |---EdgeServiceConstant.java   常量
|   |   |   |---resources
|   |   |   |   |---application.yml   端口、程序名称、缓存、断路器、配置服务、rabbitMq、注册中心配置、日志配置、环境配置
|   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |---test
|   |   |   |---java
|   |   |   |   |---xxx
|   |   |   |   |   |---*RestfulTest.java   业务测试
|   |---target   编译目录
|   |---pom.xml   引入spring-cloud-feign、microservice-*-invoker等依赖，spring-boot-maven-plugin等插件
|---mhq0123-officialwebsite-micro-service
|   |---mhq0123-officialwebsite-microservice-xxx
|   |   |---src
|   |   |   |---lib
|   |   |   |   |---*.jar   依赖的本地jar
|   |   |   |---main
|   |   |   |   |---java
|   |   |   |   |   |---com.mhq0123.officialwebsite.microservice.xxx
|   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |---mapper
|   |   |   |   |   |   |   |   |---*YyyMapper.java   mybatis数据表操作持久接口
|   |   |   |   |   |   |   |---repository
|   |   |   |   |   |   |   |   |---*YyyRepository.java   非数据表操作的持久类
|   |   |   |   |   |   |   |---service
|   |   |   |   |   |   |   |   |---*YyyService.java   业务逻辑校验、业务逻辑实现、持久层调用
|   |   |   |   |   |   |   |---*YyyController.java   业务逻辑控制层：合法性校验、业务逻辑调用
|   |   |   |   |   |   |---MicroServiceXxxApplication.java   程序入口:开启自动配置、服务发现、事务驱动、MapperScan、ComponentScan、Import配置、缓存等
|   |   |   |   |   |---org.mhq0123.officialwebsite.microservice.xxx
|   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |---*.java   辅助工具
|   |   |   |   |   |   |---MicroServiceXxxConstant.java   常量
|   |   |   |   |---resources
|   |   |   |   |   |---mapper
|   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |---*YyyMapper.xml   mybatis数据表操作sql
|   |   |   |   |   |---templates
|   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |---*.html   模板页面
|   |   |   |   |   |---application.yml   端口、程序名称、缓存、页面乱码、邮件、数据源、模板、mybatis、配置服务、rabbitMq、注册中心配置、日志配置、环境配置
|   |   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |   |---ehcache.xml   缓存策略
|   |   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |   |---test
|   |   |   |   |---java
|   |   |   |   |   |---yyy
|   |   |   |   |   |   |---*YyyControllerTest.java   业务测试
|   |   |---target   编译目录
|   |   |---pom.xml   引入microservice-*-invoker、mybatis-spring-boot-starter等依赖，spring-boot-maven-plugin等插件
|   |---mhq0123-officialwebsite-microservice-xxx-invoker
|   |   |---src
|   |   |   |---lib
|   |   |   |   |---*.jar   依赖的本地jar
|   |   |   |---main
|   |   |   |   |---java
|   |   |   |   |   |---com.mhq0123.officialwebsite.microservice.xxx.invoker
|   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |---bean
|   |   |   |   |   |   |   |   |---XxxYyy.java   实体类定义含oval校验框架校验规则
|   |   |   |   |   |   |   |---hystrix
|   |   |   |   |   |   |   |   |---XxxYyyHystrix.java   断路器实现
|   |   |   |   |   |   |   |---type
|   |   |   |   |   |   |   |   |---XxxYyyType.java   类型数据字典
|   |   |   |   |   |   |   |---XxxYyyClient.java   微服务映射接口定义、断路器配置
|   |   |   |   |   |   |   |---XxxYyyPath.java   映射路径
|   |   |   |   |   |   |---XxxInvokerConstant.java   服务名等常量定义
|   |   |   |   |---resources
|   |   |   |---test
|   |   |   |   |---java
|   |   |   |   |   |---yyy
|   |   |   |   |   |   |---*YyyControllerTest.java   调用demo
|   |   |---target   编译目录
|   |   |---pom.xml   引入spring-cloud-starter-feign等依赖
|   |---pom.xml   引入mysql-connector-java等公共依赖
|---mhq0123-officialwebsite-service-gateway
|   |---src
|   |   |---lib
|   |   |   |---*.jar   依赖的本地jar
|   |   |---main
|   |   |   |---java
|   |   |   |   |---com.mhq0123.officialwebsite.servicegateway
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   过滤控制
|   |   |   |   |   |---ServiceGatewayApplication.java   程序入口:开启自动配置、开启服务发现、路由网关、import配置等
|   |   |   |   |---org.mhq0123.officialwebsite.servicegateway
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   辅助工具
|   |   |   |   |   |---ServiceGatewayConstant.java   常量
|   |   |   |---resources
|   |   |   |   |---application.yml   端口、程序名称、路由配置、断路器配置、注册中心配置、日志配置、环境配置
|   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |---test
|   |   |   |---java
|   |   |   |   |---xxx
|   |   |   |   |   |---*Test.java   测试
|   |---target   编译目录
|   |---pom.xml   引入spring-cloud-starter-zuul等依赖，spring-boot-maven-plugin等插件
|---mhq0123-officialwebsite-service-registry
|   |---src
|   |   |---lib
|   |   |   |---*.jar   依赖的本地jar
|   |   |---main
|   |   |   |---java
|   |   |   |   |---com.mhq0123.officialwebsite.serviceregistry
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   逻辑控制
|   |   |   |   |   |---ServiceRegistryApplication.java   程序入口:开启自动配置、开启服务中心
|   |   |   |   |---org.mhq0123.officialwebsite.serviceregistry
|   |   |   |   |   |---xxx
|   |   |   |   |   |   |---*.java   辅助工具
|   |   |   |   |   |---ServiceRegistryConstant.java   常量
|   |   |   |---resources
|   |   |   |   |---application.yml   端口、程序名称、配置仓库、rabbitMq、注册中心配置、日志配置、环境配置
|   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |---test
|   |   |   |---java
|   |   |   |   |---xxx
|   |   |   |   |   |---*Test.java   测试
|   |---target   编译目录
|   |---pom.xml   引入spring-cloud-starter-eureka-server等依赖，spring-boot-maven-plugin等插件
|---mhq0123-officialwebsite-client   客户端
|   |---mhq0123-officialwebsite-client-web   web客户端
|   |   |---src
|   |   |   |---main
|   |   |   |   |---java
|   |   |   |   |   |---com.mhq0123.officialwebsite.client.web
|   |   |   |   |   |   |---ClientWebApplication.java   程序入口:开启自动配置
|   |   |   |   |---resources
|   |   |   |   |   |---static
|   |   |   |   |   |   |---css
|   |   |   |   |   |   |   |---*.css
|   |   |   |   |   |   |---image
|   |   |   |   |   |   |   |---jpg
|   |   |   |   |   |   |   |   |---*.jpg
|   |   |   |   |   |   |   |---gif
|   |   |   |   |   |   |   |   |---*.gif
|   |   |   |   |   |   |   |---png
|   |   |   |   |   |   |   |   |---*.png
|   |   |   |   |   |   |   |---svg
|   |   |   |   |   |   |   |   |---*.svg
|   |   |   |   |   |   |---js
|   |   |   |   |   |   |   |---*.js
|   |   |   |   |   |   |---index.html   首页
|   |   |   |   |   |---templates
|   |   |   |   |   |   |---xxx
|   |   |   |   |   |   |   |---yyy
|   |   |   |   |   |   |   |   |---*.html   模板页面
|   |   |   |   |   |   |   |---*.html   模板页面
|   |   |   |   |   |---application.yml   端口、程序名称、页面乱码、模板、日志配置、环境配置
|   |   |   |   |   |---banner.txt   个性化banner
|   |   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境
|   |   |---target   编译目录
|   |   |---pom.xml   引入spring-boot-starter-thymeleaf等依赖，spring-boot-maven-plugin等插件
|   |---mhq0123-officialwebsite-client-h5   h5客户端
|   |---mhq0123-officialwebsite-client-ios   ios客户端
|   |---mhq0123-officialwebsite-client-android   安卓客户端
|---.gitignore   git忽略列表
|---LICENSE   开源协议
|---pom.xml   引入spring-boot、spring-cloud、mhq0123-springleaf等公共依赖；maven-surefire-plugin等公共插件
|---README.md   说明
```

