package petrovsky.lessons.lesson21.homework


//Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести
// соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.
fun Any.analyzeDataType() : String {
    return when(this) {
        is String -> "This is string: $this."
        is Number -> "This is number: $this."
        is List<*> -> "This is list, count: ${this.size}."
        is Map<*,*> -> "This is map, count: ${this.size}."
        else -> "This is undefined type."
    }
}
//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно
// безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1. Используйте as? для
// безопасного приведения типа.
fun Any.safeCastToList() : Number {
    return (this as? List<*>)?.size ?: -1
}
//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент
// можно привести к типу String. В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
fun Any?.getStringLengthOrZero() : Number {
    return (this as? String)?.length ?: 0
}
//Задача 4
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа (в виде числа или строки,
// например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат,
// если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.
fun Any.toSquare() : Double {
    return when (this) {
        is Number -> toDouble() * toDouble()
        is String -> toDouble() * toDouble()
        else -> 0.0
    }
}
//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех
// целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
fun List<Any>.sumIntOrDoubleValues() : Number {
    return sumOf { item ->
        when (item) {
            is Int -> item.toDouble()
            is Double -> item
            else -> 0.0
        }
    }
}
//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
// Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести
// предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение
// программы.
fun Any.tryCastToListAndPrint () {
    val result = ( this as? List<*>)?.map { (it as? String) ?: "This is not a string" }
        ?: "Failed to convert"
    println(result)
}
fun main() {
    val str = "STRING"
    val num = 12334;
    val list = listOf<Number>(1,2,3,4,5)
    val map = mapOf(5 to 5, 6 to 6)
    val set = setOf(1,2,3,4,5,6)
    val list2 = listOf(1,1.0, "2232", "draw", 8)
    println(str.analyzeDataType())
    println(num.analyzeDataType())
    println(list.analyzeDataType())
    println(map.analyzeDataType())
    println(set.analyzeDataType())
    println(str.safeCastToList())
    println(list.safeCastToList())
    println(str.getStringLengthOrZero())
    println(num.getStringLengthOrZero())
    println(list2.sumIntOrDoubleValues())
    list2.tryCastToListAndPrint()
    num.tryCastToListAndPrint()
}