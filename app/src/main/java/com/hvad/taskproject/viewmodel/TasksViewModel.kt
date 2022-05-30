package com.hvad.taskproject.viewmodel

import androidx.lifecycle.*
import com.hvad.taskproject.model.Task
import com.hvad.taskproject.model.TaskDao
import kotlinx.coroutines.launch

class TasksViewModel (val dao: TaskDao): ViewModel() {
    var newTaskName=""
    val tasks= dao.getAll()


    private val _navigateToTask= MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
    get() = _navigateToTask

    //Makes one big string out of String list
//    val tasksString = Transformations.map(tasks){
//        tasks -> formatTasks(tasks)
//    }

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName= newTaskName
            dao.insert(task)
        }


    }

    fun onTaskClicked(taskId: Long){
        _navigateToTask.value= taskId
    }

    fun onTaskNavigated(){
        _navigateToTask.value=null
    }

//    fun formatTasks(tasks: List<Task>):String {
//        return tasks.fold(""){
//            str, item -> str + '\n'+formatTask(item)
//        }
//    }
//
//    fun formatTask(task: Task): String {
//        var str = "ID: ${task.taskId}"
//        str+='\n'+"Name: ${task.taskName}"
//        str+='\n'+ "Complete: ${task.taskDone}+\n"
//        return str
//    }
}