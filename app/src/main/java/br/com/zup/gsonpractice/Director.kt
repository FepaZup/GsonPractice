package br.com.zup.gsonpractice

import com.google.gson.annotations.SerializedName

data class Director(
    @SerializedName("nome_diretor")
    var name: String,
    @SerializedName("info_diretor")
    var info: String
)
