package dev.tiagomarcial.jokerapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import dev.tiagomarcial.jokerapp.R
import dev.tiagomarcial.jokerapp.model.Category

class CategoryItem(private val category: Category) : Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getLayout(): Int {
        return R.layout.item_category
    }

}