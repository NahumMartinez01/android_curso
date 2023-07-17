package com.nahum.androidcurso1

/*
    USO DEL WHEN:
 */

fun main(){
    getSemester(10)
}

fun result(value:Any){
    //Palabra reservada is para comparar si es un tipo de dato por ejemplo: int, string, boolean etc...
    when(value){
        is Int -> print(value + value)
        is String -> print(value)
        is Boolean -> if(value) print("Soy verdadero")
    }
}

fun getSemester(semester:Int):String{
    //rangos en kotlin con la palabra "in" y "..."
    //Un when puede retornar datos
    //Un  when puede ser almacenado dentro de una variable


    return when(semester){
        in 1..6 -> return "Primer Semestre"
        in 7 .. 12 -> return "Segundo Semestre"
        !in 1..12 -> return "Semestre no valido"
        else -> return "Semestre no valido"
    }


}



fun getTrimester(mont:Int){
    when(mont){
        1,2,3 -> println("Primer Trimestre")
        4,5,6 -> println("Segundo Trimestre")
        7,8,9 -> println("Tercer Trimestre")
        10,11,12 -> println("Cuarto Trimestre")

    }
}


fun getMonth(month:Int){
    when(month){
        1 -> println("enero")
        2 -> println("febrero")
        3 -> println("marzo")
        4 -> println("abril")
        5 -> println("mayo")
        6 -> println("junio")
        7 -> println("julio")
        8 -> println("agosto")
        9 -> println("septiembre")
        10 -> println("octubre")
        11 -> println("noviembre")
        12 -> println("diciembre")
        else -> println("No es un mes válido")
    }
}


