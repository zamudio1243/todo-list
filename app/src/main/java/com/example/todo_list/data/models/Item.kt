package com.example.todo_list.data.models

data class Item(
    var name: String = "",
    var description: String = "",
    var isCompleted: Boolean = false,
    var tag: Tag? = null
)

fun listOfItems(): List<Item> {
    return listOf(
        Item(
            name = "Milk",
        ),
        Item(
            name = "Eggs",
            tag = Tag.BLUE
        ),
        Item(
            name = "Homework",
            tag = Tag.ORANGE
        ),
        Item(
            name = "Clean",
        ),
        Item(
            name = "Study",
        ),
    )

}