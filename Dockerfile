FROM maven:3.3.3

ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve

ADD src /tmp/build/src
        #构建应用
RUN cd /tmp/build && mvn -q -DskipTests=true package \
        #拷贝编译结果到指定目录
        && mv mhq0123-officialwebsite-config-server/target/*.jar /config-server.jar \
        && mv mhq0123-officialwebsite-edge-service/target/*.jar /edge-service.jar \
        && mv mhq0123-officialwebsite-micro-service/mhq0123-officialwebsite-microservice-customer/target/*.jar /microservice-customer.jar \
        && mv mhq0123-officialwebsite-micro-service/mhq0123-officialwebsite-microservice-sms/target/*.jar /microservice-sms.jar \
        && mv mhq0123-officialwebsite-service-gateway/target/*.jar /service-gateway.jar \
        && mv mhq0123-officialwebsite-service-registry/target/*.jar /service-registry.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build

VOLUME /tmp
EXPOSE 8077
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-registry.jar --spring.profiles.active=pro"]
EXPOSE 8088
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-server.jar --spring.profiles.active=pro"]
EXPOSE 8000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-customer.jar --spring.profiles.active=pro"]
EXPOSE 8010
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-sms.jar --spring.profiles.active=pro"]
EXPOSE 8055
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/edge-service.jar --spring.profiles.active=pro"]
EXPOSE 8099
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-gateway.jar --spring.profiles.active=pro"]
