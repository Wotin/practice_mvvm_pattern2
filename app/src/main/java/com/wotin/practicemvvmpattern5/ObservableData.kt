package com.wotin.practicemvvmpattern5

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class ObservableData : BaseObservable() {
    @get:Bindable
    var text : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.text)
    }
}