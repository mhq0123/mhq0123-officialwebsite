FROM maven:3.3.3

#添加源码
ADD pom.xml /tmp/build/
ADD src /tmp/build/src
#解析依赖
#RUN cd /tmp/build && mvn -q dependency:resolve
#构建应用
RUN cd /tmp/build && mvn -q -DskipTests=true package \
#拷贝编译结果到指定目录
        && mv target/*.jar /service-registry.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build

VOLUME /tmp
EXPOSE 8099
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-gateway.jar --spring.profiles.active=prod"]
