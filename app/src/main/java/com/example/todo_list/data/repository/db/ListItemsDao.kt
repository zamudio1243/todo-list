package com.example.todo_list.data.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo_list.data.models.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ListItemsDao{

    @Query("SELECT * FROM items_table")
    fun getItems(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)
}