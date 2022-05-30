package com.hvad.taskproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hvad.taskproject.model.TaskDao

class EditTaskViewModelFactory(private val taskId: Long, private val dao: TaskDao): ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     * Default implementation throws [UnsupportedOperationException].
     *
     * @param modelClass a `Class` whose instance is requested
     * @return a newly created ViewModel
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditTaskViewModel::class.java))
        {
            return  EditTaskViewModel(taskId, dao) as T
        }
        throw IllegalArgumentException("Unknown viewModel")
    }
}