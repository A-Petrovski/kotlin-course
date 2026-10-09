package petrovsky.lessons.lesson11.homework


// task 1
fun nothingToDo () {
    println("Nothing to do")
}
// task 2
fun sum(a: Int, b: Int): Int = a + b
//task 3
fun printString(str: String) {
    println("This is your $str")
}
//task 4
fun returnAVG(list: List<Int>): Double {
    return list.average()
}
//task 5
private fun stringLength(str: String?): Int? = str?.length
// task 6
fun returnDouble(): Double? = null
//task 7
private fun nothingToDoTwo(list: List<Int?>) {
    println("Nothing to do two")
}
// task 8
fun getIntReturnStr(number: Int): String? = null
// task 9
fun returnStrList(): List<String?> = listOf("I", "Love", null, "you")
// task 10
fun returnBoolean (str: String?, int: Int?): Boolean = str == null || int == null
// task 11
fun multiplyByTwo(int: Int): Int = int*2
// task 12
fun isEven(int: Int): Boolean = int % 2 == 0
// task 13
fun printNumbersUntil(n: Int) {
    if (n < 1) return
    else for (i in 1..n){
        println(i)
    }
    return
}
// task 14
fun findFirstNegative(list: List<Int>): Int? {
    for (i in list) {
        if (i < 0) return i
    }
    return null
}
// task 15
fun processList(list: List<String?>) {
    for (elem in list){
        if (elem == null) return
        println(elem)
    }
    return
}