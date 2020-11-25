package com.example.madlevel5task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.madlevel5task2.database.GameRepository

class GameViewModel(application: Application) : AndroidViewModel(application){

    private val gameRepository = GameRepository(application.applicationContext)

    val games = gameRepository.getAllGames()



}