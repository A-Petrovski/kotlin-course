package petrovsky.lessons.lesson10.homework



fun main() {
    val emptyNotEditableMap: Map<Int,Int> = emptyMap() // task 1
    val number2: Map<Float,Double> = mapOf(1.2f to 1.2, 1.3f to 1.3, 1.4f to 1.4) // task 2
    val number3f: MutableMap<Int,String> = mutableMapOf(1 to "fuck") // task 3
    number3f[2] = "fax" // task 4
    println(number3f[2]) // task 5
    println(number3f[5])
    number3f.remove(2) // task 6
    val number7: Map<Double, Int> = mapOf(0.2 to 2, 0.1 to 1, 100.0 to 0) // task 7
    for ((key, value) in number7){
        if (value == 0 ) println("Universe") else println("${key/value}")
    }
    number3f[1] = "suck" // task 8
    val number9H1: Map<Int,Int> = mapOf(1 to 1, 2 to 2, 3 to 3) // task 9
    val number9H2: Map<Int,Int> = mapOf(3 to 30, 4 to 40, 5 to 50)
    val numberAll9: MutableMap<Int,Int> = mutableMapOf()
    for ((key, value ) in number9H1)
        numberAll9[key] = value
    for ((key, value ) in number9H2)
        numberAll9[key] = value
    println(numberAll9)
    val number10: MutableMap<String, List<Int>> = mutableMapOf() // task 10
    number10["Palm"] = listOf(1,2,3,4,5)
    number10["bitch"] = listOf(6,7,8,9,0)
    println(number10)
    val number11: MutableMap<Int, MutableSet<String>> = mutableMapOf(1 to mutableSetOf("I", "Love", "You")) // task 11
    number11[1]?.add("forever")
    println(number11)
    val number12: MutableMap<List<Int>, String> = mutableMapOf(listOf(1,1) to "No", listOf(1,5) to "Yes") // task 12
    for ((key, value) in number12)
        for (elem in key)
            if (elem == 5) println(value)

    val bibliophile: MutableMap<String, MutableSet<String>> = mutableMapOf("Writer 1" to mutableSetOf("Book 1", "Book 2")) // task 1
    val plants: Map<String, Set<String>> = mutableMapOf("Type 1" to setOf("Name 1", "Name 2")) // task 2
    val sportTeam: MutableMap<String, Set<String>> = mutableMapOf("Team name 1" to setOf("Player 1", "Player 2")) // task 3
    val ambulance: MutableMap<String, Set<String>> = mutableMapOf("Date 1" to setOf("help 1", "help 2")) // task 4
    val travelList: MutableMap<String, MutableMap<String,Set<String>>> = mutableMapOf("Country" to mutableMapOf("City" to setOf("place 1", "place 2", "place 3"))) // task 5
}
