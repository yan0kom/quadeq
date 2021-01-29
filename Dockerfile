FROM jetty:8.1.16-jre7

COPY target/quadeq-1.0-SNAPSHOT.war $JETTY_HOME/webapps/ROOT.war
RUN echo "-Dorg.apache.jasper.compiler.disablejsr199=true" >> $JETTY_HOME/start.ini
ENV h2_database_location /var/lib/quadeq/database.h2

EXPOSE 8080
