# Java Core Tasks

Набор из пяти заданий по базовой Java: разбор выражений, собственные коллекции, устойчивость к сбоям, стратегии роста массива и сериализация.

Домашнее задание 2 по Java.

## Задания

### 1. Выражения (`task1`)

Разбор и вычисление арифметических выражений (`Expr`).

### 2. Динамический массив (`task2`)

- `DynamicArray` — обобщённый массив с автоматическим расширением.
- `DynamicIntArray` — версия для `int` без упаковки в объекты.

### 3. Соединения с повторными попытками (`task3`)

- `Connection` — интерфейс соединения.
- `StableConnection` — соединение, которое не падает.
- `FaultyConnection` — соединение, которое периодически выбрасывает `ConnectionException`.
- `ConnectionManager` / `DefaultConnectionManager` — получение соединения.
- `FaultyConnectionManager` — менеджер, который работает с ненадёжными соединениями и повторяет попытки.
- `PopularCommandExecutor` — выполнение команд через менеджер соединений.

### 4. Стратегии роста массива (`task4`)

Интерфейс `CapacityStrategy` и три реализации:

| Стратегия | Класс |
|-----------|-------|
| Удвоение ёмкости | `DoblingStrategy` |
| Фиксированный шаг | `FixedIncrementStrategy` |
| Золотое сечение | `GoldenRatioStrategy` |

### 5. Сериализация массива (`task5`)

Интерфейс `ArraySerializer` и четыре реализации, которые выбираются через `SerializerFactory`:

- `BinaryArraySerializer` — бинарный формат;
- `CsvArraySerializer` — CSV;
- `JsonArraySerializer` — JSON;
- `XmlArraySerializer` — XML.

## Структура

```
homework2/src/
├── Main.java
├── task1/Expr.java
├── task2/DynamicArray.java, DynamicIntArray.java
├── task3/          соединения и менеджеры
├── task4/          стратегии роста
└── task5/          сериализаторы и фабрика
```

## Запуск

1. Откройте проект в IntelliJ IDEA (файл `homework2.iml`).
2. Запустите `Main`.

Требуется JDK 17 или новее.

## Автор

Мария Комарова — домашнее задание 2 по Java.
