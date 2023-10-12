package com.example.mvp

class UserPresenter (
    private val view : UserContract.view,
    private val repository: UserRepository) : UserContract.Presenter{

    override suspend fun getUsers() {
        repository.getAllUsers(object : UserRepository.Callback {
            override fun onSuccess(users: List<User>) {
                view.showUsers(users);
            };

            override fun onError(message: String) {
                view.showError(message);
            };
        });
    }

    override suspend fun addUser(user: User) {
        repository.insertUser(user, object : UserRepository.Callback {
            override fun onSuccess(users: List<User>) {
                view.showUsers(users);
            };

            override fun onError(message: String) {
                view.showError(message);
            };
        });
    };

}
