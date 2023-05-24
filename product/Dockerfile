FROM ubuntu as builder
RUN apt-get update & apt-get install openjdk-17-jdk
COPY ./build/libs/app.jar /mouseeye/app
WORKDIR /mouseeye/app
