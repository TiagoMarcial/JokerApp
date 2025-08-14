package dev.tiagomarcial.jokerapp.presentation

import android.os.Handler
import android.os.Looper
import dev.tiagomarcial.jokerapp.data.CategoryRemoteDataSource
import dev.tiagomarcial.jokerapp.data.ListCategoryCallback
import dev.tiagomarcial.jokerapp.model.Category
import dev.tiagomarcial.jokerapp.view.CategoryItem
import dev.tiagomarcial.jokerapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment, private val dataSource: CategoryRemoteDataSource) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSucess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//
//        for (cateogory in response){
//            categories.add(CategoryItem(cateogory))
//        }

        val categories = response.map { Category(it, 0xFFFF0000) }
        view.showCategories(categories)
    }


    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}