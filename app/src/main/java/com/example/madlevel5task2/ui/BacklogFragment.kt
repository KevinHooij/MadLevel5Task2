package com.example.madlevel5task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BacklogFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_backlog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddGamesResult()
    }

    private fun observeAddGamesResult(){
        viewModel.games.observe(viewLifecycleOwner, Observer { games ->
            this@BacklogFragment.games.clear()
            this@BacklogFragment.games.addAll(games)
            gameAdapter.notifyDataSetChanged()
        })

    }
}