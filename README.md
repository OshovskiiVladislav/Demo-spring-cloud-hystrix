# demo-spring-cloud-hystrix

--- 

Тренировочный проект для ознакомления с технологией Spring Cloud Hystrix with Feign Clients.

# Модули:

1. lib-route: общая для всех модулей информация;
2. pet-store: модуль с REST-контроллером, принимающий запросы на чтение и удаление котов из базы данных;
3. hystrix-client: модуль, который является клиентом у pet-store, использующий технологию Spring Cloud Hystrix интегрированную в Spring Cloud OpenFeign
4. eureka-server: модуль, использующий Spring Cloud Eureka
