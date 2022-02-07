package com.example.todo_list.hilt_modules

import android.app.Application
import androidx.room.Room
import com.example.todo_list.data.repository.ListItemsRepository
import com.example.todo_list.data.repository.db.ListItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideListItemsDatabase(
        app: Application
    ): ListItemsDatabase{
        return Room.databaseBuilder(
            app,
            ListItemsDatabase::class.java,
            "list_items_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideItemsRepository(db: ListItemsDatabase): ListItemsRepository{
        return ListItemsRepository(db)
    }




}