package com.example.puppywatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.puppywatch.databinding.ActivityBehaviorBinding

class BehaviorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBehaviorBinding
    val itemList = arrayListOf<BehaviorListItem>()      // 아이템 배열
    val listAdapter = BehavoirAdapter(itemList)     // 어댑터

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBehaviorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 레이아웃 매니저와 어댑터 설정
        binding.behaviorRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.behaviorRv.adapter = listAdapter

        // 아이템 추가
        itemList.add(BehaviorListItem("2023.01.02 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.01.12 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.01.22 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.01.32 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.01.42 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.01.52 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.03.02 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.03.12 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.03.22 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.03.32 13:00:12 - 이상행동", "new"))
        itemList.add(BehaviorListItem("2023.03.42 13:00:12 - 이상행동", "new"))

        // 리스트가 변경됨을 어댑터에 알림
        listAdapter.notifyDataSetChanged()
    }
}