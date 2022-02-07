package com.example.todo_list.data.repository.network

import com.example.todo_list.data.models.Item
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class NetworkItem(
    @Json(name = "name") val name: String,
    @Json(name = "isCompleted") val isCompleted: Boolean
)

data class NetworkAttributes(
    @Json(name = "attributes") val attributes: NetworkItem
)

data class NetworkData(
    @Json(name = "data") val data: List<NetworkAttributes>
)

fun NetworkItem.toDomainModel(): Item {
    return Item(
        name = this.name,
        //isCompleted = this.isCompleted
    )
}