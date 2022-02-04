package com.example.todo_list.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todo_list.data.models.Item
import com.example.todo_list.data.models.listOfItems

class TodoListViewModel: ViewModel() {
    val todoList = mutableStateListOf<Item>()

    init {
        todoList.addAll(listOfItems())
    }
}