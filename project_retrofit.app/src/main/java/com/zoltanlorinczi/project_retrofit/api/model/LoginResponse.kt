package com.zoltanlorinczi.project_retrofit.api.model

import com.google.gson.annotations.SerializedName

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/8/2021
 */
data class LoginResponse(
    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("phone_number")
    var phone_number: Int,

    @SerializedName("token")
    var token: String,

    @SerializedName("creation_time")
    var creation_time: Long,

    @SerializedName("refresh_time")
    var refresh_time: Long
) {
    override fun toString(): String {
        return "LoginResponse(username='$username', email='$email', phone_number=$phone_number," +
                " token='$token', creation_time=$creation_time, refresh_time=$refresh_time)"
    }
}