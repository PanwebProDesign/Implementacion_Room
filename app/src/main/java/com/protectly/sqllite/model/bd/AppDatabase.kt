package com.protectly.sqllite.model.bd

import androidx.room.Database
import androidx.room.RoomDatabase

//aqui se va a crear la base de datos
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao
}