package com.wotin.practicemvvmpattern5.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wotin.practicemvvmpattern5.model.LiveDataModel
import java.lang.Exception

class LiveDataViewModel(application: Application) : AndroidViewModel(application) {
    var dataList = MutableLiveData<ArrayList<LiveDataModel>>()

    init {
        dataList.value = arrayListOf()
    }

    fun add(data : LiveDataModel) {
        val secondDataList = dataList.value
        secondDataList!!.add(data)
        dataList.value = secondDataList
        Log.d("TAG","data is $data")
    }

    fun removeAt(idx : Int) {
        val secondDataList = dataList.value
        secondDataList!!.removeAt(idx)
        dataList.value = secondDataList
        Log.d("TAG","idx is $idx")
    }

}