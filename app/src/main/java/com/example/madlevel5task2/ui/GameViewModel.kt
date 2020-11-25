package com.example.madlevel5task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.*

class GameViewModel(application: Application) : AndroidViewModel(application){

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val games = gameRepository.getAllGames()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun addGame(title: String, platform: String, day: Int, month: Int, year: Int){
        val newGame = Game(
            title = title,
            platform = platform,
            day = day,
            month = month,
            year = year
        )

        if(isValid(newGame)){
            mainScope.launch{
                withContext (Dispatchers.IO){
                    gameRepository.insertGame(newGame)
                }
                success.value = true
            }
        }

    }

    fun isValid(game: Game) : Boolean{
        return when{
            game.title.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }
            else -> true
        }

    }

    fun deleteGame(game: Game){
        mainScope.launch{
            gameRepository.deleteGame(game)
        }
    }


}