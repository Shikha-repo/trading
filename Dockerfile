FROM openjdk:17

WORKDIR /app
COPY . . 

EXPOSE 8081

ADD target/TradeService.jar TradeService.jar
ENTRYPOINT ["java","-jar","/TradeService.jar"]
