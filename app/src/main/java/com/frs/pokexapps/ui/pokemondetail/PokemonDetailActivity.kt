package com.frs.pokexapps.ui.pokemondetail

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.frs.pokexapps.R
import com.frs.pokexapps.adapter.PokemonAbilityListAdapter
import com.frs.pokexapps.adapter.PokemonMoveListAdapter
import com.frs.pokexapps.model.Ability
import com.frs.pokexapps.model.Move
import com.frs.pokexapps.network.response.PokemonDetailResponse
import com.frs.pokexapps.ui.base.BaseActivity
import com.frs.pokexapps.ui.pokemonlist.KEY_NAME
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*


class PokemonDetailActivity : BaseActivity(), PokemonDetailView {
    private var presenter: PokemonDetailPresenter? = null
    private var pokemonName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        pokemonName = intent.getStringExtra(KEY_NAME)

        presenter = PokemonDetailPresenterImpl(this, PokemonDetailInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonDetail(pokemonName)
    }

    override fun setPokemonDetail(response: PokemonDetailResponse) {
        Picasso.with(this).load(response.sprites?.frontImage).into(ivImage)

        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(5)
            .playOn(findViewById(R.id.ivImage))

        tvName.text = response.name
        tvWeight.text = "weight: ${response.weight.toString()}"
        tvHeight.text = "height: ${response.height.toString()}"
        setPokemonMoveListAdapter(rvMoves, response.moves)
        setPokemonAbilityListAdapter(rvAbilities, response.abilities)
    }

    private fun setPokemonAbilityListAdapter(recyclerView: RecyclerView?, abilities: ArrayList<Ability>?) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = abilities?.let { PokemonAbilityListAdapter(it, this) }
    }

    private fun setPokemonMoveListAdapter(recyclerView: RecyclerView?, moves: ArrayList<Move>?) {

        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = moves?.let { PokemonMoveListAdapter(it, this) }

    }

    override fun showErrorMessage(errorMessage: String) {
        Log.e("error", "errorMessage: $errorMessage")
    }
}
