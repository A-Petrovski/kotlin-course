package petrovsky.lessons.lesson13.homework

fun main() {


//Для решения каждой задачи постарайтесь использовать наиболее подходящий метод, не повторяясь с решением других задач.
//
//Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val testTime = mapOf("test 1" to 1.00, "test 2" to 2.22, "test 3" to 3.33, "test 4" to 9.87, "test 5" to 1.55)
    println(testTime.values.average())
//Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными.
// Выведите список всех тестовых методов.
    val descTime = mapOf("method 1" to "data 1", "method 2" to "data 2","method 3" to "data 3")
    println(descTime.keys.toString())
//В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val testResult = mutableMapOf("test 1" to "passed", "test 2" to "passed")
    testResult["test 3"] = "failed"
    println(testResult.toString())
//Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
    println(testResult.entries.groupingBy { it.value }.eachCount() )
//Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    val bugTracking = mutableMapOf("bug 1" to "fixed", "bug 2" to "in progress", "bug 3" to "fixed")
    bugTracking.entries.removeIf { it.value == "fixed" }
    println(bugTracking)
//Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.
    val linkStatus = mapOf("url 1" to 200, "url 2" to 200, "url 3" to 404)
    linkStatus.forEach {(url, status) -> println("Page $url checked. Status: $status") }
//Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    println(testTime.filterValues { it > 3.00 })
//В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val endpointStatus = mapOf("url 1" to "200", "url 2" to "200", "url 3" to "404")
    println(endpointStatus.getOrDefault("url 4", "Not tested" ))
//Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация),
// получите значение для "browserType". Ответ не может быть null.
    val configValue = mapOf("param 1" to "value 1", "param 2"  to "value 2")
//    println(configValue.getOrElse("browserType", {"default"}))
    println(configValue.getValue("browserType"))
//Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val baseVersion = mapOf("soft 1" to 1.0, "soft 2" to 2.0)
    val newVersion = baseVersion + ("soft 3" to 3.0)
    println(baseVersion.toString())
    println(newVersion.toString())
//Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками),
// получите настройки для конкретной модели или верните настройки по умолчанию.
    val testConfig = mapOf("unit 1" to "config 1", "unit 2" to "config 2")
    println(testConfig["unit 3"] ?: "default config")
//Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val codeMistake = mapOf("code 1" to "value 1", "code 2" to "value 2")
    println(codeMistake.containsKey("code 3"))
//Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
// Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val idTestStatus = mapOf("testId 1" to "passed", "testId2 1" to "failed", "testId 3" to "skipped")
    println(idTestStatus.filterKeys { it.endsWith("_1") })
//У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val moduleTestStatus = mapOf("module 1" to "passed", "module 2" to "failed", "module 3" to "failed")
    println(moduleTestStatus.filterValues { it == "failed" })
//Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val map1 = mutableMapOf("dev" to "config 1", "uat" to "config 2")
    val map2 = mapOf("prod" to "config 3")
    map1.putAll(map2).toString()
    println(map1)
//Объедините два неизменяемых словаря с данными о багах.
    val mapVer1 = mapOf("bug 1" to "value 1")
    val mapVer2 = mapOf("bug 2" to "value 2")
    val mapVer3 = mapVer2 + mapVer1
    println(mapVer3)
//Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val timeTestSuit = mutableMapOf("run 1" to 20.0, "run 2" to "3.33")
    timeTestSuit.clear()
    println(timeTestSuit)
//Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val idTestStatus2 = mapOf("testId 1" to "passed", "testId2 1" to "failed", "testId 3" to "skipped")
    idTestStatus2.filterNot { it.value == "skipped" }
//Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val map4 = mapOf("dev" to "config 1", "uat" to "config 2", "prod" to "config 3")
    val map5 = map4 - listOf("dev", "uat")
    println(map5)
//Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val idTestStatus3 = mapOf("testId 1" to "passed", "testId2 1" to "failed", "testId 3" to "skipped")
    println( idTestStatus3.map { (t, u) -> "Test ID: $t with result: $u" })
//Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val idTestStatus4 = mutableMapOf("testId 1" to "passed", "testId2 1" to "failed", "testId 3" to "skipped")
    val resultMap = idTestStatus4.toMap()
    println(resultMap)
//Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val idTimeTest = mapOf(1 to 1, 2 to 2, 3 to 3)
    val newIdTestTime: Map<String, Int> = idTimeTest.mapKeys { it.key.toString() }
    println(newIdTestTime)
//Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера)
// увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val performanceMap = mapOf("ver 1" to 5.55, "ver 2" to 10.0)
    val updatedPerformance = performanceMap.mapValues { it.value * 1.1 }
    println(updatedPerformance)
//Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val errorComp = emptyMap<String,String>()
    println(errorComp.isEmpty())
//Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    println(errorComp.isNotEmpty())
//Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val idTestStatus5 = mutableMapOf("testId 1" to "passed", "testId2 1" to "failed", "testId 3" to "skipped")
    println(idTestStatus5.all { it.value == "passed" })
//Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    println(idTestStatus5.any { it.value == "failed" })
//Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
    val testResult2 = mapOf("test 1 optional" to "passed", "test 2 optional" to "failed")
//    println(testResult2.filter { (name, status) -> status != "passed" && name.contains("optional")  })
    testResult2.filterKeys { it.contains("optional") }
        .filterValues { it != "passed" }
}