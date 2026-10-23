package petrovsky.lessons.lesson15.homework

import kotlin.math.max

abstract class Figure {

}

open class Polygon: Figure() {

}

open class  Circle: Figure() {

}

class Square(): Polygon() {

}

abstract class EducationalInstitution {

}

open class School: EducationalInstitution () {

}

class PreSchool: School() {

}

abstract class Furniture {

}

open class Table: Furniture() {

}

class  OfficeTable: Table() {

}

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class InsertFirstMaterial: Materials() {
    fun insert(material: String) {
        val materials = extractMaterials()
        addMaterial(material)
        materials.forEach{addMaterial(it)}
    }
}

class InsertSecondMaterial: Materials () {
    fun insert(material: List<String>) {
        val materials = extractMaterials()
        val max = max(material.lastIndex, materials.lastIndex)
        for (i in 0..max) {
            if (i < material.size) {
                addMaterial(material[i])
            }
            if (i < materials.size) {
                addMaterial(materials[i])
            }
        }
    }
}

class InsertThirdMaterial: Materials() {
    fun insert(material: String) {
        val  materials = (extractMaterials() + material).sorted()
        materials.forEach {
            addMaterial(it)
        }
    }
}

class  InsertForthMaterial: Materials() {
    fun insert(material: Map<String, String>) {
        val materials = material.keys.reversed() + extractMaterials() + material.values
        materials.forEach {
            addMaterial(it)
        }
    }
}