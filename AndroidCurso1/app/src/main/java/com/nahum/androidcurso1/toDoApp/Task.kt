package com.nahum.androidcurso1.toDoApp

data class Task(val name:String, val category:TaskCategory, var isSelected:Boolean = false) {
}