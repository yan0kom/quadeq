### Сайт для решения квадратных уравнений
Используется: JDK 7, Lombok 1.18.16, Spring 3.2.18, EclipseLink 2.6.8, H2 1.4.200, Eclipse Jetty 8.1, JSP, jQuery 3.5.1

Путь для хранения файла базы данных H2 задается переменной окружения `h2_database_location`  
Например: `export h2_database_location=/var/lib/quadeq/database.h2`  
Если `h2_database_location` не определена, то используется путь `${user.home}/.quadeq/database.h2`  
 
Сборка проекта: `mvn package`  
Сборка docker image: `mvn package docker:build`  
Запуск контейнера: `mvn docker:start`  
&nbsp;&nbsp;после запуска сайт доступен по адресу http://localhost:8080/  
Остановка контейнера: `mvn -Ddocker.keepContainer docker:stop`  
Остановка и удаление контейнера: `mvn docker:stop`  
  
TODO:
- хранить в БД и возвращать клиенту timestamp в UTC, а уже в браузере переводить в локальное время
- paging истории вычислений
