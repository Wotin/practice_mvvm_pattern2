package com.wotin.practicemvvmpattern5.model

class LiveDataModel (
    val title : String,
    val content : String
) {
    override fun toString(): String {
        return "title: $title, content: $content"
    }
}