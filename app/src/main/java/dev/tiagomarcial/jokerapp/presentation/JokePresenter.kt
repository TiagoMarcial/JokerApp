package dev.tiagomarcial.jokerapp.presentation

import dev.tiagomarcial.jokerapp.data.JokeCallback
import dev.tiagomarcial.jokerapp.data.JokeRemoteDataSource
import dev.tiagomarcial.jokerapp.model.Joke
import dev.tiagomarcial.jokerapp.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val datasource: JokeRemoteDataSource = JokeRemoteDataSource())
    : JokeCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        datasource.findBy(categoryName, this)
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