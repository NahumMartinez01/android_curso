package com.nahum.androidcurso1

//Las variables en android pueden ser nullas

fun main(){
    //el signo "?" esto significa que el tipo de dato es nullable
    //por ejemplo "String?" Significa que este String es nullable


        var name:String? = "Aris"

    println(name!![2]) //<- Con esto estamos diciendo que el valor que queremos acceder no es null con los simbolos " !! "
                      // En pocas palabras con "!!" estamos diciendo que en ese valor no hay un nulo.


        println(name?.get(2)) //<- Con esto estamos diciendo si esto no es nulo has algo con el signo de " ? " 4
                      //En pocas palabras con este signo estamos evaluando si el valor no es nulo has lo siguiente


    ///OPERADOR ELVIS
                       //👇 este es el operador elvis
    println(name?.get(3) ?: "Es nulo el elemento")

    if(name == "Aris"){

    }

}