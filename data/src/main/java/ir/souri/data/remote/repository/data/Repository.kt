package ir.souri.data.remote.repository.data

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("owner") val owner: Owner,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("html_url") val url: String,
    @SerializedName("language") val language: String
)

data class Owner(
    @SerializedName("login") val loginName: String,
    @SerializedName("avatar_url") val avatarUrl: String
)