FROM openjdk:11.0.8-jre-slim

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN apt-get update && apt-get install -y tzdata

WORKDIR /app
COPY ./build/libs .
ENV COMMIT=@@commit

CMD ["sh", "-c", "java -jar -Xms256m -Xmx512m -Dspring.profiles.active=$APP_ENV store.jar" ]