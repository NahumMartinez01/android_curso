package com.nahum.androidcurso1.toDoApp

sealed class TaskCategory(var isSelected:Boolean = true) {

    object Personal:TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}