package com.example.mvp

import android.content.Context
import org.json.JSONObject

class InfoRepository(context : Context) : InfoDataSource  {

    private val infoLocalDataSource = InfoLocalDataSource(context); // 로컬 데이터 소스를 다루는데 사용

    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) { // InfoLocalDataSource를 통해 데이터를 로드하고, 결과를 콜백을 통해 전달
        infoLocalDataSource.getInfo(callback); // InfoLocalDataSource의 getInfo 메서드를 호출하여 데이터를 로드하고, 결과를 callback을 통해 전달
    };

    override fun saveInfo(info: JSONObject) { // InfoLocalDataSource를 통해 받아온 데이터를 저장
        infoLocalDataSource.saveInfo(info); // InfoLocalDataSource의 saveInfo 메서드를 호출하여 데이터를 저장
    };
}