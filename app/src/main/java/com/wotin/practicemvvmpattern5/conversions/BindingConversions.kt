package com.wotin.practicemvvmpattern5.conversions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.BindingAdapter

object BindingConversions {

    @BindingAdapter("resource")  // xml 의 app:resource="@{~~}" 의 resource 부분 resource 의 값을 src 파라메터로 받아옴.
    @JvmStatic  // 메모리 상에 올려야 하므로 Static 함수로 만들어야 한다.
    fun loadImage(imageView: ImageView, src : Int) {
        imageView.setImageResource(src)  // imageView 의 이미지를 src 로 set 해준다.
    }
}