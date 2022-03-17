package com.frs.pokexapps.network.response

import com.google.gson.annotations.SerializedName
import com.frs.pokexapps.model.Pokemon

class PokemonListResponse : BaseResponse() {

    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: ArrayList<Pokemon>? = null

}