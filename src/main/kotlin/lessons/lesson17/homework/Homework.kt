package petrovsky.lessons.lesson17.homework
//    Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)
//
//    Поля:
//    цвет -
//    модель -
//    включен -
//    ОС загружена -
//    список установленных игр -
//    наличие джойстика -
//    баланс вырученных средств -
//    владелец -
//    телефон поддержки. -
//    игровой сеанс оплачен -
//    стоимость одного игрового сеанса -
//    пин-код автомата -
//    Методы:
//
//    включить -
//    выключить -
//    загрузить ОС -
//    завершить работу ОС -
//    показать список игр -
//    включить игру -
//    оплатить игровой сеанс -
//    забрать наличные с помощью пин-кода
//    открыть сейф и выдать наличные
class SlotMachine (
    val color: String,
    val model: String,
    val owner: String,
    val supportPhone: String,
    private var pinCode: String,
    private var ticketPrice: Double
)

{
    private var isPowerOn: Boolean = false
    private var isLoaded: Boolean = false
    private var isHaveGamePad: Boolean = false
    private var isTicketPaid: Boolean = false
    private var revenue: Double = 0.0
    private var installedGames: MutableList<String> = mutableListOf()
    private var launchedGame: String? = null

    fun powerOn() {
        isPowerOn = true
        load()
    }

    fun powerOff() {
        isPowerOn = false
        isLoaded = false
        isTicketPaid = false
        launchedGame = null
    }

    private fun load(): Boolean {
        if (isPowerOn) isLoaded = true
        return isLoaded
    }

    fun shutDown(): Boolean {
        isLoaded = false
        launchedGame = null
        isTicketPaid = false
        return true
    }

    fun printGameList() {
        println(installedGames)
    }

   fun launchGame(game:String): String {
       if (installedGames.contains(game) && isTicketPaid) launchedGame = game
       return game
   }

    fun payTicket () {
        revenue += ticketPrice
        isTicketPaid = true
    }

    private fun getCashByPin(pin: String): Boolean {
        return pin == pinCode
    }
    fun extractCash (pin:String) {
        if (getCashByPin(pin))
        revenue = 0.0
    }

}

//Почемучка
//Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях и заданным образом доработать класс ChildrenClass (BaseClass доработке не подлежит)

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // В классе наследнике переменная не видна и создается новая публичная переменная.
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    // Оно доступно во всех наследниках, но не более.
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    // приватную переменную невозможно изменить через клас-наследник
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    // потому что класс объявлен как протектед и котлин не позволяет расширить доступ
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // в дочернем классе есть оверайд
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    // класс объявлен как приватный и котлин не позволяет расширить доступ
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // унаследованное публичное поле.
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    val privateField = "recreation in ChildrenClass"
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    //она публичная в родительском классе.
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // принт текст вызывается из родительского класса, а тот видит лишь свой приватный метод.
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
    fun changePublicField (newVal: String) {
        publicField = newVal
    }
    override fun verifyPublicField(value: String): Boolean {
        return true
    }
    fun closetProtectedField(newValue: String) {
        protectedField = newValue
    }
}

fun main() {
    val help = ChildrenClass("1", "1","1")
//    println(help.privateVal)
//    println(help.publicVal)
//    help.changePublicField("Антонио Бандерос")
//    help.closetProtectedField("Task 5 is completed")
//    println(help.getAll())
    help.printText()
    val calc = Calculator(emptyList())
    val result = calc.calculate("1/9")
    println(result)
}

abstract class Operation (private val operator: Char) {
    abstract fun calculate (expression: String): String
    protected fun parseExpression (expression: String) : List<Double> {
        return if (check(expression))
            expression.split(operator). map { it.trim() }.map { it.toDouble() }
        else emptyList()
    }
    private fun check(expression: String): Boolean {
        return expression.split(operator). map { it.trim() }.all { it.toDoubleOrNull() != null }
    }
    fun checkOperator(expression: String): Boolean {
        return expression.contains(operator)
    }
}

private class Addition : Operation('+') {
    override fun calculate(expression: String) : String{
        return if (parseExpression(expression).isNotEmpty()) parseExpression(expression).sum().toString() else
            "Incorrect expression"
    }
}
private class Subtraction: Operation ('-') {
    override fun calculate(expression: String): String {
        return if (parseExpression(expression).isNotEmpty()) parseExpression(expression).reduce { valA, valB -> valA - valB }.toString() else
            "Incorrect expression"
    }
}
private class Multiplication: Operation ('*') {
        override fun calculate(expression: String) : String {
            return if (parseExpression(expression).isNotEmpty()) parseExpression(expression).reduce{ valA, valB -> valA * valB }.toString() else
                "Incorrect expression"
        }
}
private class Division: Operation ('/') {
    override fun calculate(expression: String) : String {
        val help = parseExpression(expression)
        if (parseExpression(expression).isNotEmpty()) return "Incorrect expression"
        return if (help[1] == 0.0) return "Division by zero is forbidden" else help.reduce{ valA, valB -> valA / valB }.toString()
    }
}

class Calculator (private val additionalOperations: List<Operation>) {
    private val operations = listOf(Addition(), Subtraction(), Multiplication(), Division()) + additionalOperations
    fun calculate (expression: String): String {
        val operation = operations.firstOrNull {it.checkOperator(expression)}
        return operation?.calculate(expression) ?: "Unsupported operation"
    }
}