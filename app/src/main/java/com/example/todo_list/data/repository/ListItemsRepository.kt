package com.example.todo_list.data.repository

import com.example.todo_list.data.models.Item
import com.example.todo_list.data.repository.db.ListItemsDao
import kotlinx.coroutines.flow.Flow


interface ListItemsRepository{
    fun getItems(): Flow<List<Item>>

    suspend fun addItem(item: Item)
}

class ListItemsFromDB(
    private val dao: ListItemsDao
): ListItemsRepository{
    override fun getItems(): Flow<List<Item>> {
        return dao.getItems()
    }

    override suspend fun addItem(item: Item) {
        dao.insertItem(item)
    }
}
/*
class ListItemsRepository(
    val listItemsDao: ListItemsDao
    ) {
    val allItems: Flow<List<Item>> = listItemsDao.getItems()
}
 */