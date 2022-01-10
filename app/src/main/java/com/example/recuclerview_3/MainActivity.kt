package com.example.recuclerview_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recuclerview_3.adapter.CustomAdapter
import com.example.recuclerview_3.databinding.ActivityMainBinding
import com.example.recuclerview_3.model.Member

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()

        val member = memberList()
        refreshAdapter(member)

    }

    private fun initViews() {
        bin.recyclerview.layoutManager = GridLayoutManager(this, 1)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(this, members)
        bin.recyclerview.adapter = adapter
    }

    private fun memberList(): ArrayList<Member> {
        val members = ArrayList<Member>()
        members.add(Member("", "", false))
        for (i in 0..50) {
            if (i % 5 == 0) {
                members.add(Member("Android", "$i", false))
            } else {
                members.add(Member("Android", "$i", true))
            }
        }
        members.add(Member("", "", false))
        return members
    }
}