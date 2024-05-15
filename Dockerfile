FROM openjdk:17
EXPOSE 8081
ADD target/TradeService.jar TradeService.jar
ENTRYPOINT ["java","-jar","/TradeService.jar"]