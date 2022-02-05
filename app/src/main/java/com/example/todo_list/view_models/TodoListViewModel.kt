package com.example.todo_list.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.data.models.Item
import com.example.todo_list.data.models.listOfItems
import com.example.todo_list.data.repository.ListItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val listItemsRepository: ListItemsRepository
): ViewModel() {
    val todoList = mutableStateListOf<Item>()

    init {
        viewModelScope.launch {
            listItemsRepository.getItems().collect {
                todoList.clear()
                todoList.addAll(it)
            }
        }
    }

    fun addItem(item: Item) = viewModelScope.launch {
        kotlin.runCatching {
            listItemsRepository.addItem(item)
        }.onSuccess {
            println("Exito al agregar el item")
        }.onFailure {
            it.printStackTrace()
        }
    }
}