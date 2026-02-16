package com.example.project3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.posterImage)
        val title: TextView = view.findViewById(R.id.titleText)
        val overview: TextView = view.findViewById(R.id.overviewText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = movies[position]

        holder.title.text = movie.title
        holder.overview.text = movie.overview

        val imageUrl =
            "https://image.tmdb.org/t/p/w500${movie.posterPath}"

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.poster)
    }
}
