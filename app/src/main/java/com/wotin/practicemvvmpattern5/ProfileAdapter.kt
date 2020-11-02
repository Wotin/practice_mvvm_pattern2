package com.wotin.practicemvvmpattern5

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wotin.practicemvvmpattern5.model.ProfileData
import com.wotin.practicemvvmpattern5.databinding.RcvListItemBinding

class ProfileAdapter(private val context: Context) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {
    var profileList : ArrayList<ProfileData> = arrayListOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.CustomViewHolder {
        val binding = RcvListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return CustomViewHolder(binding)
    }

    override fun getItemCount() = profileList.size

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.onBind(profileList[position])
    }

    class CustomViewHolder(val binding : RcvListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ProfileData) {
            binding.user = data
        }
    }
}
