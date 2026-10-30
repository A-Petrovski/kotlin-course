package petrovsky.lessons.lesson16.homework

import javax.security.auth.kerberos.KerberosCredMessage
import kotlin.math.sin

//Переопределение методов
//
//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
abstract class Animal{
    open fun makeSound (){
        println("This animal makes no sound.")
    }
}

class Dog: Animal (){
    override fun makeSound() {
        println("Bark")
    }
}

class Cat: Animal (){
    override fun makeSound() {
        println("Meow")
    }
}

class Bird: Animal (){
    override fun makeSound() {
        println("Tweet")
    }
}

//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
abstract class Shape {
    open fun area (){
        println("Need to use integral")
    }
}

class Circle (private val radius: Double): Shape () {
    override fun area() {
        println("The area of Circle is: ${3.14*radius*radius}")
    }
}

class Square (private val sideA: Double, private val sideB: Double): Shape () {
    override fun area () {
        println("The area of Square is: ${sideA*sideB}")
    }
}

class Triangle (private val sideA: Double, private val sideB: Double, private val angle: Double): Shape () {
    override fun area () {
        println("The area of Triangle is: ${0.5*sideA*sideB*sin(angle)}")
    }
}



//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте
abstract class Printer (private val str: String) {
    open fun print () {
        println("Base print of \"$str\"")
    }
}

class LaserPrinter (private val str: String): Printer (str){
    override fun print() {
        val words = str.split(" ")
        for (word in words)
            println("\u001B[30m\u001B[47m$word\u001B[0m\u001B[0m")
    }
}

class InkJetPrinter (private val str: String): Printer (str){
    override fun print() {
        val allColorsText: List<String> = Colors::class.java.declaredFields
            .filter { it.type == String::class.java }
            .map { field ->
                field.isAccessible = true
                field.get(Colors) as String
            }
        val allColorsBackGround: List<String> = Background::class.java.declaredFields
            .filter { it.type == String::class.java }
            .map { field ->
                field.isAccessible = true
                field.get(Colors) as String
            }
        val words = str.split(" ")
        for ((index,word) in words.withIndex()) {
            println("${allColorsText[(index+5)%allColorsText.size]}${allColorsBackGround[index%allColorsBackGround.size]}$word${Colors.RESET}${Background.RESET}")
        }

    }
}

object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}
//Перегрузка методов
//
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.

class ShoppingCart (private val map: MutableMap<String,Int>) {

    fun addToCart(itemId: String) {
        map[itemId] = (map[itemId] ?: 0) + 1
    }
    
    fun addToCart(itemId: String, amount: Int) {
        map[itemId] = amount
    }

    override fun toString(): String {
        var result = ""
        for ((id, value) in map)
            result += "ID: $id is $value\n"
        return result
    }

    fun print() {
        println(this.toString())
    }

    fun addToCart(list: List<String>) {
        for (elem in list)
            map[elem] = (map[elem] ?: 0) + 1
    }
}
//Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class LogSystem {
    fun log (message: String) {
        println(LogPrefix.INFO+message + LogPrefix.RESET)
    }

    fun log (level: Int, message: String) {
        println( if (level == 1) LogPrefix.WARNING + message + LogPrefix.RESET else LogPrefix.ERROR + message + LogPrefix.RESET)
    }

    fun log (error: Exception) {
        println(LogPrefix.ERROR + error.message + LogPrefix.RESET)
    }
}

object LogPrefix {
    const val RESET = "\u001B[0m\u001B[0m"
    const val INFO = "INFO: \u001B[0m\u001B[0m"
    const val WARNING = "WARNING: \u001B[36m\u001B[43m"
    const val ERROR = "ERROR: \u001B[47m\u001B[31m"
    const val DEBUG= "DEBUG: \u001B[44m\u001B[33m"
}

fun main() {

    val logSystem = LogSystem();
    logSystem.log("Go to the rest")
    logSystem.log(1, "Kotlin is cool")
    logSystem.log(2, "Kotlin is very cool")
    val dummyException = Exception("Connection timeout")
    logSystem.log(dummyException)
//    val cart = ShoppingCart(mutableMapOf("id1" to 1, "id2" to 1))
//    cart.print()
//    cart.addToCart("id2")
//    cart.print()
//    cart.addToCart("id3")
//    cart.print()
//
//    val cart2 = ShoppingCart(mutableMapOf("id1" to 1, "id2" to 1))
//    cart2.print()
//    cart2.addToCart(listOf("id2","id3"))
//    cart2.print()



//    //Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
//    val animal = listOf(Dog(), Cat(), Bird(), Bird())
//    for (elem in animal)
//        elem.makeSound()
//
//    //Создай набор геометрических фигур и выведи в цикле их площадь
//    val shape = listOf(Circle(1.0), Square(1.0,1.0), Triangle(10.0,10.0,90.0))
//    for (elem in shape)
//        elem.area()
//
//    val laser = LaserPrinter("i love programming")
//    laser.print()
//    val jet = InkJetPrinter("I can tell you some interesting information about future of Kotlin programming language with pleasure")
//    jet.print()
}