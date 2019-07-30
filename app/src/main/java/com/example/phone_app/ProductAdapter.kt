package com.example.phone_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.products_layout.view.*

class ProductAdapter(val phones: List<Products>) : RecyclerView.Adapter<ProductAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.products_layout, parent, false)
        )
    }

    override fun getItemCount() = phones.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = phones[position]
      //  holder.view.id = movie.id
        holder.view.phoneName.text = movie.name
        holder.view.price.text = movie.price.toString()
      //  picture
        //  holder.view.textViewType.text = movie.type
      //  description
        //  holder.view.textViewRating.text = movie.rating

       // holder.view.textViewIsNew.visibility = if(movie.isNew == 1) View.VISIBLE else View.INVISIBLE


    }


    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}