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

mhq0123-officialwebsite<br>
|---doc<br>
|   |---sql<br>
|   |   |---\*.sql   数据库文件<br>
|   |---api<br>
|   |   |---\*.api   接口说明<br>
|   |---chm<br>
|   |   |---\*.chm   说明手册<br>
|---mhq0123-officialwebsite-config-repository<br>
|   |---local<br>
|   |   |---xxx<br>
|   |   |   |---\*.yml   本地配置<br>
|   |---git<br>
|   |   |---xxx<br>
|   |   |   |---\*.yml   git配置<br>
|---mhq0123-officialwebsite-config-server<br>
|   |---src<br>
|   |   |---lib<br>
|   |   |   |---\*.jar   依赖的本地jar<br>
|   |   |---main<br>
|   |   |   |---java<br>
|   |   |   |   |---com.mhq0123.officialwebsite.configserver<br>
|   |   |   |   |   |---xxx<br>
|   |   |   |   |   |   |---\*.java   业务逻辑<br>
|   |   |   |   |   |---ConfigServerApplication.java   程序入口:开启自动配置、开启服务发现、开启配置对外服务<br>
|   |   |   |   |---org.mhq0123.officialwebsite.configserver<br>
|   |   |   |   |   |---xxx<br>
|   |   |   |   |   |   |---\*.java   辅助工具<br>
|   |   |   |   |   |---ConfigServerConstant.java   常量<br>
|   |   |   |---resources<br>
|   |   |   |   |---application.yml   端口、程序名称、配置仓库、rabbitMq、注册中心配置、日志配置、环境配置<br>
|   |   |   |   |---banner.txt   个性化banner<br>
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境<br>
|   |   |---test<br>
|   |   |   |---java<br>
|   |   |   |   |---xxx<br>
|   |   |   |   |   |---\*Test.java   业务测试<br>
|   |---target   编译目录<br>
|   |---pom.xml   引入spring-cloud-config-server等依赖，spring-boot-maven-plugin等插件<br>
|---mhq0123-officialwebsite-edge-service<br>
|   |---src<br>
|   |   |---lib<br>
|   |   |   |---\*.jar   依赖的本地jar<br>
|   |   |---main<br>
|   |   |   |---java<br>
|   |   |   |   |---com.mhq0123.officialwebsite.edgeservice<br>
|   |   |   |   |   |---xxx<br>
|   |   |   |   |   |   |---\*Path.java   业务逻辑请求映射路径<br>
|   |   |   |   |   |   |---\*Restful.java   业务逻辑rest服务：合法性校验、业务逻辑校验、微服务调用<br>
|   |   |   |   |   |---EdgeServiceApplication.java   程序入口:开启自动配置、服务发现、Feign客户端、ComponentScan、ServletComponentScan、缓存等<br>
|   |   |   |   |---org.mhq0123.officialwebsite.edgeservice<br>
|   |   |   |   |   |---xxx<br>
|   |   |   |   |   |   |---\*.java   辅助工具<br>
|   |   |   |   |   |---EdgeServiceConstant.java   常量<br>
|   |   |   |---resources<br>
|   |   |   |   |---application.yml   端口、程序名称、缓存、断路器、配置服务、rabbitMq、注册中心配置、日志配置、环境配置<br>
|   |   |   |   |---banner.txt   个性化banner<br>
|   |   |   |   |---logback-spring.xml   日志格式、输出目录、归档策略、不同环境<br>
|   |   |---test<br>
|   |   |   |---java<br>
|   |   |   |   |---xxx<br>
|   |   |   |   |   |---\*RestfulTest.java   业务测试<br>
|   |---target   编译目录<br>
|   |---pom.xml   引入spring-cloud-feign、microservice-\*-invoker等依赖，spring-boot-maven-plugin等插件<br>
|---.gitignore   git忽略列表<br>
|---LICENSE   开源协议<br>
|---pom.xml   引入spring-boot、spring-cloud、mhq0123-springleaf等公共依赖；maven-surefire-plugin等公共插件<br>
|---README.md   说明<br>



