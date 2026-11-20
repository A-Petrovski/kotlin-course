package petrovsky.lessons.lesson22.homework

import java.util.Objects
import kotlin.jvm.Throws

fun main() {
    try {
        //    Воспроизвести фрагменты кода, которые могут привести к возникновению исключений://
//    NullPointerException
//        println(null as String)
//    IndexOutOfBoundsException
//        val list = listOf(1,2,3)
//        println(list[5])
//    ClassCastException
//        val str: Any = "String"
//        val num = str as Int
//    IllegalArgumentException
//        val str = "String"
//        val num = str.toDouble()
//    NumberFormatException
//        val number = "abc"
//        println(number.toInt())
//    IllegalStateException
//        fun checkState(state: Boolean) {
//            check(state) { "Состояние недопустимо" }
//        }
//        checkState(false)
//    OutOfMemoryError
//            val largeList = mutableListOf<Int>()
//            while (true) {
//                largeList.add(1) // Бесконечно добавляем элементы в список
//            }
//    StackOverflowError
//        fun recursiveFunction() {
//            recursiveFunction() // Бесконечный рекурсивный вызов
//        }
//        recursiveFunction()
//    Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

    } catch (e: NullPointerException) {
        println("Take NullPointerException")
    } catch (e: IndexOutOfBoundsException) {
        println("Take IndexOutOfBoundsException")
    } catch (e: ClassCastException) {
        println("Take ClassCastException")
    } catch (e: IllegalArgumentException) {
        println("Take IllegalArgumentException")
    } catch (e: NumberFormatException) {
        println("Take NumberFormatException")
    } catch (e: IllegalStateException) {
        println("Take IllegalStateException")
    } catch (e: OutOfMemoryError) {
        println("Take OutOfMemoryError")
    } catch (e: StackOverflowError) {
        println("Take StackOverflowError")
    } finally {
        println("Not taken")
    }
    val p = "String"
//    println("New task now")
//    p.tryCatchFunction()
    println("New task now")
//    throw CustomAssertionError("Check custom exception")
    val list = listOf("abc", "dif")

    try {
        // Пытаемся обратиться к несуществующему индексу 5
        println(list[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Take exception in last task")
        throw CustomIndexOutOfBoundsException(e)
    }
}
//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с
// этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
//
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи
// сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить
// работу программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент
// фантастически хорош!
//
fun Any?.tryCatchFunction() {
    try {
        val number = "abc"
        println(number.toInt())
    }
    catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("Take NullPointerException")
            is IndexOutOfBoundsException -> println("Take IndexOutOfBoundsException")
            is ClassCastException -> println("Take ClassCastException")
            is IllegalArgumentException -> println("Take IllegalArgumentException")
            is NumberFormatException -> println("Take NumberFormatException")
            is IllegalStateException -> println("Take IllegalStateException")
            else -> println("Not taken")
        }
        throw e
    }
}
//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси
// это исключение в main
//
class CustomAssertionError (message: String) : AssertionError(message)
//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
// IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
// перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
class CustomIndexOutOfBoundsException(
    cause: IndexOutOfBoundsException
) : RuntimeException("IndexOutOfBoundsException is done", cause)
