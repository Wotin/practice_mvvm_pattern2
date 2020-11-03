package com.wotin.practicemvvmpattern5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wotin.practicemvvmpattern5.R
import com.wotin.practicemvvmpattern5.model.ProfileData
import com.wotin.practicemvvmpattern5.databinding.RcvListItemBinding

class ProfileAdapter(private val context: Context) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {
    var profileList : ArrayList<ProfileData> = arrayListOf()
    val DURATION = 500

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val binding = RcvListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return CustomViewHolder(
            binding
        ).apply {
            binding.itemProfile.setOnClickListener {
                Toast.makeText(context.applicationContext, "$adapterPosition Image Clicked!", DURATION).show()
            }
            itemView.setOnClickListener {
                Toast.makeText(context.applicationContext, "$adapterPosition ItemView Clicked!", DURATION).show()
            }
        }
    }

    override fun getItemCount() = profileList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.onBind(profileList[position])
    }

    class CustomViewHolder(val binding : RcvListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ProfileData) {
            if(data.name.startsWith("K")) data.profile =
                R.drawable.puffin  // K 로 시작하면 profile 의 resource 를 puffin 으로 변경.
            else if(data.name.startsWith("N")) data.profile =
                R.drawable.brain  // N 으로 시작하면 profile 의 resource 를 brain 으로 변경.
            binding.user = data  // dataBinding
        }
    }
}
