package com.frs.pokexapps.ui.pokemondetail

import com.frs.pokexapps.network.response.PokemonDetailResponse
import com.frs.pokexapps.ui.base.IView

interface PokemonDetailView : IView {
    fun setPokemonDetail(response: PokemonDetailResponse)
}