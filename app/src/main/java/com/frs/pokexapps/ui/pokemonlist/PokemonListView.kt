package com.frs.pokexapps.ui.pokemonlist

import com.frs.pokexapps.network.response.PokemonListResponse
import com.frs.pokexapps.ui.base.IView

interface PokemonListView : IView {
    fun setPokemonList(response: PokemonListResponse)
}
