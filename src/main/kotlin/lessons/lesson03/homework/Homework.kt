package petrovsky.lessons.lesson03.homework

import jdk.jfr.Registered
import kotlin.properties.Delegates

// 1. Название мероприятия (неизменяемая публичная переменная известная на момент написания)
//val name: String = "Monster Hackaton"

// 2. Дата проведения (публичная переменная известная на момент написания, но может быть изменена из-за переноса)
//var date: String = "10 ноября 2025"

// 4. Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы. (приватная неизменяемая переменная - её не должны увидеть и бюджет уже запланирован и утверждён и не должен изменяться)
//private val budget: String = "подробная информация с перечислением поставщиков и сумм для внутреннего пользования"

// 18. График питания участников (зависит от поставщика питания, определяемого за неделю до начала) (публичная изменяемая переменная с отложенной инициализацией, так как на момент создания поставщик и график не известны)
//lateinit var mealSchedule: String




//////////////////////////////////////////////////////////////HOMEWORK start/////////////////////////////////////////////////////////////////////////////////
//Название мероприятия
val name: String = "Monster Hackaton"
//Дата проведения
val date: String = "10 ноября 2025"
//Место проведения
val place: String = "Minsk"
//Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
private val budget: String = "подробная информация с перечислением поставщиков и сумм для внутреннего пользования"
//Количество участников
var participantsCount: Int = 0
//Длительность хакатона
val lengthInMin: Int = 90
//Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
private val supplier: List<String> = listOf("supplier 1", "supplier 2")
//Текущее состояние хакатона (статус)
var isActive: Boolean = true
//Список спонсоров
val sponsors: List<String> = listOf("sponsor 1", "sponsor 2")
//Бюджет мероприятия
val budgetInDollars: Int = 10000
//Текущий уровень доступа к интернету
var levelOfInternet: String = "low"
//Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
private val resources: MutableList<String> = mutableListOf("resource 1", "resource 2")
//Количество команд
var countOfTeams: Int = 2
//Перечень задач
private var listOfTasks: List<String> = listOf("task 1", "task 2")
//План эвакуации
val evacuationPlan: String = "plan"
//Список доступного оборудования (всё, что выделено для использования на мероприятии)
val allEquipment: List<String> = listOf("equipment 1", "equipment 2")
//Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
val availableEquipment: MutableList<String> = mutableListOf("equipment 1")
//График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
lateinit var mealSchedule: String
//План мероприятий на случай сбоев
val planB: String = "plan B"
//Список экспертов и жюри
val experts: List<String> = listOf("expert 1", "expert 2")
//Политика конфиденциальности
const val POLICY_OF_EVENT = "Policy of event"
//Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
val listOfFeedbacks: MutableList<String> = mutableListOf()
//Текущая температура в помещении
var temperatureInCelsius: Double = 25.4
//Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих приложений командами
private var listOfAppsLogs: List<String> = listOf("app 1", "app 2")
// скорости интернета (понижающий коэффициент, например 0.5)
var internetSpeedFactor: Double = 0.5
//Уровень освещения
var levelOfLight: String = "medium"
//Лог событий мероприятия
val listOfEventLogs: MutableList<String> = mutableListOf()
//Возможность получения медицинской помощи прямо на мероприятии (да/нет)
val isMedicalHelpAvailable: Boolean = true
//Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
private var listOfSafetyPlans: List<String> = listOf("plan 1", "plan 2")
//Регистрационный номер мероприятия
const val REGISTERED_EVENT_NUMBER: String = "hfdjka3389djj3"
//Максимально допустимый уровень шума в помещении хакатона.
const val MAX_NOISE_IN_DBC: Int = 125
//Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
var isNoiseExceeded: Boolean = false
//План взаимодействия с прессой
private val pressPlan: String = "press plan"
//Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.
var teamProjectsPublic: String = "teams plan"
//Статус получения всех необходимых разрешений для проведения мероприятия
var isPermission by Delegates.notNull<Boolean>()
//Индикатор доступности специализированного оборудования в данный момент (например, специальному оборудованию)
var isEquipmentAvailable: Boolean = true
//Список партнеров мероприятия
val listOfEventPartners: MutableList<String> = mutableListOf("partner 1", "partner 2")
//Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
lateinit var hackathonReport: String
//Внутренние правила распределения призов
private val prizePlan: String = "prize plan"
//Список разыгрываемых призов
var listOfEventPrizes: List<String> = listOf("prize 1", "prize 2")
//Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
private val listOfExtra: List<String> = listOf("info 1", "info 2")
//Особые условия для участников с ограниченными возможностями
val accessibilityConditions: String = "..."
//Общее настроение участников (определяется опросами)
lateinit var participantsMood: String
//Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия, так как зависит от фактического состава команд и взятых в работу задач.
lateinit var detailedPlan: String
//Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия, но в момент инициализации неизвестно.
lateinit var specialGuest: String
//Максимальное количество людей, которое может вместить место проведения.
const val MAX_OF_PARTICIPANTS = 1000
//Kоличество часов, отведенное каждой команде для работы над проектом.
const val MAX_OF_TIME_FOR_WORK_IN_MIN = 100
//////////////////////////////////////////////////////////////HOMEWORK end/////////////////////////////////////////////////////////////////////////////////