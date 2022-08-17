Учебный проект Java Middle Developer, модуль серверы приложений

Для локального запуска проекта:

1. Переопределить [settings.xml](conf/settings.xml).
2. Добавить пользователя в конфигурации сервер и в [settings.xml](conf/settings.xml).
3. Запустить сервер.
4. ```mvn clean package```
5. ```mvn -P tomact tomcat7:deploy```

* При использовании Apache Tomcat версия должна быть не ниже 10.
