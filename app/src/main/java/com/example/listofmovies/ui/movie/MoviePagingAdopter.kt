package com.example.listofmovies.ui.movie

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.listofmovies.BR
import com.example.listofmovies.data.Movie
import com.example.listofmovies.databinding.ViewHolderMovieBinding

class MoviePagingAdopter: PagingDataAdapter<Movie, MoviePagingAdopter.myViewHolder>(DIFF_UTIL){


    var onClick : ((String)->Unit)?=null


    companion object{
        val DIFF_UTIL = object :DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
               return oldItem.imdbID==newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun onMovieClick(listener: (String)->Unit){
        onClick=listener
    }

    inner class myViewHolder(val viewDataBinding: ViewHolderMovieBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val data = getItem(position)
        holder.viewDataBinding.setVariable(BR.movie,data)

        holder.viewDataBinding.root.setOnClickListener {
            onClick?.let {
                it(data?.imdbID!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding= ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

}