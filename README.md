# IntegriVideo
Чеклист

Sign Up
Log In
Projects
Billing 
Log Out

1. Зарегестрироваться

2. Войти в аккаунт

3. Создать новый проект 
4. Изменить проект
5. Добавить несколько доментов
6. Удалить домен

7. Создать новую компоненту
8. Изменить компоненту
9.  Добавить новый payment method
11. Добавить карту
12. Последнюю добавленную крату сделать Default
13. Удалить карту

14. Выйти из аккаунта

Команды (Тема 14. Maven ):
1.Обновить версии всех библиотек в проекте:
mvn versions:use-latest-versions
2.Запустить тесты используя mvn clean test команду:
mvn clean test
3.Использовать параметры для запуска конкретных тестов и методов:
mvn test -Dtest=ChatTests#editMessage
mvn test -Dtest=ChatTests#editMessage + deleteMessage

4.Создать альтернативный pom.xml и запустить из него mvn билд

5.Пробросить параметр из mvn command line внутрь теста
mvn test -Dtest=ChatTests#sendMessageByClick -DtextFromTerminal=Hello