package com.wotin.practicemvvmpattern5.adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wotin.practicemvvmpattern5.databinding.LiveDataRecyclerviewItemBinding
import com.wotin.practicemvvmpattern5.model.LiveDataModel
import com.wotin.practicemvvmpattern5.viewModel.LiveDataViewModel

class LiveDataRecyclerViewAdapter(val itemSetOnLongClick : ItemSetOnLongClickInterface) : RecyclerView.Adapter<LiveDataRecyclerViewAdapter.CustomViewHolder>(){

    interface ItemSetOnLongClickInterface {
        fun itemLongClicked(position: Int)
    }

    var dataList: ArrayList<LiveDataModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = LiveDataRecyclerviewItemBinding.inflate(  // 자동적으로 해당 xml 이름으로 클래스가 생김. 예) xml : live_data_recyclerview_item, class : LiveDataRecyclerViewItemBinding
            LayoutInflater.from(parent.context), parent, false
        )
        return CustomViewHolder(binding).apply {
            itemView.setOnLongClickListener {
                itemSetOnLongClick.itemLongClicked(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    class CustomViewHolder(val binding : LiveDataRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : LiveDataModel) {
            binding.livedatamodel = data
        }
    }
}
