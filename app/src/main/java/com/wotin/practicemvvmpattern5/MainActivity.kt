package com.wotin.practicemvvmpattern5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.practicemvvmpattern5.model.ProfileData
import com.wotin.practicemvvmpattern5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        setRcv()
    }

    fun btnClick(view: View) {
        Toast.makeText(applicationContext, "Button Click", Toast.LENGTH_SHORT).show()
    }

    fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.apply {
            adapter = profileAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        profileAdapter.profileList = arrayListOf(
            ProfileData(profile = R.drawable.brain, name = "Kim", age = 25),
            ProfileData(profile = R.drawable.puffin, name = "Nam", age = 23),
            ProfileData(profile = R.drawable.brain, name = "NNNNNNNNNNNN", age = 80)
        )
        profileAdapter.notifyDataSetChanged()
    }

}