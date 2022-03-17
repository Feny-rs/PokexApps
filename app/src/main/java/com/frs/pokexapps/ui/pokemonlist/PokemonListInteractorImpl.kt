package com.frs.pokexapps.ui.pokemonlist

import com.frs.pokexapps.network.core.NetworkService
import com.frs.pokexapps.network.observer.PokemonListObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonListInteractorImpl : PokemonListInteractor {
    override fun getPokemonList(listener: PokemonListInteractor.PokemonListListener) {
        NetworkService.service()!!.getPokemonList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PokemonListObserver(listener))
    }

}
