package com.example.mvp

import org.json.JSONObject

class Presenter (
    private val view : Contract.View, // 뷰 인터페이스를 구현한 클래스의 객체를 저장 이를 통해 뷰와 상호 작용
    private val repository: InfoRepository) : Contract.Presenter{ // 모델 역할을 하는 InfoRepository 객체를 저장 이를 통해 데이터를 로드하고 저장
    override fun initInfo() { //  초기 데이터를 로드하고 뷰에 표시하는 역할
        repository.getInfo(object: InfoDataSource.LoadInfoCallback { // 모델인 InfoRepository를 통해 데이터를 로드,
            // 로드된 데이터는 InfoDataSource.LoadInfoCallback 콜백을 통해 전달
            override fun onInfoLoaded(info: JSONObject) {
                view.showInfo(info);
            };
            override fun onDataNotAvailable() {};
        });
    };

    override fun setInfo(info: JSONObject) { // Contract.Presenter 인터페이스에서 상속받은 메서드인 setInfo를 구현
        view.showInfo(info); // 뷰에 데이터를 설정하여 표시하는 역할
    };

    override fun saveInfo(info: JSONObject) {// Contract.Presenter 인터페이스에서 상속받은 메서드인 saveInfo를 구현
        repository.saveInfo(info); // 입력된 데이터를 모델을 통해 저장하는 역할
    };

};
