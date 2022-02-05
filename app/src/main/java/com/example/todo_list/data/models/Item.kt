package com.example.todo_list.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items_table")
data class Item(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "isCompleted") var isCompleted: Boolean = false,
    @ColumnInfo(name = "tag") var tag: Tag? = null
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