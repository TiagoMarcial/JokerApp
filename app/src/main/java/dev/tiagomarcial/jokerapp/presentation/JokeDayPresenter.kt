package dev.tiagomarcial.jokerapp.presentation

import dev.tiagomarcial.jokerapp.data.JokeCallback
import dev.tiagomarcial.jokerapp.data.JokeDayRemoteDataSource
import dev.tiagomarcial.jokerapp.data.JokeRemoteDataSource
import dev.tiagomarcial.jokerapp.model.Joke
import dev.tiagomarcial.jokerapp.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val datasource: JokeDayRemoteDataSource = JokeDayRemoteDataSource())
    : JokeCallback {

    fun findRandom() {
        view.showProgress()
        datasource.findRandom(this)
    }

    override fun onSucess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}