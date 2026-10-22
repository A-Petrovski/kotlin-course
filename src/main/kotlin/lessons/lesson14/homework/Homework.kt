package petrovsky.lessons.lesson14.homework

//Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String)
// и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party (
    private val location: String,
    private val attendees: Int
) {
    fun details () {
        println("Location: $location and attendees: $attendees")
    }
}

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type
// (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа
// и интенсивности.
class Emotion (private val type: String, private val intensity: Int) {
    fun express () {
        val message = when (type) {
            "anger" -> when (intensity) {
                in 0..4 -> "low level of anger"
                in 4..7 -> "medium level of anger"
                in 7..10 -> "high level of anger"
                else -> "unknown level of anger"
            }
            "joy" -> when (intensity) {
                in 0..4 -> "low level of joy"
                in 4..7 -> "medium level of joy"
                in 7..10 -> "high level of joy"
                else -> "unknown level of joy"
            }
            else -> "unknown type of joy"
        }
        println(message)
    }
}

//Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean),
// чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например,
// "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
class Moon (private val inVisible: Boolean, private val phase: String) {
    fun showPhase() {
        val message = if (inVisible) "The moon phase is $phase" else "The moon is not visible"
        println(message)
    }
}

//Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть
// свойства “название”, “цена”, “количество”.
class Product (private val name: String, private val price: Int, private val count: Int){
    fun howMuchCanBuy(money: Int) {
        val message = if (money < price) "Insufficient funds" else "You buy ${ if (money/price> count) count else money/price} units of $name"
        println(message)
    }
}

//Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место
// проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который выводит
// информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
class Concert (private val name: String, private val place: String, private val price: Int, private val capacity: Int) {
    private var ticketsSold = 0;
    fun details () {
        val message = "Concert $name in place $place costs $price dollars with capacity $capacity people"
    }
    fun buyTicket () {
        if (ticketsSold < capacity) {
            ticketsSold++
            println("Ticket successfully purchased")
        } else {
            println("Error, all tickets have already been sold")
        }
    }
}

//Класс Shelf (Полка Стеллажа)
//
//Характеристики:
//
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.
//Методы:

class Shelf (private val capacity: Int) {

    private var items = mutableListOf<String>()

    //Добавление Предмета (addItem):
    //Принимает название предмета.
    //Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
    //Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
    fun addItem (item: String): Boolean {
       return if (canAccommodate(item)) items.add(item) else false
    }

    //Удаление Предмета (removeItem):
    //Принимает название предмета.
    //Удаляет предмет, если он найден на полке.
    //Возвращает true, если предмет был удален, и false, если такой предмет не найден.
    fun removeItem (name: String): Boolean {
       return items.remove(name)
    }

    //Проверка наличия предмета (containsItem):
    //Принимает название предмета
    //Возвращает true если такой предмет есть
    fun containItems (name: String): Boolean {
        return items.contains(name)
    }

    //Получение списка предметов (getItems):
    //Возвращает неизменяемый список предметов
    fun getItems (): List<String> {
        return items
    }

    //Проверка Вместимости (canAccommodate):
    //Принимает название предмета.
    //Определяет, вместится ли предмет на полку.
    //Возвращает true, если предмет вместится, и false, если места недостаточно.
    private fun canAccommodate (name: String): Boolean {
        return items.sumOf { it.length } + name.length <= capacity
    }
    fun getCapacity (): Int {
        return capacity
    }
}


//Класс Rack (Стеллаж)
//
//Характеристики:
//
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//



class Rack (private val capacity: Int) {
    private var items = mutableListOf<Shelf>()

    private fun canAccommodate (): Boolean {
        return items.count() <= capacity
    }

    private fun isShelfExist(index: Int): Boolean {
        return index in items.indices
    }
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
fun addShelf (item: Shelf): Boolean {
    return if (canAccommodate()) items.add(item) else false
}


//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
fun removeShelf (index: Int): List<String> {
    val help: Shelf
    if (isShelfExist(index)) {
         help = items[index]
        items.removeAt(index)
        return help.getItems()
    } else return emptyList()

}
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
fun addItem (item: String): Boolean {
    for (elem in items)
        if (elem.addItem(item)) return true
    return false
}

//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
fun removeItem (item: String): Boolean {
    for (elem in items)
        if (elem.removeItem(item)) return true
    return false
}

//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
fun containsItem (item: String): Boolean {
    for (elem in items)
        if (elem.containItems(item)) return true
    return false
}

//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
fun getItems (): List<Shelf> {
    return items
}

//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
fun printContents () {
    if (items.isEmpty()) {
        println("The rack is empty")
        return
    }

    items.forEachIndexed {index, shelf ->
        val usedCapacity = shelf.getItems().sumOf { it.length }
        val remainingCapacity = shelf.getCapacity() - usedCapacity

        println("""
            Shelf $index 
            full capacity: ${shelf.getCapacity()}
            place remaining: $remainingCapacity
            items on the shelf: ${shelf.getItems()}
        """.trimIndent())
        println("---------------------------")
    }
}
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
    fun advancedRemoveShelf (index: Int): List<String> {

    val list: MutableList<String> = removeShelf(index).toMutableList()
    if (list.isEmpty()) return list

    list.removeIf { elem -> addItem( elem)}
    return list
}

}

fun main(){
    val party = Party("Minsk", 123)
    party.details()
    val emotion = Emotion("joy", 10)
    emotion.express()
    val moon = Moon(true, "New Moon")
    moon.showPhase()
    val product = Product("Vodka", 10,10)
    product.howMuchCanBuy(5)
    product.howMuchCanBuy(27)
    product.howMuchCanBuy(111)
    val concert = Concert("Rammstein", "Minsk", 10000,3)
    concert.details()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket()
    val shelf = Shelf(10)
    shelf.addItem("Book")
    println(shelf.addItem("434"))
    println(shelf.addItem("434"))
    println(shelf.addItem("434"))
//    println(shelf.getItems())
//    println( shelf.containItems("stick"))
//    println( shelf.containItems("Book"))
//    println( shelf.removeItem("stick"))
//    println( shelf.removeItem("Book"))

    val rack = Rack(10)
    rack.addShelf(shelf)
    rack.printContents()
    println( rack.removeShelf(2))
    println( rack.removeShelf(0))
    rack.printContents()
    }