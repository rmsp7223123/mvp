package com.example.mvp

interface UserContract {
    interface view {
        fun showUsers(users : List<User>);
        fun showError(message : String);
    }

    interface Presenter{
        suspend fun getUsers();
        suspend fun addUser(user : User);
    }
}