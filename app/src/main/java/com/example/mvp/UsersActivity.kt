package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mvp.databinding.ActivityUsersBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUsersBinding;
    private lateinit var adapter : UsersAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(layoutInflater);
        setContentView(binding.root);

        adapter = UsersAdapter();

        binding.recv.layoutManager = LinearLayoutManager(this);
        binding.recv.adapter = adapter;

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user-database"
        ).build();

        GlobalScope.launch(Dispatchers.IO) {
            val users = db.userDao().getAllUsers();
            withContext(Dispatchers.Main) {
                adapter.setUserList(users);
            };
        };
    };
}