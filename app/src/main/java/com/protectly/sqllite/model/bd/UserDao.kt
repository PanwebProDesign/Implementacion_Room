package com.protectly.sqllite.model.bd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun obtenerTodos(): List<User>

    @Insert
    fun insertar(usuario: User)

    @Update
    fun actualizar(usuario: User)

    @Delete
    fun eliminar(usuario: User)
}