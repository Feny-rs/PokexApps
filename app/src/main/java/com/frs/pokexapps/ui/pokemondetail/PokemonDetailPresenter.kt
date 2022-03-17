package com.frs.pokexapps.ui.pokemondetail

import com.frs.pokexapps.ui.base.IPresenter

interface PokemonDetailPresenter : IPresenter {
    fun getPokemonDetail(name: String?)
}