FROM eclipse-temurin:11-alpine
RUN apk add --no-cache bash inotify-tools maven
ENV HOME=/app
RUN mkdir -p $HOME
WORKDIR $HOME