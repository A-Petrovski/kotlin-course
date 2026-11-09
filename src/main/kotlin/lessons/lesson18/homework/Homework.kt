package petrovsky.lessons.lesson18.homework

import java.io.InputStream

//Интерфейсы для работы

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//
//Холодильник
abstract class Refrigerator : Powerable, Openable, TemperatureRegulatable, Cleanable, SoundEmitting {
}
//Стиральная машина
abstract class WashingMachine : Powerable, Openable, TemperatureRegulatable, WaterConnection, Drainable, Timable, SoundEmitting, Cleanable, AutomaticShutdown {
}
//Умная лампа
abstract class SmartLamp : Powerable, Timable,  LightEmitting, Programmable, AutomaticShutdown {
}
//Электронные часы
abstract class ElectronicClock : Powerable, Timable, BatteryOperated, SoundEmitting, Programmable, Movable, Rechargeable, AutomaticShutdown {
}
//Робот-пылесос
abstract class VacuumCleaner : Powerable, Openable, WaterContainer, Movable, Cleanable {
}
//Механические часы
abstract class MechanicsClock : Mechanical, Programmable, Movable {
}
//Фонарик
abstract class Flashlight : Powerable, BatteryOperated, LightEmitting, Movable, Rechargeable {
}
//Кофемашина
abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, AutomaticShutdown, Timable, Cleanable {
}
//Умная колонка
abstract class SmartSpeaker : Powerable, Timable, BatteryOperated, LightEmitting, SoundEmitting, Programmable, Movable, Rechargeable {
}

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class PowerableEquipment : Powerable{
    override fun powerOn() {
        println("equipment is power on")
    }

    override fun powerOff() {
        println("equipment is power off")
    }
}
//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
abstract class ProgrammableEquipment : PowerableEquipment(), Programmable {
    override fun programAction(action: String) {
        println("equipment program action $action")
    }
    override fun execute() {
        println("Something is executed")
    }
}
//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class TemeraturableEquipment : ProgrammableEquipment (), TemperatureRegulatable, Openable {
    override val maxTemperature: Int
        get() = 100
    override fun setTemperature(temp: Int) {
        println("Set temperature 80 c")
    }
    override fun open() {
        println("equipment is opened")
    }
    override fun close() {
        println("equipment is closed")
    }
}
//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
class WashingMachineReal : TemeraturableEquipment() {
}
//class
//Создай объекты этих устройств и позапускай их с различными методами.