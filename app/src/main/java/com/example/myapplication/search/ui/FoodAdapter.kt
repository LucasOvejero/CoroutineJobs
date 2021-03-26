package com.example.myapplication.search.ui

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.myapplication.databinding.FoodAdapterLayoutBinding
import com.example.myapplication.search.model.FoodDTO

class FoodAdapter(
    private val foodList: List<FoodDTO> = listOf(),
    private val onclickListener: ((id: String) -> Unit)? = null
) :
    Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(
        private val binding: FoodAdapterLayoutBinding,
        onclickListener: ((id: String) -> Unit)? = null
    ) : ViewHolder(
        binding.root
    ) {
        fun bind(food: FoodDTO) {
            binding.foodBinding = food
            binding.executePendingBindings()
            binding.cardView.setOnClickListener {
                onclickListener?.invoke(food.id)
            }
            //       itemView.findViewById<TextView>(R.id.tvName).text = food.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodAdapterLayoutBinding.inflate(inflater)
        binding.cardView.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        return FoodViewHolder(binding, onclickListener)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])

    }

    override fun getItemCount() = foodList.size
}

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) :
    ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: State
    ) {
        if (parent.getChildAdapterPosition(view) != (parent.adapter?.itemCount ?: 1) - 1) {
            outRect.bottom = verticalSpaceHeight
        }
    }
}