FROM openjdk:17
EXPOSE 8081
ADD staging/TradeService.jar TradeService.jar
ENTRYPOINT ["java","-jar","/TradeService.jar"]
