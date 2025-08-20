package dev.tiagomarcial.jokerapp.data

import dev.tiagomarcial.jokerapp.model.Joke

interface JokeCallback {

    fun onSucess(response: Joke)

    fun onError(response: String)

    fun onComplete()
}