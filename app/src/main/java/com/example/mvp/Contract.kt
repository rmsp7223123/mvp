package com.example.mvp

import org.json.JSONObject

interface Contract {
    interface View {
        fun showInfo(info: JSONObject); // 프리젠터에 전달된 데이터를 뷰에 표시
    };

    interface Presenter {

        // onCreate 화면 초기화 시에 저장된 데이터가 있는지 Model 에서 확인 하고 확인한 결과에 따라 View 에 어떤 내용을 보일지 지시
        fun initInfo();

        fun setInfo(info: JSONObject); // 뷰에서 받은 데이터를 프리젠터에 설정
        fun saveInfo(info: JSONObject); // 입력한 데이터나 수정된 데이터를 저장
    };
}