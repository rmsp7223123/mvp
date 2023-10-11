package com.example.mvp

import org.json.JSONObject

interface InfoDataSource {

    interface LoadInfoCallback{ // 데이터를 로드할 때 사용되는 콜백
        fun onInfoLoaded(info: JSONObject); // 데이터를 성공적으로 로드하면 호출
        fun onDataNotAvailable(); // 데이터 로드에 실패하면 호출
    };

    fun getInfo(callback: LoadInfoCallback); // 데이터를 로드하기 위한 메서드
    fun saveInfo(info: JSONObject); // 데이터를 저장하기 위한 메서드
};