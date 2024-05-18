package com.protectly.sqllite.model.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "firstname") //cambia el nombre de la columna en la tabla
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Long = 2,
    val points: Long = 0
)
