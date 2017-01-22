FROM maven:3.3.3

#添加源码
ADD pom.xml /tmp/build/
#解析依赖
#RUN cd /tmp/build && mvn -q dependency:resolve

ADD mhq0123-officialwebsite-config-server /tmp/build/mhq0123-officialwebsite-config-server
ADD mhq0123-officialwebsite-edge-service /tmp/build/mhq0123-officialwebsite-edge-service
ADD mhq0123-officialwebsite-micro-service /tmp/build/mhq0123-officialwebsite-micro-service
ADD mhq0123-officialwebsite-service-gateway /tmp/build/mhq0123-officialwebsite-service-gateway
ADD mhq0123-officialwebsite-service-registry /tmp/build/mhq0123-officialwebsite-service-registry
ADD mhq0123-officialwebsite-web-client /tmp/build/mhq0123-officialwebsite-web-client

ADD start.sh /start.sh

#构建应用
#拷贝编译结果到指定目录
RUN cd /tmp/build && mvn -q -DskipTests=true package
RUN cd /tmp/build && mv mhq0123-officialwebsite-config-server/target/*SNAPSHOT.jar /config-server.jar \
        && mv mhq0123-officialwebsite-edge-service/target/*SNAPSHOT.jar /edge-service.jar \
        && mv mhq0123-officialwebsite-micro-service/mhq0123-officialwebsite-microservice-customer/target/*SNAPSHOT.jar /microservice-customer.jar \
        && mv mhq0123-officialwebsite-micro-service/mhq0123-officialwebsite-microservice-sms/target/*SNAPSHOT.jar /microservice-sms.jar \
        && mv mhq0123-officialwebsite-service-gateway/target/*SNAPSHOT.jar /service-gateway.jar \
        && mv mhq0123-officialwebsite-service-registry/target/*SNAPSHOT.jar /service-registry.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build

VOLUME /tmp

EXPOSE 8077 8088 8000 8010 8055 8099

CMD ["sh","start.sh"]