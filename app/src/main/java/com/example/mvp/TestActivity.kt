package com.example.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.mvp.databinding.ActivityTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user-database"
        ).build();

        binding.buttonSubmit.setOnClickListener {
            val id = binding.nameInput.text.toString();
            val pw = binding.emailInput.text.toString();

            GlobalScope.launch(Dispatchers.IO) {
                val user = User(0, id, pw);
                db.userDao().insertUser(user);
            };
        };

        binding.btnMove.setOnClickListener {
            startActivity(Intent(this, UsersActivity::class.java));
        };
    }
}