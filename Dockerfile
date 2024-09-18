FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_javarush_artem_bot
ENV BOT_TOKEN=7259731611:AAEjyK4T7X0cbY1Uu7rV4uqTGpUptLC8guI
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]