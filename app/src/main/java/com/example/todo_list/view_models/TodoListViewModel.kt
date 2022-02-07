package com.example.todo_list.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.data.models.Item
import com.example.todo_list.data.repository.ListItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val listItemsRepository: ListItemsRepository
) : ViewModel() {
    val todoList = mutableStateListOf<Item>()

    private val viewModelJob = SupervisorJob()
    private val vmScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        vmScope.launch {
            listItemsRepository.getItemsFromNetwork()
        }
    }
    init {
        viewModelScope.launch {
            listItemsRepository.getItemsFromDB().collect {
                todoList.clear()
                todoList.addAll(it)
            }
        }
    }
}

//    fun addItem(item: Item) = viewModelScope.launch {
//        kotlin.runCatching {
//            listItemsRepository.addItem(item)
//        }.onSuccess {
//            println("Exito al agregar el item")
//        }.onFailure {
//            it.printStackTrace()
//        }
//    }