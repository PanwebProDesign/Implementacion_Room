package com.protectly.sqllite.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.protectly.sqllite.R
import com.protectly.sqllite.model.bd.User

class UserAdapter(private val users: List<User>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    interface OnItemClickListener {
        fun onEditClick(user: User)
        fun onDeleteClick(user: User)
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.firstName)
        val lastName: TextView = itemView.findViewById(R.id.lastName)
        val email: TextView = itemView.findViewById(R.id.email)
        val editButton: Button = itemView.findViewById(R.id.btnEdit)
        val deleteButton: Button = itemView.findViewById(R.id.btnDelete)

        init {
            editButton.setOnClickListener {
                listener.onEditClick(users[adapterPosition])
            }
            deleteButton.setOnClickListener {
                listener.onDeleteClick(users[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.firstName.text = user.first_name
        holder.lastName.text = user.last_name
        holder.email.text = user.email
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
