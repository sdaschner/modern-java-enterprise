FROM open-liberty:javaee8-java12

COPY src/main/liberty/config/server.xml /config/

COPY target/coffee-shop.war /config/dropins/