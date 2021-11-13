package com.example.newsfeed

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class Adapter(var context: Context, var modelClassArrayList: ArrayList<ModelClass>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardView.setOnClickListener {
            val intent = Intent(context, webView::class.java)
            intent.putExtra("url", modelClassArrayList[position].url)
            context.startActivity(intent)
        }
        holder.mtime.text = "Published at:-" + modelClassArrayList[position].publishedAt
        holder.mauthor.text = modelClassArrayList[position].author
        holder.mheading.text = modelClassArrayList[position].title
        holder.mcontent.text = modelClassArrayList[position].description
        Glide.with(context).load(modelClassArrayList[position].urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mheading: TextView
        var mcontent: TextView
        var mauthor: TextView
        var mtime: TextView
        var cardView: CardView
        var imageView: ImageView

        init {
            mheading = itemView.findViewById(R.id.mainheading)
            mcontent = itemView.findViewById(R.id.content)
            mauthor = itemView.findViewById(R.id.author)
            mtime = itemView.findViewById(R.id.time)
            imageView = itemView.findViewById(R.id.imageview)
            cardView = itemView.findViewById(R.id.cardview)
        }
    }
}