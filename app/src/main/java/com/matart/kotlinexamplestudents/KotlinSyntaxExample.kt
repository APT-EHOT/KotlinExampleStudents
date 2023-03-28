package com.matart.kotlinexamplestudents

// Функция main - точка входа в программу в Kotlin
fun main() {
    //==============Переменные===============
    // val для неизменяемых переменных
    val a = 10
    // Поддерживает отложенную инициализацию, в таком случае тип нужно указывать явно
    val b: String
    b = "Hehehe"

    // var для изменяемых переменных
    var c = 10
    c += 15

    //==============Циклы===============

    // Цикл для вывода чисел от 0 до 9
    for (i in 0 until 10) {
        print("$i ")
    }

    // Цикл для вывода каждого 10 числа от 100 до 0
    for (i in 100 downTo 0 step 10) {
        print("$i ")
    }

    val array = intArrayOf(10, 20, 30, 40)
    // Цикл foreach для итерации по структурам данных
    for (item in array) {
        print("$item ")
    }

    //==============Экземпляры классов===============

    // Создание экземпляра класса (без модификатора new!!!)
    val car = Car("black", 10000f, 150f)

    // Возможность не указывать некоторые аргументы, если они имеют значение по умолчанию (см. класс Car)
    // также поддерживаются именованные аргументы
    val car2 = Car(maxSpeed = 200f)

    //==============NULL-SAFETY===============
    // Система проверок на null для избегания непредвиденных NullPointerException

    // Котлин поддерживает функции внутри функций
    // Тип возвращаемого значения с ?, тк поддерживает значения типа null
    fun isEvenOrNull(num: Int): Boolean? =
        if (num == 0) null else (num % 2 == 0)

    // Элвис-оператор (значение справа от него присвоится переменной, если слева от него будет null)
    val result: Boolean = isEvenOrNull(0) ?: false

    // Нуллабельная переменная (поддерживаеет значение null)
    val nullableResult: Boolean? = isEvenOrNull(0)

    // Если переменная равна null, то этот вызов метода не выполнится
    nullableResult?.not()
    // В таком случае значение null грубо проигнорируется, что может привести к NullPointerException
    nullableResult!!.not()
}

// Функция без возвращаемого значения
fun printMyName(name: String) {
    // Экранирование переменных для вывода
    print("Hello, my name is $name and it is ${name.length} characters long!")
}

// Функция с возвращаемым значением
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Однострочная функция (тип возвращаемого значения для таких указывать не обязательно)
fun isEven(num: Int): Boolean = (num % 2 == 0)

// Однострочная функция и пример использования оператора when
fun getMonthName(monthNumber: Int) =
    when (monthNumber) {
        1 -> "JAN"
        2 -> "FEB"
        3 -> "MAR"
        4 -> "APR"
        5 -> "MAY"
        6 -> "JUN"
        7 -> "JUL"
        8 -> "AUG"
        9 -> "SEP"
        10 -> "OCT"
        11 -> "NOV"
        12 -> "DEC"
        else -> {
            "Error"
        }
    }

// Пример создания класса с тремя полями в первичном конструкторе
// Модификатор open открывает класс/поля/методы для наследования
open class Car(
    open val color: String = "white", // Значение по умолчанию для поля
    open val price: Float = 0f,
    open val maxSpeed: Float = 0f
) {
    var occupiedSeats = 0

    open fun load() {
        occupiedSeats = 4
    }
}

class Truck(
    override val color: String = "white", // модификатор override обязателен для переопределения полей и методов
    override val price: Float = 0f,
    override val maxSpeed: Float = 0f
) : Car(color, price, maxSpeed) /* наследование от класса Car с перегрузкой конструктора */ {

    var currentLoad = 0f

    // Перегруженная функция родительского класса
    override fun load() {
        currentLoad = 100f
    }
}