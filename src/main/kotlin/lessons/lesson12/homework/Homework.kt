package petrovsky.lessons.lesson12.homework



fun main() {

    ///////////////////////////////////////////////////////////////task 1 start////////////////////////////////////////////////////////
    val collection = listOf(1,2,3,4,5,6,7,8,9,0,19,20,21)
    val collection2 = listOf<Int>()
    val collection3 = listOf(1,2,null,3,3,4,5,1)
    val collection4 = listOf("I", "Love", "You", "Levis")
    val collection5 = listOf(0, 100000)
    val mCollection = mutableListOf<Int>()
    println("Collection is greater than 5: ${collection.count() > 5}")
    println("Collection is null: ${collection2.isNullOrEmpty()}")
    println("Collection is not null: ${collection2.isNotEmpty()}")
    println("Get existing value or create it: ${collection.getOrElse(11){11}}")
    println("Transform collection to string: ${collection.toString()}")
    println("Sum all values: ${collection.sum()}")
    println("Get AVG from collection: ${collection.average()}")
    println("Get max from collection: ${collection.max()}")
    println("Get min from collection: ${collection.min()}")
    println("Get first number or null: ${collection.getOrNull(0)}")
    println("Collection have number: ${collection.contains(1)}")
    ///////////////////////////////////////////////////////////////task 1 end////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////task 2 start////////////////////////////////////////////////////////
    println("Get range 18-30: ${collection.filter { it in 18..30 }}")
    println("Get numbers not divided by 2 and 3: ${collection.filterNot { it % 2 == 0 || it % 3 == 0 }}")
    println("Delete null from collection: ${collection3.firstOrNull()}")
    println("Transform collection to word length: ${collection4.associateWith { it.length }}")
    println("Transform collection into a map: ${collection4.associate { it.reversed() to it.length }}")
    println("Sort collection: ${collection4.sorted()}")
    println("Get first 3 elements: ${collection.take(3)}")
    println("Return elements in square: ")
    collection.forEach{print(" ${it * it}" )}
    println()
    println("Group collection: ${collection4.groupBy { it.first() }}")
    println("Perform distinct to the collection: ${collection3.distinct()}")
    println("Sort collection by desk: ${collection.sortedDescending()}")
    println("Take 3 last elements from collection: ${collection.takeLast(3)}")
    ///////////////////////////////////////////////////////////////task 2 end////////////////////////////////////////////////////////
    println(returnFeatureOfCollection(collection5))
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(filterNumbers(grades))
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println(returnMap(list))
    println(returnWordAVG(list))
    println()
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(analiseNumbers(numbers))
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println(findFirstCorrectElement(ages))
}
///////////////////////////////////////////////////////////////task other start////////////////////////////////////////////////////////
fun returnFeatureOfCollection(collection: Collection<Int>): String {
    return when {
        collection.isEmpty() -> "Empty"
        collection.size < 5 -> "Short"
        collection.first() == 0 -> "Starting"
        collection.sum() > 10000 -> "Massive"
        collection.average().toInt() == 10 -> "Balanced"
        collection.toString().length == 20 -> "Sticky"
        collection.max() < - 10 -> "Negative"
        collection.min() > 1000 -> "Positive"
        collection.containsAll(listOf(3, 14)) -> "Cool"
        else -> "Unique"
    }
}

fun filterNumbers(collection: Collection<Int>): Collection<Int> {
    return collection.filter { it >= 60 }.sorted().take(3)
}

fun returnMap(collection: Collection<String>): Map<Char, List<String>> {
    return collection.groupBy { it.uppercase().first() }
}

fun returnWordAVG(collection: Collection<String>): String {
    return String.format("AVG word length: %.2f",collection.map {it.length}.average())
}

fun analiseNumbers(collection: Collection<Int>): Map<String, List<Int>> {
    return collection.distinct().sortedDescending().groupBy{if (it % 2 == 0) "even" else "odd"}
}

fun findFirstCorrectElement(collection: Collection<Int?>): Int? {
    return collection.filterNotNull().find { it >= 18 }
}
///////////////////////////////////////////////////////////////task other start////////////////////////////////////////////////////////
//Методы для приведения коллекции к значению:
//isNotEmpty
//getOrElse
//joinToString
//firstOrNull
//size
//isEmpty
//minOrNull
//contains
//sum
//average
//maxOrNull
//Методы для обработки данных в коллекции
//sorted
//groupBy
//distinct
//take
//takeLast
//filter
//filterNot
//map
//associate
//sortedDescending
//forEach
//filterNotNull