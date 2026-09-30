package petrovsky.lessons.lesson09.homework

fun main() {
    ////////////////////////////////////////////////////////////SETS start///////////////////////////////////////////////////////////////////////////
    val sets1: Set<Int> = setOf() // task 1
    val sets2: Set<Int> = setOf(1,2,3) // task 2
    val sets3: MutableSet<String> = mutableSetOf("Hello", "World", "Kotlin") // task 3
    val sets4: MutableSet<String> = mutableSetOf("Hello", "World", "Kotlin") // task 4
    sets4.addAll(setOf("Swift", "Go"))
    val sets5: MutableSet<Int> = mutableSetOf(1,2,3,4,5,6) // task 5
    sets5.remove(2)
    val sets6H: MutableSet<Int> = mutableSetOf(1,2,3,4,5,6) // task 6
    var sets6: String = ""
    for (elem in sets6H)
        sets6 += "$elem "
    val sets7H: MutableSet<String> = mutableSetOf("Hello", "World", "Kotlin") // task 7
    val sets7 = sets7H.indexOf("Hello") != -1
    val sets8H: Set<String> = setOf("Hello", "World", "Kotlin")// task 8
    val sets8: MutableSet<String> = mutableSetOf()
    for (elem in sets8H)
        sets8.add(elem)

    println(sets1.toString())
    println(sets2.toString())
    println(sets3.toString())
    println(sets4.toString())
    println(sets5.toString())
    println(sets6.toString())
    println(sets7.toString())
    println(sets8.toString())
    ////////////////////////////////////////////////////////////SETS end////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////LISTS start////////////////////////////////////////////////////////////////////////////
    val lists1: List<Int> = emptyList() // task 1
    val lists2: List<String> = listOf("Hello", "World", "Kotlin") // task 2
    val lists3: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 3
    val lists4: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 4
    lists4.addAll(listOf(6,7,8))
    val lists5: MutableList<String> = mutableListOf("Hello", "World", "Kotlin") // task 5
    lists5.remove("World")
    val lists6H: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 6
    var lists6: String = ""
    for (i in 0..4)
        lists6 += "${lists6H[i]} "
    val lists7H: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 7
    val lists7 = lists7H[1]
    val lists8: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 8
    lists8[2] = -2
    val lists9H1: MutableList<String> = mutableListOf("Hello1", "World1", "Kotlin1") // task 9
    val lists9H2: MutableList<String> = mutableListOf("Hello2", "World2", "Kotlin2")
    val lists9: MutableList<String> = mutableListOf()
    for (elem in lists9H1)
        lists9.add(elem)
    for (elem in lists9H2)
        lists9.add(elem)
    val lists10H: MutableList<Int> = mutableListOf(1,2,-3,41,5) // task 10
    var helpMax10 = lists10H[0]
    var helpMin10 = lists10H[0]
    for (elem in lists10H) {
        helpMin10 = if ( helpMin10 > elem) elem else helpMin10
        helpMax10 = if ( helpMax10 < elem) elem else helpMax10
     }
    val lists10: MutableList<String> = mutableListOf("helpMin10: $helpMin10", "helpMax10: $helpMax10")
    val lists11H: MutableList<Int> = mutableListOf(1,2,3,4,5) // task 11
    val lists11: MutableList<Int> = mutableListOf()
    for (elem in lists11H)
        if (elem % 2 == 0) lists11.add(elem)
//  println(lists1.toString())
//  println(lists2.toString())
//  println(lists3.toString())
//  println(lists4.toString())
//  println(lists5.toString())
//  println(lists6)
//  println(lists7.toString())
//  println(lists8.toString())
//  println(lists9.toString())
//  println(lists10.toString())
//  println(lists11.toString())
    ////////////////////////////////////////////////////////////LISTS end////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////ARRAYS start////////////////////////////////////////////////////////////////////////////
    val numbers1 = arrayOf(1, 2, 3, 4, 5) // task 1
    val numbers2 = Array(10) { "" } // task 2
    val numbers3 = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0) // task 3
    val numbers4 = arrayOfNulls<Int>(5) // task 4
    for (i in 0..4)
        numbers4[i] = i*3
    val numbers5 = arrayOfNulls<String>(3) // task 5
    numbers5[1] = ""
    numbers5[2] = ""
    val numbers6H = arrayOf(1, 2, 3, 4, 5) // task 6
    val numbers6 = arrayOfNulls<Int>(5)
    for (i in 0..4)
        numbers6[i] = numbers6H[i]
    val numbers7H1 = arrayOf(1, 2, 3, 4, 5) // task 7
    val numbers7H2 = arrayOf(2, 4, 9, 16, 25)
    val numbers7 = arrayOfNulls<Int>(5)
    for (i in 0..4)
        numbers7[i] = numbers7H1[i] - numbers7H2[i]
    val numbers8H = arrayOf(1, 2, 3, 4, 51, 6) // task 8
    var numbers8 = -1
    for (i in 0..5)
       numbers8 = if (numbers8H[i] == 5)  i  else numbers8
    val numbers9H = arrayOf(1, 2, 3, 4, 5, 6) // task 9
    val numbers9 = arrayOfNulls<String>(6)
    for (i in 0..5)
        numbers9[i] = "$i ${if (i%2 == 0) " is even" else " is odd"}; "
    val str = "fixed" // task 10
    val numbers10H = arrayOf("i fixed bug", "kotlin best course", "flying to Cam bodge", "Java is the best lang", "pa pa pa")
    var numbers10 = ""
    for (i in 0..4) {
        if (numbers10H[i].contains(str))
           numbers10 = numbers10H[i]
                break
    }

  // println(numbers1.contentToString())
  // println(numbers2.contentToString())
  // println(numbers3.contentToString())
  // println(numbers4.contentToString())
  // println(numbers5.contentToString())
  // println(numbers6.contentToString())
  // println(numbers7.contentToString())
  // println(numbers8)
  // println(numbers9.contentToString())
  // println(numbers10)
////////////////////////////////////////////////////////////ARRAYS end////////////////////////////////////////////////////////////////////////////





}