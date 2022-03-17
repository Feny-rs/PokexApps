package com.frs.pokexapps.network.response

import com.google.gson.annotations.SerializedName
import com.frs.pokexapps.model.Ability
import com.frs.pokexapps.model.Move
import com.frs.pokexapps.model.Sprite

class PokemonDetailResponse : BaseResponse() {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("sprites")
    var sprites: Sprite? = null

    @SerializedName("moves")
    var moves: ArrayList<Move>? = null

    @SerializedName("weight")
    var weight: Int? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("abilities")
    var abilities: ArrayList<Ability>? = null
}