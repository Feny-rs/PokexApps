package com.frs.pokexapps.network.observer

import android.text.TextUtils
import com.frs.pokexapps.network.response.PokemonListResponse
import com.frs.pokexapps.ui.pokemonlist.PokemonListInteractor

class PokemonListObserver(private var listener: PokemonListInteractor.PokemonListListener) :
    BaseObserver<PokemonListResponse>() {

    override fun onNext(response: PokemonListResponse) {
        listener.onPokemonListSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonListFailed(e, errorMessage)
        }
    }

}