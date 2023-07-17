package com.nahum.androidcurso1

//VARIABLES EN KOTLIN
/*
   De esta manera tambien podemos agregar comentarios
*/

/*
    Si colocamos una variable fuera de las funciones se transforma en una funcion de clase
    y se púede acceder a ella desde cualquier parte del codigo dentro de la clase
 */

val age: Int = 25

fun main() {


    // variablesNumericas()
    // variableAlfaNumerica()
    // variableBoolean()
    // variablesYValores()

    showMyName()
    showMyAge()
    showMyAge(15)
    showMyAge(55)
    showMyAge(10)

    add(15,15)
    add(20,50)

    val mySubtract = substract(10,5)
    print(mySubtract)
}


/*
    Funciones kotlin
*/


fun showMyName() {
    println("Me llamo Nahum")
}

fun showMyAge(age: Int = 23)  {
    println("Tengo $age años")
}

fun add(firstNumber: Int, secondNumber: Int) {
    println(firstNumber + secondNumber)
}

//Función de Salida:
fun substract(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}

//funcion en una sola linea de salida
//Es para funciones pequeñas. de una sola linea

fun substractOneLine(firstNumber: Int, secondNumber: Int):Int = firstNumber - secondNumber

fun variablesNumericas() {
    //Declarar variable de tipo Int se usa la siguiente sintaxis:

    val age: Int = 12

    //Variable Long se usa la siguiiente sintaxis:

    val example: Long = 300

    //Variable Float se usa la siguiente sintaxis :
    //Debemos agregar la "f" al final del valor para que kotlin sepa que es un valor float
    val floatExample: Float = 30.5f


    //Variables Double

    var doubleExample: Double = 20.50

}


fun variableAlfaNumerica() {


    //Para crear una variable podemos usar la palabra clave "val"

    val name = "Nahum"


    /*

       Variables alfanumericas

    */


    //variable "chart"
    //Va entre comillas simples

    val chartExample = 'v'


    //Variable "String"

    val stringExample: String = "Es un texto mas largo que chart"

}


fun variableBoolean() {
    /*

      Variables de tipo Boolean

   */

    //Boolean

    //true


    val falseBoolean: Boolean = false
    val trueBoolean: Boolean = true

}

fun variablesYValores() {
    ///Usar console para mostrar algo por ejemplo una variable o un texto


    /*

        tipos de variable en Kotlin hay dos tipos:

        > val : Es una constante o tambien llamado "valor";

        >var :  Es una "variable" no constante lo cual nos permite poder modificar su valor;

     */

    //Ejemplos de val :
    //Esta variable declarada con la palabra clave "val" son constantes

    val exampleVal: Float = 35.5f

    //Ejemplo de var :
    //Esta variable declarada con la palabra clave "var" no son constantes:

    var exampleAgeVar: Int = 23
    exampleAgeVar = 20

    println("Sumar: ")


    //Para interpolar una variable dentro de otra en un texto usamos la siguiente sintaxis:

    var saludosExample: String = "Hola"
    var nombreExample: String = "Nahum"

    var saludar: String = "$saludosExample me llamo $nombreExample"

    println(saludar)


}