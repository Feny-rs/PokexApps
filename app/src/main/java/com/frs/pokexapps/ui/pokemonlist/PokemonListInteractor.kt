package com.frs.pokexapps.ui.pokemonlist

import com.frs.pokexapps.network.response.PokemonListResponse

interface PokemonListInteractor {
    interface PokemonListListener {

        fun onPokemonListFailed(e: Throwable, errorMessage: String)

        fun onPokemonListSuccess(response: PokemonListResponse)
    }

    fun getPokemonList(listener: PokemonListListener)
}
