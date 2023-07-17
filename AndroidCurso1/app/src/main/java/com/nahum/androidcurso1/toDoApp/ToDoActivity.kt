
package com.nahum.androidcurso1.toDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nahum.androidcurso1.R

class ToDoActivity : AppCompatActivity() {

    private val categories = listOf<TaskCategory>(
         TaskCategory.Other,
        TaskCategory.Personal,
        TaskCategory.Business
    )

    private val task = mutableListOf<Task>(

    )

    private lateinit var rvCategoria:RecyclerView
    private lateinit var categoriesAdapter:CategoriesAdapter

    private lateinit var  rvTask:RecyclerView
    private lateinit var  taskAdapter: TaskAdapter

    private lateinit var fabAddTask:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        initComponents()
        initUI()
        initListener()
    }

    private fun initListener() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAdd = dialog.findViewById<Button>(R.id.addTask)
        val etTask: TextView =  dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAdd.setOnClickListener{
            if(etTask.text.toString().isEmpty()){
                 dialog.hide()
            }else{
                val selectedId = rgCategories.checkedRadioButtonId
                val selecteRadioButton:RadioButton = rgCategories.findViewById(selectedId)
                val currentRadioButton:TaskCategory = when(selecteRadioButton.text) {
                    getString(R.string.negocio)->{
                        TaskCategory.Business
                    }
                    getString(R.string.personal) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }
                task.add(Task(etTask.text.toString(), currentRadioButton))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show()
    }


    private fun initComponents() {
        rvCategoria=findViewById(R.id.rvCategorias)
        rvTask=findViewById(R.id.rvTask)
        fabAddTask=findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories){position -> updateCategories(position)}
        rvCategoria.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategoria.adapter = categoriesAdapter


        taskAdapter = TaskAdapter(task) { onItemSelected(it) }
        //Solo ponemos this si queremos que la lista sea vertical
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun onItemSelected(position: Int){
        task[position].isSelected  = !task[position].isSelected
        updateTask()
        filter()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        filter()
    }


    private fun updateTask(){

        taskAdapter.notifyDataSetChanged()
    }

    private fun filter(){
        val selectedCategories:List<TaskCategory> = categories.filter {
                selected -> selected.isSelected
        }

        val newTask = task.filter {!selectedCategories.contains(it.category) }
        taskAdapter.task = newTask
        taskAdapter.notifyDataSetChanged()
    }

}