package com.example.mvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.databinding.ItemRecvBinding

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var userList: List<User> = emptyList();

    inner class ViewHolder(var binding: ItemRecvBinding) : RecyclerView.ViewHolder(
        binding.root
    );

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRecvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        );
    }

    override fun getItemCount(): Int {
        return userList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.id.text = userList[position].user_id;
        holder.binding.pw.text = userList[position].user_pw;
    };

    fun setUserList(users: List<User>) {
        userList = users;
        notifyDataSetChanged();
    };
}