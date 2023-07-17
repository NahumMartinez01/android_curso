package com.nahum.androidcurso1

/*
    Arrays
*/

fun main(){
    var name:String = "Nahum"

    val weekDays = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

    println(weekDays.size)

    //Para comprobar a que elementos puedo acceder del array sin tener el conocimiento de cuantos elementos
    //tiene el array podemos hacer lo siguiente:

    weekDays[0] = "Holita"

     if(weekDays.size >= 8 ){
       // println(weekDays[7])
     }else {
        // println("No hay mas valores dentro del array")
     }

    println(weekDays[0])


    ///recorrer array atraves de bucles

    //Bucle For


    for(position in weekDays.indices){
   // println(weekDays[position])
    }


    for((position,value) in weekDays.withIndex()){
      //  println("La posicion $position contiene $value")
    }


    for(weekDay in weekDays){
        println("Ahora es $weekDay")
    }



}


fun arrays(){

}