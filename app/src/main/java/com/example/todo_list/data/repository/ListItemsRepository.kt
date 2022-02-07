package com.example.todo_list.data.repository

import com.example.todo_list.data.models.Item
import com.example.todo_list.data.repository.db.ListItemsDatabase
import com.example.todo_list.data.repository.network.Network
import com.example.todo_list.data.repository.network.NetworkData
import retrofit2.Callback
import com.example.todo_list.data.repository.network.toDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception


class ListItemsRepository(private val db: ListItemsDatabase) {

    suspend fun getItemsFromNetwork() {
            val response = Network.data.getItems().await()
            println(response.data)
            response.data.map {
                db.listItemsDao.insertItem(it.attributes.toDomainModel())
            }
    }
    fun getItemsFromDB(): Flow<List<Item>>{
        return db.listItemsDao.getItems()
    }
}
