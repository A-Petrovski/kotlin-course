package petrovsky.lessons.lesson19.homework
//Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.
//
//1. Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
fun <M> getMiddleElement(list: List<M>) : M? {
    return if (list.size % 2 == 0) null else list[list.size/2]
}

//2. Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления
// нового элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T> {
    private val list = mutableListOf<T>()

    fun add (elem: T) {
        list.add(elem)
    }

    fun get(): List<T> {
        return list.toList()
    }
}

//3. Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//3.1 элементов одного типа в элементы другого типа
//3.2 списка элементов одного типа в список элементов другого типа
interface Mapper<T, R> {
    fun map (elem: T): R
    fun map (list: List<T>): List<R>
}

//4. Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
// Метод преобразования списков с аналогичной механикой.
class PhrasesToListOfStrings :Mapper<String, List<String>> {
    override fun map(elem: String): List<String> {
        return elem.split(" ")
    }

    override fun map(list: List<String>): List<List<String>> {
        return list.map { it.split(" ") }
    }
}

//5. Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь,
// в котором ключ и значения поменялись местами.
fun <K,V> transposition(map: Map<K, V>): Map<V, K> {
    return map.map { it }.associate { it.value to it.key }
}

//6. Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом
// дженерика и возвращать булево значение.
interface Validator<T> {
    fun validate(elem: T): Boolean
}

//7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку,
// что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator: Validator<String?> {
    override fun validate(elem: String?): Boolean {
        return elem?.isNotBlank() ?: false
    }
}

//8. Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator: Validator<Int> {
    override fun validate(elem: Int): Boolean {
        return elem % 2 == 0
    }
}

//9. Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
// 9.1 Реализуй проверку:
//9.1.1 Ни один элемент списка не является null
//9.1.2 Ни один элемент приведённый к типу Double не равен 0.0
class ListValidator<T: Number> : Validator<List<T?>> {
    override fun validate(elem: List<T?>): Boolean {
        return elem.all { it != null && it.toDouble() != 0.0 }
    }
}

fun main() {
    println( getMiddleElement(listOf(1,2,3,4,5,6)))
    println( getMiddleElement(listOf("1","2","3","4","5")))
}