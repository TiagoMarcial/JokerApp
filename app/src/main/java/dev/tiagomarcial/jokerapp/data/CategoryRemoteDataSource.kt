package dev.tiagomarcial.jokerapp.data

import android.os.Handler
import android.os.Looper
import dev.tiagomarcial.jokerapp.model.Category

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )
            callback.onSucess(response)
            callback.onComplete()
            //onError("FALHA NA CONEXÃO COM O SERVIDOR")
        }, 4000)

    }
}