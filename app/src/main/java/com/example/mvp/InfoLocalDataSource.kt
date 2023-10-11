package com.example.mvp

import android.content.Context
import org.json.JSONObject

class InfoLocalDataSource(context : Context) : InfoDataSource {

    private val sharedPreferences = context.getSharedPreferences("info", Context.MODE_PRIVATE); // 데이터를 로컬에 저장하기 위한 객체
    private val editor = sharedPreferences.edit(); // sharedPreferences를 수정하기 위한 객체

    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) { // 저장된 데이터를 가져와서 콜백을 통해 결과를 전달
        var info = sharedPreferences.getString("info", null); // info로 저장된 키를  가져옴
        if(info != null) {
            callback.onInfoLoaded(JSONObject(info)); // onInfoLoaded콜백을 호출하여, JSONObject로 변환한 데이터를 전달
        }else {
            callback.onDataNotAvailable();
        };
    };

    override fun saveInfo(info: JSONObject) { // InfoDataSource에서 상속받은 saveInfo를 구현
        editor.putString("info", info.toString()); // info키로 JSON 데이터를 문자열로 변환하여 저장
        editor.commit(); // SharedPreferences에 저장
    };
}