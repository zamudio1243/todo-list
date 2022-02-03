package com.example.todo_list.data.models

data class Item(
    var name: String = "",
    var description: String = "",
    var isCompleted: Boolean = false,
    var tag: Tag? = null
)

