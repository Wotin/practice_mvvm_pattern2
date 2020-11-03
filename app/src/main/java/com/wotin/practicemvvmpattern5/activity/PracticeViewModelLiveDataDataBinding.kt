package com.wotin.practicemvvmpattern5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.practicemvvmpattern5.R
import com.wotin.practicemvvmpattern5.adapter.LiveDataRecyclerViewAdapter
import com.wotin.practicemvvmpattern5.model.LiveDataModel
import com.wotin.practicemvvmpattern5.viewModel.LiveDataViewModel
import com.wotin.practicemvvmpattern5.viewModel.SubViewModel
import com.wotin.practicemvvmpattern5.databinding.ActivityPracticeViewModelLiveDataDataBindingBinding

class PracticeViewModelLiveDataDataBinding : AppCompatActivity(), LiveDataRecyclerViewAdapter.ItemSetOnLongClickInterface {

    private lateinit var mBinding : ActivityPracticeViewModelLiveDataDataBindingBinding
    private val subViewModel: SubViewModel by viewModels()
    lateinit var liveDataViewModel : LiveDataViewModel

    lateinit var liveDataRecyclerViewAdapter : LiveDataRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_practice_view_model_live_data_data_binding)

        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = subViewModel
        mBinding.activity = this@PracticeViewModelLiveDataDataBinding

        setInit()

        subViewModel.count.observe(this, Observer {count ->
            Log.d("TAG","count is $count")
        })

        liveDataViewModel.dataList.observe(this, Observer {data ->
            liveDataRecyclerViewAdapter.dataList = data
            liveDataRecyclerViewAdapter.notifyDataSetChanged()
            Log.d("TAG", "dataList observe")
            data.forEach {
                Log.d("TAG", "dataList observe data is $it")
            }
        })

    }

    fun dataListAdd() {
        Log.d("TAG", "addButton clicked")
        liveDataViewModel.add(LiveDataModel(title = mBinding.liveDataTitleEdittext.text.toString(), content = mBinding.liveDataContentEdittext.text.toString()))
    }

    fun setInit() {
        liveDataRecyclerViewAdapter = LiveDataRecyclerViewAdapter(this)
        liveDataRecyclerViewAdapter.dataList = arrayListOf()
        mBinding.liveDataRecyclerview.apply {
            adapter = liveDataRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@PracticeViewModelLiveDataDataBinding)
            setHasFixedSize(true)
        }
    }

    override fun itemLongClicked(position: Int) {
        Log.d("TAG", "itemLongClicked")
        liveDataViewModel.removeAt(position)
    }


}