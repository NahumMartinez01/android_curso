package com.nahum.androidcurso1

//Listas en Kotlin


fun main(){
   // inmutableList()
    mutableList()

}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")

    // println(readOnly.size)

  //  println(readOnly) // -> Es lo mismo que hacer readOnly.toString()

//    println(readOnly[0])

   // println(readOnly.last())
   // println(readOnly.first())

    //val example = readOnly.filter{it.contains("a")}
    //println(example)


    ///RECORRER LISTAS CON FOREACH

    readOnly.forEach{ weekday->
        println(weekday)
    }


}


fun mutableList(){
    var weeksDay:MutableList<String> = mutableListOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")

    weeksDay.add(0,"kotlinDay")
    println(weeksDay)

    if(weeksDay.isEmpty()){
        println("No hay nada")
    }else {
        weeksDay.forEach{ println(it) }
    }

    if(weeksDay.isNotEmpty()){
        weeksDay.forEach{ println(it) }
    }

    weeksDay.last()


    for(item in weeksDay){
        println(item)
    }
}