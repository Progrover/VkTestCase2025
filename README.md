# **VK Internship - Тестовое задание** #
***
## **Стек:** ##

* Language: **Kotlin**
* DI: **Hilt**
* Image: **Coil**
* Network: **Coroutines, Retrofit**
* Pattern: **MVI, multimodule**
* Framework:**Compose**
* MinSdk **26**
---
## Build Gradle ##

В проекте создан модуль **buildSrc** с едиными зависимостями для всего проекта.

Объект *Versions.kt* содержит версии всех зависимостей
*ProjectConfig* регулирует текущую версию билда, джавы и прочих системных инструментов
Файл *Dependencies.kt* помимо констант со строковыми зависимостями содержит расширения на *DependencyHandler*.
Все зависимости сгруппированы по связкам, достаточно прописать в *build.gradle.kts* retrofit() или hilt(), и все необходимые зависимости подтянутся через расширение для *DependencyHandler*
