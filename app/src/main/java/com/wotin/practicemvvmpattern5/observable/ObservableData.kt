package com.wotin.practicemvvmpattern5.observable

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.wotin.practicemvvmpattern5.BR

class ObservableData : BaseObservable() {
    @get:Bindable
    var text : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.text)
    }
}