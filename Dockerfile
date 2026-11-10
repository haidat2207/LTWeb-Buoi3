# ===== Giai đoạn 1: build WAR =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn -B clean package -DskipTests \
    && mv target/*.war target/ROOT.war

# ===== Giai đoạn 2: chạy trên Tomcat 11 =====
FROM tomcat:11.0-jdk21-temurin
WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

# ROOT.war => truy cập thẳng https://ten-app.onrender.com/ (không có /Buoi3)
COPY --from=build /app/target/ROOT.war webapps/ROOT.war

# Render cấp cổng qua biến PORT; mặc định 8080 khi chạy local
ENV PORT=8080
# Giới hạn RAM cho gói free (512 MB)
ENV CATALINA_OPTS="-Xms64m -Xmx300m"

EXPOSE 8080

# Đổi cổng Connector trong server.xml theo $PORT rồi chạy Tomcat
CMD sed -i "s/Connector port=\"8080\"/Connector port=\"${PORT}\"/" conf/server.xml && exec catalina.sh run