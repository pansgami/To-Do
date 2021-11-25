package com.pansgami.to_do.data.repositories

import android.app.DownloadManager
import com.pansgami.to_do.data.ToDoDao
import com.pansgami.to_do.data.modal.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> =toDoDao.getAllTasks()

    val sortByLowPriority: Flow<List<ToDoTask>> =toDoDao.sortByLowPriority()

    val sortByHighPriority: Flow<List<ToDoTask>> =toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId :Int): Flow<ToDoTask>
    {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask :ToDoTask)
    {
        toDoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask)
    {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask)
    {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks()
    {
        toDoDao.deleteAllTask()
    }

    fun searchDatabase(searchQuery:String): Flow<List<ToDoTask>>
    {
        return toDoDao.searchDatabse(searchQuery = searchQuery)
    }


}