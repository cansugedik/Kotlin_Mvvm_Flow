package com.example.kotlin_flow_mvvm.model

import android.os.Parcel
import android.os.Parcelable


import com.google.gson.annotations.SerializedName

data class CommentModel(
    val postId: Int?=null,
    val id: Int?=null,
    val email: String?=null,
    val name:String?=null,

    @SerializedName("body")
    val comment: String?=null
)