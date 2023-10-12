package com.example.mvp

import androidx.room.Dao

class UserRepository(private val userDao:UserDao) {

    interface Callback{
        fun onSuccess(user : List<User>);
        fun onError(message : String);
    }

    suspend fun getAllUsers(callback :Callback){
        val users = userDao.getAllUsers();
        callback.onSuccess(users);
    }

    suspend fun insertUser(user: User, callback: Callback) {
        userDao.insertUser(user);
        val users = userDao.getAllUsers();
        callback.onSuccess(users);
    }
}