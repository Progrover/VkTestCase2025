### **VK Internship - Тестовое задание** ###

## **Стек:** ##
language: Kotlin
di: Hilt
image: Coil
network: Coroutines, Retrofit
pattern: MVI, multimodule
framework: Compose
minSdk 26

## Build Gradle ##
В проекте создан модуль buildSrc с едиными зависимостями для всего проекта.

Объект *Versions.kt* содержит версии всех зависимостей
*ProjectConfig* регулирует текущую версию билда, джавы и прочих системных инструментов
Файл *Dependencies.kt* помимо констант со строковыми зависимостями содержит расширения на *DependencyHandler*.
Все зависимости сгруппированы по связкам, достаточно прописать в *build.gradle.kts* retrofit() или hilt(), и все необходимые зависимости подтянутся через расширение для *DependencyHandler*
