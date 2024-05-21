package com.protectly.sqllite.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.protectly.sqllite.databinding.ActivityMainBinding
import com.protectly.sqllite.model.bd.AppDatabase
import com.protectly.sqllite.model.bd.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), UserAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var adapter: UserAdapter
    private var userList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "bd_users"
        ).build()

        setupRecyclerView()
        loadUsers()

        binding.btnAdd.setOnClickListener {
            val newUser = User(
                first_name = binding.etFirstName.text.toString(),
                last_name = binding.etLastName.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
            GlobalScope.launch {
                database.userDao().insert(newUser)
                loadUsers()
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = UserAdapter(userList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadUsers() {
        GlobalScope.launch {
            userList.clear()
            userList.addAll(database.userDao().getAllUsers())
            runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onEditClick(user: User) {
        // Logic to edit user
    }

    override fun onDeleteClick(user: User) {
        GlobalScope.launch {
            database.userDao().delete(user)
            loadUsers()
        }
    }
}
