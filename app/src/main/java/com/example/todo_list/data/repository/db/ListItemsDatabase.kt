package com.example.todo_list.data.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo_list.data.models.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ListItemsDatabase: RoomDatabase() {
    abstract val listItemsDao: ListItemsDao
}