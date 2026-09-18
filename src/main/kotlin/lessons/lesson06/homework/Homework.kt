package petrovsky.lessons.lesson06.homework

import kotlin.math.round

//Задание 1: "Определение сезона"
//
// Напишите функцию, которая на основе номера месяца распечатывает сезон года. Номера месяцев начинаются с единицы.
//
fun seasonByMonth(month: Int){
    val result = when (month) {
        in 0..2 -> "Winter"
        in 3..5 -> "Spring"
        in 6..8 -> "Summer"
        in 9..11 -> "Autumn"
        in 12..12 -> "Winter"
        else -> "Error"
    }
    println(result)
};
// Задание 2: "Расчет возраста питомца"
//
// Создайте функцию, которая преобразует возраст собаки в "человеческие" годы. До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам. Результат распечатай в консоль.
fun dogAgeToPerson(dogAge: Int){
    val result = if (dogAge <= 2)  dogAge*10.5 else 2*10.5 + (dogAge-2)*4;
    println(result);
}
//
// Задание 3: "Определение способа перемещения"
//
// Напишите функцию, которая печатает в консоль, какой способ перемещения лучше использовать, исходя из длины маршрута. Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".
fun selectTransportByDistance(distance: Int) {
    val result = when (distance){
        in 0..1 -> "Walk"
        in 2..5 -> "Bike"
        else -> "Car"
    }
    println(result);
}
//
// Задание 4: "Расчет бонусных баллов"
//
// Клиенты интернет-магазина получают бонусные баллы за покупки. Напишите функцию, которая принимает сумму покупки и печатает в консоль количество бонусных баллов:
// 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 3 балла за каждые 100 рублей при сумме свыше этого.
fun shopBonusBySum(sum: Int) {
    val result = if (sum <= 1000) (sum/100).toInt()*2 else (sum/100).toInt()*3
    println(result);
}
//
// Задание 5: "Определение типа документа"
//
// В системе хранения документов каждый файл имеет расширение. Напишите функцию, которая на основе расширения файла печатает в консоль его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
fun documentExtension(extension: String) {
    val result = when (extension) {
        ".doc" -> "Text document"
        ".Jpeg" -> "Picture"
        ".xlsx" -> "Table"
        else -> "Unknown type"
    }
    println(result)
}
//
// Задание 6: "Конвертация температуры"
//
// Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот в зависимости от указанной единицы измерения (C/F).
// Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов передаются через запятую.
// Распечатай в консоль результат конвертации с добавлением единицы измерения. Чтобы добавить единицу измерения после результата используй функцию печати без переноса строки print("C") или print("F").
//
fun temperatureConversion(temperature: Double, type: String) {
    val result = when (type) {
        "C" -> round((temperature - 32)/1.8).toString() + " C"
        "F" -> round(temperature * 1.8 + 32).toString() + " F"
        else -> "Unknown temperature units"
    }
    println(result)
}
// Задание 7: "Подбор одежды по погоде"
//
// Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды: "куртка и шапка" при температуре ниже +10,
// "ветровка" от +10 до +18 градусов включительно и "футболка и шорты" при температуре выше +18 градусов. При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
//
fun clothesByWeather(temperature: Double) {
    val result = when (temperature) {
        in -30.0..10.0 -> "Put on your hat and jacket"
        in 10.0..18.0 -> "Put on a windbreaker"
        in 18.0..35.0 -> "Put on a T-shirt and shorts"
        !in -30.0..35.0 -> "Do not go outside"
        else -> "Error"
    }
    println(result)
}
// Задание 8: "Выбор фильма по возрасту"
//
// Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию, которая принимает возраст зрителя и возвращает доступные для него категории
// фильмов: "детские" (от 0 до 9), "подростковые" (от 10 до 18), "18+" для остальных.

fun cinemaAgeRestriction(age: Int) {
    val result = when (age) {
        in 0..9 -> "Kid"
        in 10..18 -> "Teen"
        in 19..Int.MAX_VALUE -> "Man"
        else -> "Error"
    }
    println(result)
}

fun main() {
    //seasonByMonth(12);
    //dogAgeToPerson(2);
    //dogAgeToPerson(10);
    //selectTransportByDistance(1);
    //selectTransportByDistance(11);
    //shopBonusBySum(9990);
    //documentExtension(".pdf")
    //documentExtension(".doc")
    //temperatureConversion(35.2,"C")
    //temperatureConversion(88.2,"F")
    //clothesByWeather(-100.2)
    //clothesByWeather(10.0)
    //cinemaAgeRestriction(9)
    //cinemaAgeRestriction(99)
    //cinemaAgeRestriction(-5)
}