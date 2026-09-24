package petrovsky.lessons.lesson07.homework

fun main() {
    print("Task_1: ")
    for (i in 1..5)
        print(" $i");
    println();
    print("Task_2: ")
    for (i in 1..10)
        if( i%2 ==0 ) print(" $i");
    println();
    print("Task_3: ")
    for (i in 5 downTo 1)
        print(" $i");
    println();
    print("Task_4: ")
    for (i in 10 downTo 1)
        if( i%2 ==0 ) print(" $i");
    println();
    print("Task_5: ")
    for (i in 1..9 step 2)
        print(" $i");
    println()
    print("Task_6: ")
    for (i in 1..20 step 3)
        print(" $i");
    println()
    print("Task_7: ")
    val size = 13;
    for (i in 1 until size)
        print(" $i");
    println()
    print("Task_8: ")
    var counter = 0;
    while ( counter++ < 5)
        print(" ${counter*counter}");
    println()
    print("Task_9: ")
    var counter3 = 10;
    while ( counter3-- > 5)
        print(" ${counter3*counter3}");
    println()
    print("Task_10: ")
    var counter4 = 6;
    while ( counter4-- > 1)
        print(" $counter4");
    println()
    print("Task_11: ")
    var counter2 = 5;
    while ( counter2++ < 10)
        print(" repeat");
    println()
    print("Task_12: ")
    for (i in 1..10){
        if (i == 6) break
        print(" $i");
    }
    println()
    print("Task_13: ")
    var counter5 = 1;
    while (true){
            if (counter5++ == 10) break;
            print(" $counter5");
    }
    println()
    print("Task_B1: ")
    for (i in 1..10) {
        println()
        for (j in 1..10)
            print("${ j * i } ")
    }
    println()
    print("Task_B2: ")
    fun lineSum(arg: Int) {
        var result = 0;
        for (i in 1..arg)
            result += i
        print(result)
    }
    lineSum(100)
    println()
    print("Task_B3: ")
    fun factorial(arg: Int) {
        var counterF = 1
        var result = 1;
        while (counterF++ < arg)
            result *= counterF
        print(result)
    }
    factorial(3)
    println()
    print("Task_B4: ")
    fun sumOdd(arg: Int) {
        var result = 0;
        for (i in 2..arg step 2)
            result += i
        print(result)
    }
    sumOdd(10)
    println()
    print("Task_B5: ")
    fun rectangle() {
        var j = 0;
        var i = 0;
        while (i++ < 3) {
            println()
            while (j++ < 5)
                print("*")
            j = 0
        }
    }
    rectangle()
    println()
    print("Task_B6: ")
    fun twoSumLine(arg: Int) {
        var result1 = 0
        var result2 = 0
        for (i in 1..arg)
            if (i%2 == 0 ) result1 += i else result2 += i
        print("$result1 and $result2")
    }
    twoSumLine(10)



}