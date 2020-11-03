package com.wotin.practicemvvmpattern5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.practicemvvmpattern5.model.ProfileData
import com.wotin.practicemvvmpattern5.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var textItem : ObservableData = ObservableData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        setRcv()
        binding.item = textItem
        binding.editText.onEditTextChanged {
            textItem.text = it.toString()
        }
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

fun EditText.onEditTextChanged(function: (Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            function(s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    })
}