package com.frs.pokexapps.ui.pokemondetail

import com.frs.pokexapps.network.response.PokemonDetailResponse

interface PokemonDetailInteractor {
    interface PokemonDetailListener {

        fun onPokemonDetailFailed(e: Throwable, errorMessage: String)

        fun onPokemonDetailSuccess(response: PokemonDetailResponse)
    }

    fun getPokemonDetail(name: String?, listener: PokemonDetailListener)
}
