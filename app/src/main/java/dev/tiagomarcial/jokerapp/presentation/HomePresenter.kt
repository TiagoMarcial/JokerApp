package dev.tiagomarcial.jokerapp.presentation

import android.graphics.Color
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

        val start = 40
        val end = 190
        val diff = (start - end) / response.size
        val categories = response.mapIndexed { index, s ->
        val hsv = floatArrayOf(start + (diff * index).toFloat(), 100.0f, 100.0f)
            Category(s, Color.HSVToColor(hsv).toLong()) }
        view.showCategories(categories)
    }


    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}