package com.wotin.practicemvvmpattern5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.wotin.practicemvvmpattern5.R
import com.wotin.practicemvvmpattern5.databinding.ActivityPracticeViewModelLiveDataDataBindingBinding
import com.wotin.practicemvvmpattern5.viewModel.SubViewModel

class PracticeViewModelLiveDataDataBinding : AppCompatActivity() {

    private lateinit var mBinding : ActivityPracticeViewModelLiveDataDataBindingBinding
    private val model: SubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_practice_view_model_live_data_data_binding)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = model

        model.count.observe(this, Observer {count ->
            Log.d("TAG","count is $count")
        })

    }


}