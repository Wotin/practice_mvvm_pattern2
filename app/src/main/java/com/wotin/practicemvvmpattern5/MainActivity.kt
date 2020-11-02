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
            ProfileData(name = "Kim", age = 25),
            ProfileData(name = "Nam", age = 23)
        )
        profileAdapter.notifyDataSetChanged()
    }

}