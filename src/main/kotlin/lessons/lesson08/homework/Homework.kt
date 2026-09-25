package petrovsky.lessons.lesson08.homework

import java.util.*

////////////////////////////////////////////////TASK 1/////////////////////////////////////////////////////////////////
fun stringFix (str: String): String {
    var result = "";
    result = str.replace("невозможно", "совершенно точно возможно, просто требует времени")
    if (str.startsWith("Я не уверен")) result = "$str, но моя интуиция говорит об обратном"
    result = result.replace("катастрофа", "интересное событие")
    if (str.endsWith("без проблем")) result = str.replace("без проблем", "с парой интересных вызовов на пути")
    if (!str.trim().contains(" ")) result = "Иногда, ${str.trim()} но не всегда"
    return result;
}
////////////////////////////////////////////////TASK 2/////////////////////////////////////////////////////////////////
fun returnLogDateTime (str: String): String {
    val index = str.indexOf("->") + 3
    val result = str.substring(index).split(" ")
    return "Date is ${result[0]} and time is ${result[1]}"
}
////////////////////////////////////////////////TASK 3/////////////////////////////////////////////////////////////////
fun hideCardNumber (str: String): String {
    val help = str.split(" ")
    val result = "**** **** **** ${help[3]}"
    return result;
}
////////////////////////////////////////////////TASK 4/////////////////////////////////////////////////////////////////
fun upgradeEmail( email: String): String {
    return email.replace("@", " [at] ").replace(".", " [dot] ")
}
////////////////////////////////////////////////TASK 5/////////////////////////////////////////////////////////////////
fun returnFileName (path: String): String {
    return path.split("/").last()
}
////////////////////////////////////////////////TASK 6/////////////////////////////////////////////////////////////////
fun generateAbbreviation (str: String): String {
    return str.uppercase(Locale.getDefault()).split(" ").map { it.first() }.joinToString(separator = "")
}
////////////////////////////////////////////////TASK 7/////////////////////////////////////////////////////////////////
fun upperEachFirstLetter(str: String): String {
    return str.split(" ").joinToString(separator = " ") { s -> s.replaceFirstChar { it.uppercase(Locale.getDefault()) } }
}
////////////////////////////////////////////////TASK 8/////////////////////////////////////////////////////////////////
fun encryptAndDecrypt(str: String): String {
    var result = ""
    val newStr = if (str.length % 2 == 1) "$str " else str
    val helpArr = newStr.toCharArray()
    for (i in 0 until helpArr.size step 2)
        result = "$result${helpArr[i+1]}${helpArr[i]}"

    return result
}
////////////////////////////////////////////////TASK 9/////////////////////////////////////////////////////////////////
fun multiplyMatrix ( a: Int, b: Int): String {
    val maxLen = (a*b).toString().length
    var result = ""
    for ( i in 1..a) {
        for (j in 1..b)
          result = result + " ".repeat(maxLen - (i*j).toString().length + 1) + (i*j).toString()
        result += "\n"
    }

    return result
}
fun main() {
 //  println(stringFix("Это невозможно сделать столько косяков в коде за один день"))
 //  println(stringFix("Я не уверен, что пить пиво в понедельник утром это хорошая идея"))
 //  println(stringFix("Произошла катастрофа 26 апреля в Чернобыле"))
 //  println(stringFix("Этот код работает без проблем"))
 //  println(stringFix("cкилл"))
 //  println(" 12232 \n 434545")

 //  println(returnLogDateTime( "Пользователь вошел в систему -> 2021-12-01 09:48:23"))
 //  println(hideCardNumber("4539 1488 0343 6467"))
 //  println(upgradeEmail("username@example.com"))
 //  println(returnFileName("C:/Пользователи/Документы/report.txt"))
 //  println(generateAbbreviation("Котлин лучший язык программирования"))
 //  println(upperEachFirstLetter("Котлин лучший язык программирования"))
 //  println(encryptAndDecrypt("Котлин лучший язык программирования"))
 //  println(multiplyMatrix(100 ,100))
}