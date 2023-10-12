package com.example.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity(), Contract.View { // Contract.View 인터페이스를 구현

    private lateinit var binding : ActivityMainBinding;
    private lateinit var presenter: Presenter; // MVP 아키텍처에서 프리젠터는 뷰와 모델 간의 중재자 역할
    private lateinit var repository: InfoRepository; // 실제 데이터를 관리하고 프리젠터에게 전달하는 역할

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        repository = InfoRepository(this);
        presenter = Presenter(this , repository); // 현재 액티비티를 뷰로 설정하고 InfoRepository 객체를 전달

        presenter.initInfo();
        initButtonListener();

        binding.btnMove.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java));
        };

    }

    override fun showInfo(info: JSONObject) { // 프리젠터에서 전달된 데이터를 화면에 표시하는 역할
        binding.nameOutput.text = info.getString("name"); // 받아온 JSON 데이터에서 "name" 키의 값을 읽어와서 화면의 텍스트 뷰에 설정
        binding.emailOutput.text = info.getString("email");
    };

    private fun initButtonListener() {
        binding.buttonSubmit.setOnClickListener {

            //클릭 시에 입력된 데이터를 JSON 객체로 만들고
            var info = JSONObject();
            info.put("name", binding.nameInput.text.toString());
            info.put("email", binding.emailInput.text.toString());

            binding.nameInput.text.clear();
            binding.emailInput.text.clear();

            presenter.setInfo(info); // 프리젠터의 setInfo 메서드를 호출하여 화면에 표시하고
            presenter.saveInfo(info);// // saveInfo 메서드를 호출하여 데이터를 저장
        };
    };
}